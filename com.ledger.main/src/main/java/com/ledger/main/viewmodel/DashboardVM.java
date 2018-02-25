package com.ledger.main.viewmodel;

import com.ledger.common.application.finance.management.ActivaTetapService;
import com.ledger.common.application.finance.management.HutangService;
import com.ledger.common.application.finance.management.PersediaanService;
import com.ledger.common.application.finance.management.PiutangService;
import com.ledger.common.application.finance.management.SaldoKasService;
import com.ledger.common.dto.finance.management.ActivaTetapDTO;
import com.ledger.common.dto.finance.management.ActivaTetapDTOBuilder;
import com.ledger.common.dto.finance.management.HutangDTO;
import com.ledger.common.dto.finance.management.HutangDTOBuilder;
import com.ledger.common.dto.finance.management.PersediaanDTO;
import com.ledger.common.dto.finance.management.PersediaanDTOBuilder;
import com.ledger.common.dto.finance.management.PiutangDTO;
import com.ledger.common.dto.finance.management.PiutangDTOBuilder;
import com.ledger.common.dto.finance.management.SaldoKasDTO;
import com.ledger.common.dto.finance.management.SaldoKasDTOBuilder;
import com.ledger.common.dto.finance.management.asset.AssetDTO;
import com.ledger.common.dto.usermanagement.UserDTO;
import com.ledger.common.security.SecurityUtil;
import com.ledger.shared.status.Status;
import com.ledger.shared.zul.CommonViewModel;
import static com.ledger.shared.zul.CommonViewModel.showInformationMessagebox;
import com.ledger.shared.zul.PageNavigation;
import com.ledger.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DashboardVM {

    @WireVariable
    SaldoKasService saldoKasService;
    @WireVariable
    HutangService hutangService;
    @WireVariable
    PiutangService piutangService;
    @WireVariable
    PersediaanService persediaanService;
    @WireVariable
    ActivaTetapService activaTetapService;

    /* data user */
    private UserDTO user;
    private String userNPWP;
    private String role;
    private String uriPhoto;

    /* data saldo kas */
    private SaldoKasDTO saldoKasDTO = new SaldoKasDTO();
    private double saldoKasBank;

    /* data hutang */
    private HutangDTO hutangDTO = new HutangDTO();
    private List<HutangDTO> hutangDTOs = new ArrayList<>();
    private String namaHutang;
    private double jumlahHutang;
    private String statusHutang;
    private String namaHutangNew;
    private double jumlahHutangNew;
    private String statusHutangNew;
    private ListModelList<String> listStatusHutang = new ListModelList<>();

    /* data piutang */
    private PiutangDTO piutangDTO = new PiutangDTO();
    private List<PiutangDTO> piutangDTOs = new ArrayList<>();
    private String namaPiutang;
    private double jumlahPiutang;
    private String statusPiutang;
    private String namaPiutangNew;
    private double jumlahPiutangNew;
    private String statusPiutangNew;
    private ListModelList<String> listStatusPiutang = new ListModelList<>();

    /* data persediaan */
    private PersediaanDTO persediaanDTO = new PersediaanDTO();
    private List<PersediaanDTO> persediaanDTOs = new ArrayList<>();
    private String namaPersediaan;
    private String jenisPersediaan;
    private int jumlahPersediaan;
    private double hargaPersediaan;
    private double totalHargaPersediaan;
    private String namaPersediaanNew;
    private String jenisPersediaanNew;
    private int jumlahPersediaanNew;
    private double hargaPersediaanNew;
    private double totalHargaPersediaanNew;
    private ListModelList<String> listJenisPersediaan = new ListModelList<>();

    /* data activa tetap */
    private ActivaTetapDTO activaTetapDTO = new ActivaTetapDTO();
    private List<ActivaTetapDTO> activaTetapDTOs = new ArrayList<>();
    private String namaActivaTetap;
    private double hargaActivaTetap;
    private int lamaPemakaian;
    private int jangkaWaktuPenyusutan;
    private int persenPenyusutan;
    private double nilaiPenyusutan;
    private String namaActivaTetapNew;
    private double hargaActivaTetapNew;
    private int lamaPemakaianNew;
    private int jangkaWaktuPenyusutanNew;
    private int persenPenyusutanNew;
    private double nilaiPenyusutanNew;
    private boolean isPenyusutan;
    private boolean isPenyusutanNew;

    /* data page */
    private String src;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 3;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    /* form panel active inactive */
    private boolean panelBefore;
    private boolean panelAfter;

    /* form paging purpose */
    private boolean dashboardForm;
    private boolean introForm;
    private boolean step1Form;
    private boolean step2Form;
    private boolean step3Form;
    private boolean step4Form;
    private boolean step5Form;
    private boolean initialForm;

    /* form summary purpose */
    private double totalKasBank;
    private double totalPiutang;
    private double totalPersediaan;
    private double nilaiActivaTetap;
    private double nilaiTotalPenyusutan;
    private double nilaiBukuAssetTetap;
    private double totalAsset;

    @Init
    public void init(
            @ExecutionArgParam("saldoKasDTO") SaldoKasDTO saldoKas,
            @ExecutionArgParam("hutangDTO") HutangDTO hutang,
            @ExecutionArgParam("piutangDTO") PiutangDTO piutang,
            @ExecutionArgParam("persediaanDTO") PersediaanDTO persediaan,
            @ExecutionArgParam("activaTetapDTO") ActivaTetapDTO activaTetap,
            @ExecutionArgParam("previous") PageNavigation previous) {
        Map params = new HashMap();
        Status status = Status.ACTIVE;
        params.put("status", status);

        userNPWP = SecurityUtil.getUserName();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();
        user = SecurityUtil.getUser();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();

        initData();

    }

    private void initData() {
        saldoKasDTO = saldoKasService.findByUserID(SecurityUtil.getUserName());
        if (saldoKasDTO != null) {
            saldoKasBank = saldoKasDTO.getSaldoKasBank();
            totalKasBank = saldoKasBank;
        } else {
            saldoKasDTO = new SaldoKasDTOBuilder()
                    .setSaldoKasID(UUID.randomUUID().toString())
                    .setUserID(SecurityUtil.getUserName())
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createSaldoKasDTO();
        }

        hutangDTOs = hutangService.findByUserID(SecurityUtil.getUserName());
        for (HutangDTO h : hutangDTOs) {
            hutangDTO = hutangService.findByID(h.getHutangID());
            namaHutang = h.getNamaHutang();
            jumlahHutang = h.getJumlahHutang();
            statusHutang = h.getStatus();
        }
        piutangDTOs = piutangService.findByUserID(SecurityUtil.getUserName());
        for (PiutangDTO p : piutangDTOs) {
            piutangDTO = piutangService.findByID(p.getPiutangID());
            namaPiutang = p.getNamaPiutang();
            jumlahPiutang = p.getJumlahPiutang();
            statusPiutang = p.getStatus();
            totalPiutang += jumlahPiutang;
        }
        persediaanDTOs = persediaanService.findByUserID(SecurityUtil.getUserName());
        for (PersediaanDTO ps : persediaanDTOs) {
            persediaanDTO = persediaanService.findByID(ps.getPersediaanID());
            namaPersediaan = ps.getNamaPersediaan();
            jenisPersediaan = ps.getJenisPersediaan();
            jumlahPersediaan = ps.getJumlahPersediaan();
            hargaPersediaan = ps.getHargaPersediaan();
            totalHargaPersediaan = ps.getTotalHargaPersediaan();
            totalPersediaan += totalHargaPersediaan;
        }
        activaTetapDTOs = activaTetapService.findByUserID(SecurityUtil.getUserName());
        for (ActivaTetapDTO at : activaTetapDTOs) {
            activaTetapDTO = activaTetapService.findByID(at.getActivaTetapID());
            namaActivaTetap = at.getNamaActivaTetap();
            hargaActivaTetap = at.getHargaActivaTetap();
            lamaPemakaian = at.getLamaPemakaian();
            jangkaWaktuPenyusutan = at.getJangkaWaktuPenyusutan();
            persenPenyusutan = at.getPersenPenyusutan();
            nilaiPenyusutan = at.getTotalPenyusutan();
            nilaiActivaTetap += hargaActivaTetap;
            nilaiTotalPenyusutan += nilaiPenyusutan;
        }

        nilaiBukuAssetTetap = nilaiActivaTetap - nilaiTotalPenyusutan;
        totalAsset = nilaiBukuAssetTetap + totalKasBank + totalPiutang + totalPersediaan;

        /* calculation summary */
        /* dummy for listbox/comcobox */
        listStatusHutang.add("LUNAS");
        listStatusHutang.add("BELUM LUNAS");
        listStatusPiutang.add("LUNAS");
        listStatusPiutang.add("BELUM LUNAS");
        listJenisPersediaan.add("BAHAN BAKU");
        listJenisPersediaan.add("BARANG JADI");
        listJenisPersediaan.add("BARANG SETENGAH JADI");

        if (user.getUserSpecificationDTO().getEscute().equalsIgnoreCase("JASA")) {
            if (saldoKasDTO != null && !hutangDTOs.isEmpty() && !piutangDTOs.isEmpty() && !activaTetapDTOs.isEmpty()) {
                panelAfter = true;
                panelBefore = false;
            } else {
                panelAfter = false;
                panelBefore = true;
            }

            introForm = true;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = false;
        } else {
            if (saldoKasDTO != null && !hutangDTOs.isEmpty() && !piutangDTOs.isEmpty() && !persediaanDTOs.isEmpty() && !activaTetapDTOs.isEmpty()) {
                panelAfter = true;
                panelBefore = false;
            } else {
                panelAfter = false;
                panelBefore = true;
            }

            introForm = true;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = false;
        }
    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }


    /* helper */
    public String concatUsername(String s1, String s2) {
        return s1.concat(s2);
    }

    /* helper */
    public String concatString(String s1, String s2, String s3) {
        return s1.concat(s2).concat(s3);
    }

    /* helper */
    public String concatString2(String s1, String s2, String s3, String s4) {
        return s1.concat(s2).concat(s3).concat(s4);
    }

    public String concatDate(String s1, Date s2) {
        return s1.concat(DateUtil.dateToString(s2, "dd-MMM-yyy HH:mm:ss"));
    }

    @Command("buttonKlikMulai")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form", "saldoKasDTO"})
    public void buttonKlikMulai(@ContextParam(ContextType.VIEW) Window window) {
        introForm = false;
        step1Form = true;
        step2Form = false;
        step3Form = false;
        step4Form = false;
        step5Form = false;
        initialForm = false;
    }

    @Command("buttonKlikNextForm1")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form", "saldoKasDTO"})
    public void buttonKlikNextForm1(@ContextParam(ContextType.VIEW) Window window) {
        if (saldoKasBank == 0) {
            Messagebox.show("Data saldo tidak boleh 0!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else {

            introForm = false;
            step1Form = false;
            step2Form = true;
            step3Form = false;
            step4Form = false;
            step5Form = false;

            if (saldoKasDTO == null) {
                saldoKasDTO.setSaldoKasBank(saldoKasBank);
                saldoKasService.SaveOrUpdate(saldoKasDTO);
            } else {
                saldoKasDTO.setModifiedBy(SecurityUtil.getUserName());
                saldoKasDTO.setModifiedDate(new Date());
                saldoKasDTO.setSaldoKasBank(saldoKasBank);
                saldoKasService.SaveOrUpdate(saldoKasDTO);
            }
        }

    }

    @Command("buttonKlikNextForm2")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikNextForm2(@ContextParam(ContextType.VIEW) Window window) {
        if (hutangDTOs.isEmpty()) {
            Messagebox.show("Anda belum mengisi data hutang!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = true;
            step4Form = false;
            step5Form = false;
        }
    }

    @Command("buttonKlikBackForm2")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikBackForm2(@ContextParam(ContextType.VIEW) Window window) {
        introForm = false;
        step1Form = true;
        step2Form = false;
        step3Form = false;
        step4Form = false;
        step5Form = false;
    }

    @Command("buttonTambahHutangNew")
    @NotifyChange("hutangDTO")
    public void buttonTambahHutangNew(@ContextParam(ContextType.VIEW) Window window) {
        hutangDTO = new HutangDTO();
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/new.hutang.zul", window, null);
    }

    @Command("buttonTambahHutang")
    @NotifyChange("hutangDTO")
    public void buttonTambahHutang(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.hutang.zul", window, null);
    }

    @Command("buttonKembaliHutang")
    @NotifyChange({"hutangDTO", "hutangDTOs"})
    public void buttonKembali(@BindingParam("object") HutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSimpanHutang")
    @NotifyChange("hutangDTO")
    public void buttonSimpanHutang(@BindingParam("object") HutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        hutangDTO.setNamaHutang(namaHutang);
        hutangDTO.setJumlahHutang(jumlahHutang);
        hutangDTO.setStatus(statusHutang);
        hutangDTO.setUserID(SecurityUtil.getUserName());
        hutangDTO.setModifiedBy(SecurityUtil.getUserName());
        hutangDTO.setModifiedDate(new Date());
        hutangService.SaveOrUpdate(hutangDTO);
        showInformationMessagebox("Data Hutang Berhasil Diperbaharui");
        BindUtils.postGlobalCommand(null, null, "refreshDataHutang", null);
        window.detach();
    }

    @Command("buttonSimpanHutangNew")
    @NotifyChange("hutangDTO")
    public void buttonSimpanHutangNew(@BindingParam("object") HutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        hutangDTO = new HutangDTOBuilder()
                .setHutangID(UUID.randomUUID().toString())
                .setNamaHutang(namaHutangNew)
                .setJumlahHutang(jumlahHutangNew)
                .setStatus(statusHutangNew)
                .setUserID(SecurityUtil.getUserName())
                .setCreatedBy(SecurityUtil.getUserName())
                .setCreatedDate(new Date())
                .createHutangDTO();
        hutangService.SaveOrUpdate(hutangDTO);
        showInformationMessagebox("Data Hutang Berhasil Ditambahkan");
        BindUtils.postGlobalCommand(null, null, "refreshDataHutang", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("hutangDTOs")
    public void refreshDataHutang() {
        hutangDTOs = hutangService.findByUserID(SecurityUtil.getUserName());
    }

    @Command("detailHutang")
    @NotifyChange({"hutangDTO", "namaHutang", "jumlahHutang", "statusHutang"})
    public void detailHutang(@BindingParam("object") HutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("hutangDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.hutang.zul", window, params);
    }

    @Command("deleteHutang")
    @NotifyChange("hutangDTOs")
    public void deleteHutang(@BindingParam("object") HutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        hutangDTO = (HutangDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Data Hutang?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            hutangService.deleteData(hutangDTO);
                            showInformationMessagebox("Data Hutang Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshDataHutang", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    @Command("buttonKlikNextForm3")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikNextForm3(@ContextParam(ContextType.VIEW) Window window) {
        if (piutangDTOs.isEmpty()) {
            Messagebox.show("Anda belum mengisi data piutang!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = true;
            step5Form = false;
        }
    }

    @Command("buttonKlikBackForm3")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikBackForm3(@ContextParam(ContextType.VIEW) Window window) {
        introForm = false;
        step1Form = false;
        step2Form = true;
        step3Form = false;
        step4Form = false;
        step5Form = false;
    }

    @Command("buttonTambahPiutangNew")
    @NotifyChange("piutangDTO")
    public void buttonTambahPiutangNew(@ContextParam(ContextType.VIEW) Window window) {
        piutangDTO = new PiutangDTO();
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/new.piutang.zul", window, null);
    }

    @Command("buttonTambahPiutang")
    @NotifyChange("piutangDTO")
    public void buttonTambahPiutang(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.piutang.zul", window, null);
    }

    @Command("buttonKembaliPiutang")
    @NotifyChange({"piutangDTO", "piutangDTOs"})
    public void buttonKembali(@BindingParam("object") PiutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSimpanPiutang")
    @NotifyChange("piutangDTO")
    public void buttonSimpanPiutang(@BindingParam("object") PiutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        piutangDTO.setNamaPiutang(namaPiutang);
        piutangDTO.setJumlahPiutang(jumlahPiutang);
        piutangDTO.setStatus(statusPiutang);
        piutangDTO.setUserID(SecurityUtil.getUserName());
        piutangDTO.setModifiedBy(SecurityUtil.getUserName());
        piutangDTO.setModifiedDate(new Date());
        piutangService.SaveOrUpdate(piutangDTO);
        showInformationMessagebox("Data Piutang Berhasil Diperbaharui");
        BindUtils.postGlobalCommand(null, null, "refreshDataPiutang", null);
        window.detach();
    }

    @Command("buttonSimpanPiutangNew")
    @NotifyChange("piutangDTO")
    public void buttonSimpanPiutangNew(@BindingParam("object") PiutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        piutangDTO = new PiutangDTOBuilder()
                .setPiutangID(UUID.randomUUID().toString())
                .setNamaPiutang(namaPiutangNew)
                .setJumlahPiutang(jumlahPiutangNew)
                .setStatus(statusPiutangNew)
                .setUserID(SecurityUtil.getUserName())
                .setCreatedBy(SecurityUtil.getUserName())
                .setCreatedDate(new Date())
                .createPiutangDTO();
        piutangService.SaveOrUpdate(piutangDTO);
        showInformationMessagebox("Data Piutang Berhasil Ditambahkan");
        BindUtils.postGlobalCommand(null, null, "refreshDataPiutang", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("piutangDTOs")
    public void refreshDataPiutang() {
        piutangDTOs = piutangService.findByUserID(SecurityUtil.getUserName());
    }

    @Command("detailPiutang")
    @NotifyChange({"piutangDTO", "namaPiutang", "jumlahPiutang", "statusPiutang"})
    public void detailPiutang(@BindingParam("object") PiutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("piutangDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.piutang.zul", window, params);
    }

    @Command("deletePiutang")
    @NotifyChange("piutangDTOs")
    public void deletePiutang(@BindingParam("object") PiutangDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        piutangDTO = (PiutangDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Data Piutang?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            piutangService.deleteData(piutangDTO);
                            showInformationMessagebox("Data Piutang Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshDataPiutang", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    @Command("buttonKlikNextForm4")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikNextForm4(@ContextParam(ContextType.VIEW) Window window) {
        if (user.getUserSpecificationDTO().getEscute().equalsIgnoreCase("JASA")) {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = true;
        } else {
            if (persediaanDTOs.isEmpty()) {
                Messagebox.show("Anda belum mengisi data persediaan!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            } else {
                introForm = false;
                step1Form = false;
                step2Form = false;
                step3Form = false;
                step4Form = false;
                step5Form = true;
            }
        }
    }

    @Command("buttonKlikBackForm4")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikBackForm4(@ContextParam(ContextType.VIEW) Window window) {
        introForm = false;
        step1Form = false;
        step2Form = false;
        step3Form = true;
        step4Form = false;
        step5Form = false;
    }

    @Command("buttonTambahPersediaanNew")
    @NotifyChange("persediaanDTO")
    public void buttonTambahPersediaanNew(@ContextParam(ContextType.VIEW) Window window) {
        persediaanDTO = new PersediaanDTO();
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/new.persediaan.zul", window, null);
    }

    @Command("buttonTambahPersediaan")
    @NotifyChange("persediaanDTO")
    public void buttonTambahPersediaan(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.persediaan.zul", window, null);
    }

    @Command("buttonKembaliPersediaan")
    @NotifyChange({"persediaanDTO", "persediaanDTOs"})
    public void buttonKembali(@BindingParam("object") PersediaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSimpanPersediaan")
    @NotifyChange("persediaanDTO")
    public void buttonSimpanPersediaan(@BindingParam("object") PersediaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        persediaanDTO.setNamaPersediaan(namaPersediaan);
        persediaanDTO.setJumlahPersediaan(jumlahPersediaan);
        persediaanDTO.setJenisPersediaan(jenisPersediaan);
        persediaanDTO.setHargaPersediaan(hargaPersediaan);
        persediaanDTO.setTotalHargaPersediaan(jumlahPersediaan * hargaPersediaan);
        persediaanDTO.setUserID(SecurityUtil.getUserName());
        persediaanDTO.setModifiedBy(SecurityUtil.getUserName());
        persediaanDTO.setModifiedDate(new Date());
        persediaanService.SaveOrUpdate(persediaanDTO);
        showInformationMessagebox("Data Persediaan Berhasil Diperbaharui");
        BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
        window.detach();
    }

    @Command("buttonSimpanPersediaanNew")
    @NotifyChange("persediaanDTO")
    public void buttonSimpanPersediaanNew(@BindingParam("object") PersediaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        persediaanDTO = new PersediaanDTOBuilder()
                .setPersediaanID(UUID.randomUUID().toString())
                .setNamaPersediaan(namaPersediaanNew)
                .setJumlahPersediaan(jumlahPersediaanNew)
                .setJenisPersediaan(jenisPersediaanNew)
                .setHargaPersediaan(hargaPersediaanNew)
                .setTotalHargaPersediaan(jumlahPersediaanNew * hargaPersediaanNew)
                .setUserID(SecurityUtil.getUserName())
                .setCreatedBy(SecurityUtil.getUserName())
                .setCreatedDate(new Date())
                .createPersediaanDTO();
        persediaanService.SaveOrUpdate(persediaanDTO);
        showInformationMessagebox("Data Persediaan Berhasil Ditambahkan");
        BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("persediaanDTOs")
    public void refreshDataPersediaan() {
        persediaanDTOs = persediaanService.findByUserID(SecurityUtil.getUserName());
    }

    @Command("detailPersediaan")
    @NotifyChange({"persediaanDTO", "namaPersediaan", "jumlahPersediaan", "jenisPersediaan", "hargaPersediaan", "totalHargaPersediaan"})
    public void detailPersediaan(@BindingParam("object") PersediaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("persediaanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.persediaan.zul", window, params);
    }

    @Command("deletePersediaan")
    @NotifyChange("persediaanDTOs")
    public void deletePersediaan(@BindingParam("object") PersediaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        persediaanDTO = (PersediaanDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Data Persediaan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            persediaanService.deleteData(persediaanDTO);
                            showInformationMessagebox("Data Persediaan Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    @Command("buttonKlikFinishForm5")
    @NotifyChange({"panelAfter", "panelBefore", "introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikFinishForm5(@ContextParam(ContextType.VIEW) Window window) {
        if (activaTetapDTOs.isEmpty()) {
            Messagebox.show("Anda belum mengisi data activa tetap!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = false;
            panelBefore = false;
            panelAfter = true;
        }
    }

    @Command("buttonKlikBackForm5")
    @NotifyChange({"introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikBackForm5(@ContextParam(ContextType.VIEW) Window window) {
        introForm = false;
        step1Form = false;
        step2Form = false;
        step3Form = false;
        step4Form = true;
        step5Form = false;
    }

    @Command("buttonTambahActivaTetapNew")
    @NotifyChange("activaTetapDTO")
    public void buttonTambahActivaTetapNew(@ContextParam(ContextType.VIEW) Window window) {
        activaTetapDTO = new ActivaTetapDTO();
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/new.activatetap.zul", window, null);
    }

    @Command("buttonTambahActivaTetap")
    @NotifyChange("activaTetapDTO")
    public void buttonTambahActivaTetap(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.activatetap.zul", window, null);
    }

    @Command("buttonKembaliActivaTetap")
    @NotifyChange({"activaTetapDTO", "activaTetapDTOs"})
    public void buttonKembali(@BindingParam("object") ActivaTetapDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSimpanActivaTetap")
    @NotifyChange("activaTetapDTO")
    public void buttonSimpanActivaTetap(@BindingParam("object") ActivaTetapDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        activaTetapDTO.setNamaActivaTetap(namaActivaTetap);
        activaTetapDTO.setHargaActivaTetap(hargaActivaTetap);
        activaTetapDTO.setLamaPemakaian(lamaPemakaian);
        activaTetapDTO.setJangkaWaktuPenyusutan(jangkaWaktuPenyusutan);
        activaTetapDTO.setPersenPenyusutan(persenPenyusutan);
        activaTetapDTO.setTotalPenyusutan((hargaActivaTetap / jangkaWaktuPenyusutan) * (jangkaWaktuPenyusutan - lamaPemakaian) * (persenPenyusutan / 100));
        activaTetapDTO.setUserID(SecurityUtil.getUserName());
        activaTetapDTO.setModifiedBy(SecurityUtil.getUserName());
        activaTetapDTO.setModifiedDate(new Date());
        activaTetapService.SaveOrUpdate(activaTetapDTO);
        showInformationMessagebox("Data ActivaTetap Berhasil Diperbaharui");
        BindUtils.postGlobalCommand(null, null, "refreshDataActivaTetap", null);
        window.detach();
    }

    @Command("buttonSimpanActivaTetapNew")
    @NotifyChange("activaTetapDTO")
    public void buttonSimpanActivaTetapNew(@BindingParam("object") ActivaTetapDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        double totalPenyusutan = 0.0;
        if (jangkaWaktuPenyusutanNew != 0 & lamaPemakaianNew != 0 && persenPenyusutanNew != 0) {
            totalPenyusutan = ((hargaActivaTetapNew / jangkaWaktuPenyusutanNew) * (jangkaWaktuPenyusutanNew - lamaPemakaianNew) * (persenPenyusutanNew)) / 100;
        } else {
            totalPenyusutan = 0.0;
        }

        activaTetapDTO = new ActivaTetapDTOBuilder()
                .setActivaTetapID(UUID.randomUUID().toString())
                .setNamaActivaTetap(namaActivaTetapNew)
                .setHargaActivaTetap(hargaActivaTetapNew)
                .setLamaPemakaian(lamaPemakaianNew)
                .setJangkaWaktuPenyusutan(jangkaWaktuPenyusutanNew)
                .setPersenPenyusutan(persenPenyusutanNew)
                .setTotalPenyusutan(totalPenyusutan)
                .setUserID(SecurityUtil.getUserName())
                .setCreatedBy(SecurityUtil.getUserName())
                .setCreatedDate(new Date())
                .createActivaTetapDTO();
        activaTetapService.SaveOrUpdate(activaTetapDTO);
        showInformationMessagebox("Data ActivaTetap Berhasil Ditambahkan");
        BindUtils.postGlobalCommand(null, null, "refreshDataActivaTetap", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("activaTetapDTOs")
    public void refreshDataActivaTetap() {
        activaTetapDTOs = activaTetapService.findByUserID(SecurityUtil.getUserName());
    }

    @Command("detailActivaTetap")
    @NotifyChange({"activaTetapDTO", "namaActivaTetap", "jumlahActivaTetap", "jenisActivaTetap", "hargaActivaTetap", "totalHargaActivaTetap"})
    public void detailActivaTetap(@BindingParam("object") ActivaTetapDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("activaTetapDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/tambah.activatetap.zul", window, params);
    }

    @Command("deleteActivaTetap")
    @NotifyChange("activaTetapDTOs")
    public void deleteActivaTetap(@BindingParam("object") ActivaTetapDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        activaTetapDTO = (ActivaTetapDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Data ActivaTetap?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            activaTetapService.deleteData(activaTetapDTO);
                            showInformationMessagebox("Data ActivaTetap Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshDataActivaTetap", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    /* Getter&Setter */
    public String getUserNPWP() {
        return userNPWP;
    }

    public void setUserNPWP(String userNPWP) {
        this.userNPWP = userNPWP;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUriPhoto() {
        return uriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        this.uriPhoto = uriPhoto;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getActivePage() {
        return activePage;
    }

    public void setActivePage(int activePage) {
        this.activePage = activePage;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public boolean isDashboardForm() {
        return dashboardForm;
    }

    public void setDashboardForm(boolean dashboardForm) {
        this.dashboardForm = dashboardForm;
    }

    public boolean isIntroForm() {
        return introForm;
    }

    public void setIntroForm(boolean introForm) {
        this.introForm = introForm;
    }

    public boolean isStep1Form() {
        return step1Form;
    }

    public void setStep1Form(boolean step1Form) {
        this.step1Form = step1Form;
    }

    public boolean isStep2Form() {
        return step2Form;
    }

    public void setStep2Form(boolean step2Form) {
        this.step2Form = step2Form;
    }

    public boolean isStep3Form() {
        return step3Form;
    }

    public void setStep3Form(boolean step3Form) {
        this.step3Form = step3Form;
    }

    public boolean isStep4Form() {
        return step4Form;
    }

    public void setStep4Form(boolean step4Form) {
        this.step4Form = step4Form;
    }

    public boolean isStep5Form() {
        return step5Form;
    }

    public void setStep5Form(boolean step5Form) {
        this.step5Form = step5Form;
    }

    public boolean isInitialForm() {
        return initialForm;
    }

    public void setInitialForm(boolean initialForm) {
        this.initialForm = initialForm;
    }

    public boolean isPanelBefore() {
        return panelBefore;
    }

    public void setPanelBefore(boolean panelBefore) {
        this.panelBefore = panelBefore;
    }

    public boolean isPanelAfter() {
        return panelAfter;
    }

    public void setPanelAfter(boolean panelAfter) {
        this.panelAfter = panelAfter;
    }

    public SaldoKasDTO getSaldoKasDTO() {
        return saldoKasDTO;
    }

    public void setSaldoKasDTO(SaldoKasDTO saldoKasDTO) {
        this.saldoKasDTO = saldoKasDTO;
    }

    public HutangDTO getHutangDTO() {
        return hutangDTO;
    }

    public void setHutangDTO(HutangDTO hutangDTO) {
        this.hutangDTO = hutangDTO;
    }

    public List<HutangDTO> getHutangDTOs() {
        return hutangDTOs;
    }

    public void setHutangDTOs(List<HutangDTO> hutangDTOs) {
        this.hutangDTOs = hutangDTOs;
    }

    public PiutangDTO getPiutangDTO() {
        return piutangDTO;
    }

    public void setPiutangDTO(PiutangDTO piutangDTO) {
        this.piutangDTO = piutangDTO;
    }

    public List<PiutangDTO> getPiutangDTOs() {
        return piutangDTOs;
    }

    public void setPiutangDTOs(List<PiutangDTO> piutangDTOs) {
        this.piutangDTOs = piutangDTOs;
    }

    public PersediaanDTO getPersediaanDTO() {
        return persediaanDTO;
    }

    public void setPersediaanDTO(PersediaanDTO persediaanDTO) {
        this.persediaanDTO = persediaanDTO;
    }

    public List<PersediaanDTO> getPersediaanDTOs() {
        return persediaanDTOs;
    }

    public void setPersediaanDTOs(List<PersediaanDTO> persediaanDTOs) {
        this.persediaanDTOs = persediaanDTOs;
    }

    public ActivaTetapDTO getActivaTetapDTO() {
        return activaTetapDTO;
    }

    public void setActivaTetapDTO(ActivaTetapDTO activaTetapDTO) {
        this.activaTetapDTO = activaTetapDTO;
    }

    public List<ActivaTetapDTO> getActivaTetapDTOs() {
        return activaTetapDTOs;
    }

    public void setActivaTetapDTOs(List<ActivaTetapDTO> activaTetapDTOs) {
        this.activaTetapDTOs = activaTetapDTOs;
    }

    public double getSaldoKasBank() {
        return saldoKasBank;
    }

    public void setSaldoKasBank(double saldoKasBank) {
        this.saldoKasBank = saldoKasBank;
    }

    public String getNamaHutang() {
        return namaHutang;
    }

    public void setNamaHutang(String namaHutang) {
        this.namaHutang = namaHutang;
    }

    public double getJumlahHutang() {
        return jumlahHutang;
    }

    public void setJumlahHutang(double jumlahHutang) {
        this.jumlahHutang = jumlahHutang;
    }

    public String getStatusHutang() {
        return statusHutang;
    }

    public void setStatusHutang(String statusHutang) {
        this.statusHutang = statusHutang;
    }

    public ListModelList<String> getListStatusHutang() {
        return listStatusHutang;
    }

    public void setListStatusHutang(ListModelList<String> listStatusHutang) {
        this.listStatusHutang = listStatusHutang;
    }

    public String getNamaHutangNew() {
        return namaHutangNew;
    }

    public void setNamaHutangNew(String namaHutangNew) {
        this.namaHutangNew = namaHutangNew;
    }

    public double getJumlahHutangNew() {
        return jumlahHutangNew;
    }

    public void setJumlahHutangNew(double jumlahHutangNew) {
        this.jumlahHutangNew = jumlahHutangNew;
    }

    public String getStatusHutangNew() {
        return statusHutangNew;
    }

    public void setStatusHutangNew(String statusHutangNew) {
        this.statusHutangNew = statusHutangNew;
    }

    public String getNamaPiutang() {
        return namaPiutang;
    }

    public void setNamaPiutang(String namaPiutang) {
        this.namaPiutang = namaPiutang;
    }

    public double getJumlahPiutang() {
        return jumlahPiutang;
    }

    public void setJumlahPiutang(double jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
    }

    public String getStatusPiutang() {
        return statusPiutang;
    }

    public void setStatusPiutang(String statusPiutang) {
        this.statusPiutang = statusPiutang;
    }

    public String getNamaPiutangNew() {
        return namaPiutangNew;
    }

    public void setNamaPiutangNew(String namaPiutangNew) {
        this.namaPiutangNew = namaPiutangNew;
    }

    public double getJumlahPiutangNew() {
        return jumlahPiutangNew;
    }

    public void setJumlahPiutangNew(double jumlahPiutangNew) {
        this.jumlahPiutangNew = jumlahPiutangNew;
    }

    public String getStatusPiutangNew() {
        return statusPiutangNew;
    }

    public void setStatusPiutangNew(String statusPiutangNew) {
        this.statusPiutangNew = statusPiutangNew;
    }

    public ListModelList<String> getListStatusPiutang() {
        return listStatusPiutang;
    }

    public void setListStatusPiutang(ListModelList<String> listStatusPiutang) {
        this.listStatusPiutang = listStatusPiutang;
    }

    public String getNamaPersediaan() {
        return namaPersediaan;
    }

    public void setNamaPersediaan(String namaPersediaan) {
        this.namaPersediaan = namaPersediaan;
    }

    public String getJenisPersediaan() {
        return jenisPersediaan;
    }

    public void setJenisPersediaan(String jenisPersediaan) {
        this.jenisPersediaan = jenisPersediaan;
    }

    public int getJumlahPersediaan() {
        return jumlahPersediaan;
    }

    public void setJumlahPersediaan(int jumlahPersediaan) {
        this.jumlahPersediaan = jumlahPersediaan;
    }

    public double getHargaPersediaan() {
        return hargaPersediaan;
    }

    public void setHargaPersediaan(double hargaPersediaan) {
        this.hargaPersediaan = hargaPersediaan;
    }

    public double getTotalHargaPersediaan() {
        return totalHargaPersediaan;
    }

    public void setTotalHargaPersediaan(double totalHargaPersediaan) {
        this.totalHargaPersediaan = totalHargaPersediaan;
    }

    public String getNamaPersediaanNew() {
        return namaPersediaanNew;
    }

    public void setNamaPersediaanNew(String namaPersediaanNew) {
        this.namaPersediaanNew = namaPersediaanNew;
    }

    public String getJenisPersediaanNew() {
        return jenisPersediaanNew;
    }

    public void setJenisPersediaanNew(String jenisPersediaanNew) {
        this.jenisPersediaanNew = jenisPersediaanNew;
    }

    public int getJumlahPersediaanNew() {
        return jumlahPersediaanNew;
    }

    public void setJumlahPersediaanNew(int jumlahPersediaanNew) {
        this.jumlahPersediaanNew = jumlahPersediaanNew;
    }

    public double getHargaPersediaanNew() {
        return hargaPersediaanNew;
    }

    public void setHargaPersediaanNew(double hargaPersediaanNew) {
        this.hargaPersediaanNew = hargaPersediaanNew;
    }

    public double getTotalHargaPersediaanNew() {
        return totalHargaPersediaanNew;
    }

    public void setTotalHargaPersediaanNew(double totalHargaPersediaanNew) {
        this.totalHargaPersediaanNew = totalHargaPersediaanNew;
    }

    public ListModelList<String> getListJenisPersediaan() {
        return listJenisPersediaan;
    }

    public void setListJenisPersediaan(ListModelList<String> listJenisPersediaan) {
        this.listJenisPersediaan = listJenisPersediaan;
    }

    public String getNamaActivaTetap() {
        return namaActivaTetap;
    }

    public void setNamaActivaTetap(String namaActivaTetap) {
        this.namaActivaTetap = namaActivaTetap;
    }

    public int getLamaPemakaian() {
        return lamaPemakaian;
    }

    public void setLamaPemakaian(int lamaPemakaian) {
        this.lamaPemakaian = lamaPemakaian;
    }

    public int getJangkaWaktuPenyusutan() {
        return jangkaWaktuPenyusutan;
    }

    public void setJangkaWaktuPenyusutan(int jangkaWaktuPenyusutan) {
        this.jangkaWaktuPenyusutan = jangkaWaktuPenyusutan;
    }

    public int getPersenPenyusutan() {
        return persenPenyusutan;
    }

    public void setPersenPenyusutan(int persenPenyusutan) {
        this.persenPenyusutan = persenPenyusutan;
    }

    public double getNilaiPenyusutan() {
        return nilaiPenyusutan;
    }

    public void setNilaiPenyusutan(double nilaiPenyusutan) {
        this.nilaiPenyusutan = nilaiPenyusutan;
    }

    public String getNamaActivaTetapNew() {
        return namaActivaTetapNew;
    }

    public void setNamaActivaTetapNew(String namaActivaTetapNew) {
        this.namaActivaTetapNew = namaActivaTetapNew;
    }

    public void setHargaActivaTetap(double hargaActivaTetap) {
        this.hargaActivaTetap = hargaActivaTetap;
    }

    public double getHargaActivaTetapNew() {
        return hargaActivaTetapNew;
    }

    public void setHargaActivaTetapNew(double hargaActivaTetapNew) {
        this.hargaActivaTetapNew = hargaActivaTetapNew;
    }

    public int getLamaPemakaianNew() {
        return lamaPemakaianNew;
    }

    public void setLamaPemakaianNew(int lamaPemakaianNew) {
        this.lamaPemakaianNew = lamaPemakaianNew;
    }

    public int getJangkaWaktuPenyusutanNew() {
        return jangkaWaktuPenyusutanNew;
    }

    public void setJangkaWaktuPenyusutanNew(int jangkaWaktuPenyusutanNew) {
        this.jangkaWaktuPenyusutanNew = jangkaWaktuPenyusutanNew;
    }

    public int getPersenPenyusutanNew() {
        return persenPenyusutanNew;
    }

    public void setPersenPenyusutanNew(int persenPenyusutanNew) {
        this.persenPenyusutanNew = persenPenyusutanNew;
    }

    public double getNilaiPenyusutanNew() {
        return nilaiPenyusutanNew;
    }

    public void setNilaiPenyusutanNew(double nilaiPenyusutanNew) {
        this.nilaiPenyusutanNew = nilaiPenyusutanNew;
    }

    public boolean isIsPenyusutan() {
        return isPenyusutan;
    }

    public void setIsPenyusutan(boolean isPenyusutan) {
        this.isPenyusutan = isPenyusutan;
    }

    public boolean isIsPenyusutanNew() {
        return isPenyusutanNew;
    }

    public void setIsPenyusutanNew(boolean isPenyusutanNew) {
        this.isPenyusutanNew = isPenyusutanNew;
    }

    public double getTotalKasBank() {
        return totalKasBank;
    }

    public void setTotalKasBank(double totalKasBank) {
        this.totalKasBank = totalKasBank;
    }

    public double getTotalPiutang() {
        return totalPiutang;
    }

    public void setTotalPiutang(double totalPiutang) {
        this.totalPiutang = totalPiutang;
    }

    public double getTotalPersediaan() {
        return totalPersediaan;
    }

    public void setTotalPersediaan(double totalPersediaan) {
        this.totalPersediaan = totalPersediaan;
    }

    public double getNilaiActivaTetap() {
        return nilaiActivaTetap;
    }

    public void setNilaiActivaTetap(double nilaiActivaTetap) {
        this.nilaiActivaTetap = nilaiActivaTetap;
    }

    public double getNilaiTotalPenyusutan() {
        return nilaiTotalPenyusutan;
    }

    public void setNilaiTotalPenyusutan(double nilaiTotalPenyusutan) {
        this.nilaiTotalPenyusutan = nilaiTotalPenyusutan;
    }

    public double getNilaiBukuAssetTetap() {
        return nilaiBukuAssetTetap;
    }

    public void setNilaiBukuAssetTetap(double nilaiBukuAssetTetap) {
        this.nilaiBukuAssetTetap = nilaiBukuAssetTetap;
    }

    public double getTotalAsset() {
        return totalAsset;
    }

    public void setTotalAsset(double totalAsset) {
        this.totalAsset = totalAsset;
    }

    public double getHargaActivaTetap() {
        return hargaActivaTetap;
    }

}
