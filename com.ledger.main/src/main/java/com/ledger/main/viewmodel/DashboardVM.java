package com.ledger.main.viewmodel;

import com.ledger.common.application.finance.management.ActivaTetapService;
import com.ledger.common.application.finance.management.HutangService;
import com.ledger.common.application.finance.management.OpeningBalanceFlagService;
import com.ledger.common.application.finance.management.PembelianService;
import com.ledger.common.application.finance.management.PenjualanService;
import com.ledger.common.application.finance.management.PersediaanService;
import com.ledger.common.application.finance.management.PiutangService;
import com.ledger.common.application.finance.management.SaldoKasService;
import com.ledger.common.application.finance.management.TransaksiService;
import com.ledger.common.dto.finance.management.ActivaTetapDTO;
import com.ledger.common.dto.finance.management.ActivaTetapDTOBuilder;
import com.ledger.common.dto.finance.management.HutangDTO;
import com.ledger.common.dto.finance.management.HutangDTOBuilder;
import com.ledger.common.dto.finance.management.OpeningBalanceFlagDTO;
import com.ledger.common.dto.finance.management.OpeningBalanceFlagDTOBuilder;
import com.ledger.common.dto.finance.management.PembelianDTO;
import com.ledger.common.dto.finance.management.PembelianDTOBuilder;
import com.ledger.common.dto.finance.management.PenjualanDTO;
import com.ledger.common.dto.finance.management.PenjualanDTOBuilder;
import com.ledger.common.dto.finance.management.PersediaanDTO;
import com.ledger.common.dto.finance.management.PersediaanDTOBuilder;
import com.ledger.common.dto.finance.management.PiutangDTO;
import com.ledger.common.dto.finance.management.PiutangDTOBuilder;
import com.ledger.common.dto.finance.management.SaldoKasDTO;
import com.ledger.common.dto.finance.management.SaldoKasDTOBuilder;
import com.ledger.common.dto.finance.management.TransaksiDTO;
import com.ledger.common.dto.finance.management.TransaksiDTOBuilder;
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
    @WireVariable
    OpeningBalanceFlagService openingBalanceFlagService;
    @WireVariable
    PembelianService pembelianService;
    @WireVariable
    PenjualanService penjualanService;
    @WireVariable
    TransaksiService transaksiService;

    /* data user */
    private UserDTO user;
    private String userNPWP;
    private String role;
    private String uriPhoto;

    /* data saldo kas */
    private SaldoKasDTO saldoKasDTO = new SaldoKasDTO();
    private double saldoKasBank;
    private double saldoKas;
    private double saldoBank;
    private double saldoLabaRugi;
    private double modalDisetor;

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
    private String satuan;
    private int jumlahPersediaan;
    private double hargaPersediaan;
    private double totalHargaPersediaan;
    private String namaPersediaanNew;
    private String jenisPersediaanNew;
    private String satuanNew;
    private int jumlahPersediaanNew;
    private double hargaPersediaanNew;
    private double totalHargaPersediaanNew;
    private ListModelList<String> listJenisPersediaan = new ListModelList<>();
    private ListModelList<String> listSatuan = new ListModelList<>();
    private ListModelList<String> listNamaPersediaan = new ListModelList<>();

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

    /* data persediaan */
    private OpeningBalanceFlagDTO openingBalanceFlagDTO = new OpeningBalanceFlagDTO();

    /* data transaksi */
    private TransaksiDTO transaksiDTO = new TransaksiDTO();
    private List<TransaksiDTO> transaksiDTOs = new ArrayList<>();
    private Date tanggalTransaksi;
    private String jenisTransaksi;
    private String tipePembayaran;
    private ListModelList<String> listJenisTransaksi = new ListModelList<>();
    private ListModelList<String> listTipePembayaran = new ListModelList<>();

    /* data pembelian */
    private PembelianDTO pembelianDTO = new PembelianDTO();
    private List<PembelianDTO> pembelianDTOs = new ArrayList<>();

    /* data penjualan */
    private PenjualanDTO penjualanDTO = new PenjualanDTO();
    private List<PenjualanDTO> penjualanDTOs = new ArrayList<>();

    /* data page */
    private String src = "/financial-management/ledger/neraca.zul";
    private String transaksiTab1 = "/financial-management/transaksi/transaksi.tab1.zul";

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
    private double totalHutang;
    private double totalPiutang;
    private double totalPersediaan;
    private double nilaiActivaTetap;
    private double nilaiTotalPenyusutan;
    private double nilaiBukuAssetTetap;
    private double totalAsset;

    /* form opening balance exception */
    private boolean isNoSaldo;
    private boolean isNoHutang;
    private boolean isNoPiutang;
    private boolean isNoPersediaan;
    private boolean isNoActiva;

    private int year = 2018;

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
            saldoKas = saldoKasDTO.getSaldoKas();
            saldoBank = saldoKasDTO.getSaldoBank();
            saldoLabaRugi = saldoKasDTO.getSaldoLabaRugi();
            modalDisetor = saldoKasDTO.getModalDisetor();
            totalKasBank = saldoKas + saldoBank + saldoLabaRugi + modalDisetor;

        } else {
            saldoKasDTO = new SaldoKasDTOBuilder()
                    .setSaldoKasID(UUID.randomUUID().toString())
                    .setUserID(SecurityUtil.getUserName())
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createSaldoKasDTO();
        }

        transaksiDTOs = transaksiService.findByUserID(SecurityUtil.getUserName());

        hutangDTOs = hutangService.findByUserID(SecurityUtil.getUserName());
        for (HutangDTO h : hutangDTOs) {
            hutangDTO = hutangService.findByID(h.getHutangID());
            namaHutang = h.getNamaHutang();
            jumlahHutang = h.getJumlahHutang();
            statusHutang = h.getStatus();
            totalHutang += jumlahHutang;
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
            satuan = ps.getSatuan();
            totalHargaPersediaan = ps.getTotalHargaPersediaan();
            totalPersediaan += totalHargaPersediaan;
            listNamaPersediaan.add(ps.getNamaPersediaan());
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
        listJenisPersediaan.add("BAHAN BAKU");
        listJenisPersediaan.add("BARANG JADI");
        listJenisPersediaan.add("BARANG SETENGAH JADI");

        listJenisTransaksi.add("PEMBELIAN");
        listJenisTransaksi.add("PENJUALAN");
        listJenisTransaksi.add("RETUR");

        listTipePembayaran.add("CASH");
        listTipePembayaran.add("KREDIT");
        listTipePembayaran.add("CACH & KREDIT");

        listSatuan.add("Kg");
        listSatuan.add("Sak");
        listSatuan.add("Pcs");

        openingBalanceFlagDTO = openingBalanceFlagService.findByUserID(SecurityUtil.getUserName());
        if (openingBalanceFlagDTO != null) {
            if (openingBalanceFlagDTO.isIsFormSaldo() == true && openingBalanceFlagDTO.isIsFormHutang() == true
                    && openingBalanceFlagDTO.isIsFormPiutang() == true && openingBalanceFlagDTO.isIsFormPersediaan() == true
                    && openingBalanceFlagDTO.isIsFormActiva() == true) {
                panelAfter = true;
                panelBefore = false;
                introForm = true;
                step1Form = false;
                step2Form = false;
                step3Form = false;
                step4Form = false;
                step5Form = false;
            } else {
                panelAfter = false;
                panelBefore = true;
                introForm = true;
                step1Form = false;
                step2Form = false;
                step3Form = false;
                step4Form = false;
                step5Form = false;
            }
        } else {
            panelAfter = false;
            panelBefore = true;
            introForm = true;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = false;

            openingBalanceFlagDTO = new OpeningBalanceFlagDTOBuilder()
                    .setOpeningBalanceFlagID(UUID.randomUUID().toString())
                    .setUserID(SecurityUtil.getUserName())
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createOpeningBalanceFlagDTO();
        }

    }

    @NotifyChange("totalHargaPersediaanNew")
    public double totalPersediaanNew() {
        totalHargaPersediaanNew = jumlahPersediaanNew * hargaPersediaanNew;
        return totalHargaPersediaanNew;
    }

    @NotifyChange("totalHargaPersediaan")
    public double totalPersediaan() {
        totalHargaPersediaan = jumlahPersediaan * hargaPersediaan;
        return totalHargaPersediaan;
    }

    /* for botton add transaction */
    @Command("buttonKlikTransaksi")
    @NotifyChange("src")
    public void buttonKlikTransaksi(@ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/neraca.zul";
    }

    /* for home tab */
    @Command("buttonKlikNeraca")
    @NotifyChange("src")
    public void buttonKlikNeraca(@ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/neraca.zul";
    }

    @Command("buttonKlikLabaRugi")
    @NotifyChange("src")
    public void buttonKlikLabaRugi(@ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/laba.rugi.zul";
    }

    @Command("buttonKlikPersediaan")
    @NotifyChange("src")
    public void buttonKlikPersediaan(@ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/dashboard.persediaan.zul";
    }

    @Command("buttonKlikHistoryTransaksi")
    @NotifyChange("src")
    public void buttonKlikHistoryTransaksi(@ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/dashboard.transaksi.zul";
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
    @NotifyChange({"isNoSaldo", "introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form", "saldoKasDTO"})
    public void buttonKlikNextForm1(@ContextParam(ContextType.VIEW) Window window) {
        if (isNoSaldo == true) {
            introForm = false;
            step1Form = false;
            step2Form = true;
            step3Form = false;
            step4Form = false;
            step5Form = false;
            openingBalanceFlagDTO.setIsFormSaldo(true);
            openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
        } else {
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
                    saldoKasDTO.setSaldoKas(saldoKas);
                    saldoKasDTO.setSaldoBank(saldoBank);
                    saldoKasDTO.setSaldoLabaRugi(saldoLabaRugi);
                    saldoKasDTO.setModalDisetor(modalDisetor);
                    saldoKasDTO.setSaldoKasBank(saldoKas + saldoBank + saldoLabaRugi + modalDisetor);
                    saldoKasService.SaveOrUpdate(saldoKasDTO);
                } else {
                    saldoKasDTO.setModifiedBy(SecurityUtil.getUserName());
                    saldoKasDTO.setModifiedDate(new Date());
                    saldoKasDTO.setSaldoKas(saldoKas);
                    saldoKasDTO.setSaldoBank(saldoBank);
                    saldoKasDTO.setSaldoLabaRugi(saldoLabaRugi);
                    saldoKasDTO.setModalDisetor(modalDisetor);
                    saldoKasDTO.setSaldoKasBank(saldoKas + saldoBank + saldoLabaRugi + modalDisetor);
                    saldoKasService.SaveOrUpdate(saldoKasDTO);
                }

                openingBalanceFlagDTO.setIsFormSaldo(true);
                openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
            }
        }
    }

    @Command("buttonKlikNextForm2")
    @NotifyChange({"isNoHutang", "introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikNextForm2(@ContextParam(ContextType.VIEW) Window window) {
        if (isNoHutang == true) {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = true;
            step4Form = false;
            step5Form = false;
            openingBalanceFlagDTO.setIsFormHutang(true);
            openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
        } else {
            if (hutangDTOs.isEmpty()) {
                Messagebox.show("Anda belum mengisi data hutang!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            } else {
                introForm = false;
                step1Form = false;
                step2Form = false;
                step3Form = true;
                step4Form = false;
                step5Form = false;

                openingBalanceFlagDTO.setIsFormHutang(true);
                openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
            }
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
    @NotifyChange({"isNoPiutang", "introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikNextForm3(@ContextParam(ContextType.VIEW) Window window) {
        if (isNoPiutang == true) {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = true;
            step5Form = false;

            openingBalanceFlagDTO.setIsFormPiutang(true);
            openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
        } else {
            if (piutangDTOs.isEmpty()) {
                Messagebox.show("Anda belum mengisi data piutang!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            } else {
                introForm = false;
                step1Form = false;
                step2Form = false;
                step3Form = false;
                step4Form = true;
                step5Form = false;
                openingBalanceFlagDTO.setIsFormPiutang(true);
                openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
            }

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
    @NotifyChange({"isNoPersediaan", "introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikNextForm4(@ContextParam(ContextType.VIEW) Window window) {
        if (isNoPersediaan == true) {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = true;

            openingBalanceFlagDTO.setIsFormPersediaan(true);
            openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
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

                openingBalanceFlagDTO.setIsFormPersediaan(true);
                openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
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
        persediaanDTO.setSatuan(satuan);
        persediaanDTO.setTotalHargaPersediaan(jumlahPersediaan * hargaPersediaan);
        persediaanDTO.setHargaRataRata(persediaanDTO.getTotalHargaPersediaan() / jumlahPersediaan);
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
        persediaanDTO = persediaanService.findByName(namaPersediaanNew);
        if (persediaanDTO == null) {
            persediaanDTO = new PersediaanDTOBuilder()
                    .setPersediaanID(UUID.randomUUID().toString())
                    .setNamaPersediaan(namaPersediaanNew)
                    .setJumlahPersediaan(jumlahPersediaanNew)
                    .setJenisPersediaan(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setHargaPersediaan(hargaPersediaanNew)
                    .setTotalHargaPersediaan(jumlahPersediaanNew * hargaPersediaanNew)
                    .setHargaRataRata((jumlahPersediaanNew * hargaPersediaanNew) / jumlahPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPersediaanDTO();
            persediaanService.SaveOrUpdate(persediaanDTO);
            showInformationMessagebox("Data Persediaan Berhasil Ditambahkan");
            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
            window.detach();
        } else {
            PersediaanDTO lp = persediaanService.findByName(namaPersediaanNew);
            persediaanDTO.setNamaPersediaan(namaPersediaanNew);
            persediaanDTO.setJumlahPersediaan(lp.getJumlahPersediaan() + jumlahPersediaanNew);
            persediaanDTO.setJenisPersediaan(jenisPersediaanNew);
            persediaanDTO.setSatuan(satuanNew);
            persediaanDTO.setHargaPersediaan(hargaPersediaanNew);
            persediaanDTO.setTotalHargaPersediaan(lp.getTotalHargaPersediaan() + (jumlahPersediaanNew * hargaPersediaanNew));
//            persediaanDTO.setHargaRataRata(persediaanDTO.getTotalHargaPersediaan() / jumlahPersediaanNew);
            persediaanDTO.setModifiedBy(SecurityUtil.getUserName());
            persediaanDTO.setModifiedDate(new Date());
            persediaanService.SaveOrUpdate(persediaanDTO);
            showInformationMessagebox("Data Persediaan Berhasil Ditambahkan");
            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
            window.detach();
        }
    }

    @Command("buttonSimpanTransaksiPembelian")
    @NotifyChange({"persediaanDTOs", "penjualanDTOs", "pembelianDTOs", "transaksiDTOs"})
    public void buttonSimpanTransaksiPembelian(@ContextParam(ContextType.VIEW) Window window) {
        persediaanDTO = persediaanService.findByName(namaPersediaanNew);
        if (persediaanDTO == null) {
            persediaanDTO = new PersediaanDTOBuilder()
                    .setPersediaanID(UUID.randomUUID().toString())
                    .setNamaPersediaan(namaPersediaanNew)
                    .setJumlahPersediaan(jumlahPersediaanNew)
                    .setJenisPersediaan(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setHargaPersediaan(hargaPersediaanNew)
                    .setTotalHargaPersediaan(jumlahPersediaanNew * hargaPersediaanNew)
                    .setHargaRataRata(persediaanDTO.getTotalHargaPersediaan() / jumlahPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPersediaanDTO();
            persediaanService.SaveOrUpdate(persediaanDTO);

            pembelianDTO = new PembelianDTOBuilder()
                    .setPembelianID(UUID.randomUUID().toString())
                    .setNamaBarang(namaPersediaanNew)
                    .setJenisBarang(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setJumlah(jumlahPersediaanNew)
                    .setHargaBarang(hargaPersediaanNew)
                    .setTotalHarga(jumlahPersediaanNew * hargaPersediaanNew)
                    .setTanggalPembelian(tanggalTransaksi)
                    .setTipePembayaran(tipePembayaran)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPembelianDTO();

            pembelianService.SaveOrUpdate(pembelianDTO);

            double cash;
            double kredit;
            if (tipePembayaran == "CASH") {
                cash = jumlahPersediaanNew * hargaPersediaanNew;
                kredit = 0.0;
            } else {
                cash = 0.0;
                kredit = jumlahPersediaanNew * hargaPersediaanNew;;
            }

            transaksiDTO = new TransaksiDTOBuilder()
                    .setTransaksiID(UUID.randomUUID().toString())
                    .setJenisTransaksi(jenisTransaksi)
                    .setNamaTransaksi(namaPersediaanNew)
                    .setNilaiTransaksi(jumlahPersediaanNew * hargaPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setTanggalTransaksi(tanggalTransaksi)
                    .setJenisPembayaran(tipePembayaran)
                    .setCash(cash)
                    .setKredit(kredit)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createTransaksiDTO();
            transaksiService.SaveOrUpdate(transaksiDTO);
            showInformationMessagebox("Data Transaksi Berhasil Ditambahkan");
            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
            window.detach();
        } else {
            PersediaanDTO lp = persediaanService.findByName(namaPersediaanNew);
            persediaanDTO.setNamaPersediaan(namaPersediaanNew);
            persediaanDTO.setJumlahPersediaan(lp.getJumlahPersediaan() + jumlahPersediaanNew);
            persediaanDTO.setJenisPersediaan(jenisPersediaanNew);
            persediaanDTO.setSatuan(satuanNew);
            persediaanDTO.setHargaPersediaan(hargaPersediaanNew);
            persediaanDTO.setTotalHargaPersediaan(lp.getTotalHargaPersediaan() + (jumlahPersediaanNew * hargaPersediaanNew));
            persediaanDTO.setModifiedBy(SecurityUtil.getUserName());
            persediaanDTO.setModifiedDate(new Date());
            persediaanService.SaveOrUpdate(persediaanDTO);

            pembelianDTO = new PembelianDTOBuilder()
                    .setPembelianID(UUID.randomUUID().toString())
                    .setNamaBarang(namaPersediaanNew)
                    .setJenisBarang(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setJumlah(jumlahPersediaanNew)
                    .setHargaBarang(hargaPersediaanNew)
                    .setTotalHarga(jumlahPersediaanNew * hargaPersediaanNew)
                    .setTanggalPembelian(tanggalTransaksi)
                    .setTipePembayaran(tipePembayaran)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPembelianDTO();
            pembelianService.SaveOrUpdate(pembelianDTO);

            double cash;
            double kredit;
            if (tipePembayaran == "CASH") {
                cash = jumlahPersediaanNew * hargaPersediaanNew;
                kredit = 0.0;
            } else {
                cash = 0.0;
                kredit = jumlahPersediaanNew * hargaPersediaanNew;;
            }

            transaksiDTO = new TransaksiDTOBuilder()
                    .setTransaksiID(UUID.randomUUID().toString())
                    .setJenisTransaksi(jenisTransaksi)
                    .setNamaTransaksi(namaPersediaanNew)
                    .setNilaiTransaksi(jumlahPersediaanNew * hargaPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setTanggalTransaksi(tanggalTransaksi)
                    .setJenisPembayaran(tipePembayaran)
                    .setCash(cash)
                    .setKredit(kredit)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createTransaksiDTO();

            transaksiService.SaveOrUpdate(transaksiDTO);

            showInformationMessagebox("Data Transaksi Berhasil Ditambahkan");
            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
            window.detach();
        }
    }

    @Command("buttonSimpanTransaksiPenjualan")
    @NotifyChange({"persediaanDTOs", "penjualanDTOs", "pembelianDTOs", "transaksiDTOs"})
    public void buttonSimpanTransaksiPenjualan(@ContextParam(ContextType.VIEW) Window window) {
        persediaanDTO = persediaanService.findByName(namaPersediaanNew);
        if (persediaanDTO == null) {
            persediaanDTO = new PersediaanDTOBuilder()
                    .setPersediaanID(UUID.randomUUID().toString())
                    .setNamaPersediaan(namaPersediaanNew)
                    .setJumlahPersediaan(jumlahPersediaanNew)
                    .setJenisPersediaan(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setHargaPersediaan(hargaPersediaanNew)
                    .setTotalHargaPersediaan(jumlahPersediaanNew * hargaPersediaanNew)
                    .setHargaRataRata(persediaanDTO.getTotalHargaPersediaan() / jumlahPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPersediaanDTO();
            persediaanService.SaveOrUpdate(persediaanDTO);

            penjualanDTO = new PenjualanDTOBuilder()
                    .setPenjualanID(UUID.randomUUID().toString())
                    .setNamaBarang(namaPersediaanNew)
                    .setJenisBarang(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setJumlah(jumlahPersediaanNew)
                    .setHargaBarang(hargaPersediaanNew)
                    .setTotalHarga(jumlahPersediaanNew * hargaPersediaanNew)
                    .setTanggalPenjualan(tanggalTransaksi)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPenjualanDTO();

            penjualanService.SaveOrUpdate(penjualanDTO);

            double cash;
            double kredit;
            if (tipePembayaran != null) {
                if (tipePembayaran == "CASH") {
                    cash = jumlahPersediaanNew * hargaPersediaanNew;
                    kredit = 0.0;
                } else {
                    cash = 0.0;
                    kredit = jumlahPersediaanNew * hargaPersediaanNew;;
                }
            }

            transaksiDTO = new TransaksiDTOBuilder()
                    .setTransaksiID(UUID.randomUUID().toString())
                    .setJenisTransaksi(jenisTransaksi)
                    .setNamaTransaksi(namaPersediaanNew)
                    .setNilaiTransaksi(jumlahPersediaanNew * hargaPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setTanggalTransaksi(tanggalTransaksi)
                    .setJenisPembayaran(tipePembayaran)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createTransaksiDTO();
            transaksiService.SaveOrUpdate(transaksiDTO);
            showInformationMessagebox("Data Transaksi Berhasil Ditambahkan");
            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
            window.detach();
        } else {
            PersediaanDTO lp = persediaanService.findByName(namaPersediaanNew);
            persediaanDTO.setNamaPersediaan(namaPersediaanNew);
            persediaanDTO.setJumlahPersediaan(lp.getJumlahPersediaan() - jumlahPersediaanNew);
            persediaanDTO.setJenisPersediaan(jenisPersediaanNew);
            persediaanDTO.setSatuan(satuanNew);
            persediaanDTO.setHargaPersediaan(hargaPersediaanNew);
            persediaanDTO.setTotalHargaPersediaan(lp.getTotalHargaPersediaan() - (jumlahPersediaanNew * hargaPersediaanNew));
            persediaanDTO.setModifiedBy(SecurityUtil.getUserName());
            persediaanDTO.setModifiedDate(new Date());
            persediaanService.SaveOrUpdate(persediaanDTO);

            penjualanDTO = new PenjualanDTOBuilder()
                    .setPenjualanID(UUID.randomUUID().toString())
                    .setNamaBarang(namaPersediaanNew)
                    .setJenisBarang(jenisPersediaanNew)
                    .setSatuan(satuanNew)
                    .setJumlah(jumlahPersediaanNew)
                    .setHargaBarang(hargaPersediaanNew)
                    .setTotalHarga(jumlahPersediaanNew * hargaPersediaanNew)
                    .setTanggalPenjualan(tanggalTransaksi)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPenjualanDTO();
            penjualanService.SaveOrUpdate(penjualanDTO);

            double cash;
            double kredit;
            if (tipePembayaran == "CASH") {
                cash = jumlahPersediaanNew * hargaPersediaanNew;
                kredit = 0.0;
            } else {
                cash = 0.0;
                kredit = jumlahPersediaanNew * hargaPersediaanNew;;
            }

            transaksiDTO = new TransaksiDTOBuilder()
                    .setTransaksiID(UUID.randomUUID().toString())
                    .setJenisTransaksi(jenisTransaksi)
                    .setNamaTransaksi(namaPersediaanNew)
                    .setNilaiTransaksi(jumlahPersediaanNew * hargaPersediaanNew)
                    .setUserID(SecurityUtil.getUserName())
                    .setTanggalTransaksi(tanggalTransaksi)
                    .setJenisPembayaran(tipePembayaran)
                    .setCash(cash)
                    .setKredit(kredit)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createTransaksiDTO();
            transaksiService.SaveOrUpdate(transaksiDTO);

            showInformationMessagebox("Data Transaksi Berhasil Ditambahkan");
            BindUtils.postGlobalCommand(null, null, "refreshDataPersediaan", null);
            window.detach();
        }
    }

    @GlobalCommand
    @NotifyChange({"persediaanDTOs", "transaksiDTOs"})
    public void refreshDataPersediaan() {
        persediaanDTOs = persediaanService.findByUserID(SecurityUtil.getUserName());
        transaksiDTOs = transaksiService.findByUserID(SecurityUtil.getUserName());
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
    @NotifyChange({"isNoActiva", "panelAfter", "panelBefore", "introForm", "step1Form", "step2Form", "step3Form", "step4Form", "step5Form"})
    public void buttonKlikFinishForm5(@ContextParam(ContextType.VIEW) Window window) {
        if (isNoActiva == true) {
            introForm = false;
            step1Form = false;
            step2Form = false;
            step3Form = false;
            step4Form = false;
            step5Form = false;
            panelBefore = false;
            panelAfter = true;

            openingBalanceFlagDTO.setIsFormActiva(true);
            openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
        } else {
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

                openingBalanceFlagDTO.setIsFormActiva(true);
                openingBalanceFlagService.SaveOrUpdate(openingBalanceFlagDTO);
            }
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
        activaTetapDTO.setPersenPenyusutan(0);
        activaTetapDTO.setTotalPenyusutan((hargaActivaTetap / lamaPemakaian) * ((lamaPemakaian) - (year - jangkaWaktuPenyusutan)));
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
        activaTetapDTO = new ActivaTetapDTOBuilder()
                .setActivaTetapID(UUID.randomUUID().toString())
                .setNamaActivaTetap(namaActivaTetapNew)
                .setHargaActivaTetap(hargaActivaTetapNew)
                .setLamaPemakaian(lamaPemakaianNew)
                .setJangkaWaktuPenyusutan(jangkaWaktuPenyusutanNew)
                .setPersenPenyusutan(0)
                .setTotalPenyusutan((hargaActivaTetapNew / lamaPemakaianNew) * ((lamaPemakaianNew) - (year - jangkaWaktuPenyusutanNew)))
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

    @Command("buttonTambahTransaksiPokok")
    @NotifyChange("persediaanDTO")
    public void buttonTambahTransaksiPokok(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/add.transaksi.zul", window, null);
    }

    /* for tab transaksi pokok */
    @Command("buttonKlikTransaksiPokok")
    @NotifyChange("transaksiTab1")
    public void buttonKlikTransaksiPokok(@ContextParam(ContextType.VIEW) Window window) {
        transaksiTab1 = "/financial-management/transaksi/transaksi.tab1.zul";
    }

    /* for tab transaksi pokok */
    @Command("buttonKlikTransaksiLainnya")
    @NotifyChange("transaksiTab1")
    public void buttonKlikTransaksiLainnya(@ContextParam(ContextType.VIEW) Window window) {
        transaksiTab1 = "/financial-management/transaksi/transaksi.tab2.zul";
    }

    /* for tab transaksi pokok */
    @Command("buttonKlikDataPersediaan")
    @NotifyChange("transaksiTab1")
    public void buttonKlikDataPersediaan(@ContextParam(ContextType.VIEW) Window window) {
//        transaksiTab1 = "/financial-management/transaksi/transaksi.tab3.zul";
        transaksiTab1 = "/financial-management/ledger/dashboard.persediaan.transaksi.zul";
    }

    @Command("buttonCancel")
    public void buttonCancel(@ContextParam(ContextType.VIEW) Window window) {
        window.detach();
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

    public boolean isIsNoSaldo() {
        return isNoSaldo;
    }

    public void setIsNoSaldo(boolean isNoSaldo) {
        this.isNoSaldo = isNoSaldo;
    }

    public boolean isIsNoHutang() {
        return isNoHutang;
    }

    public void setIsNoHutang(boolean isNoHutang) {
        this.isNoHutang = isNoHutang;
    }

    public boolean isIsNoPiutang() {
        return isNoPiutang;
    }

    public void setIsNoPiutang(boolean isNoPiutang) {
        this.isNoPiutang = isNoPiutang;
    }

    public boolean isIsNoPersediaan() {
        return isNoPersediaan;
    }

    public void setIsNoPersediaan(boolean isNoPersediaan) {
        this.isNoPersediaan = isNoPersediaan;
    }

    public boolean isIsNoActiva() {
        return isNoActiva;
    }

    public void setIsNoActiva(boolean isNoActiva) {
        this.isNoActiva = isNoActiva;
    }

    public OpeningBalanceFlagDTO getOpeningBalanceFlagDTO() {
        return openingBalanceFlagDTO;
    }

    public void setOpeningBalanceFlagDTO(OpeningBalanceFlagDTO openingBalanceFlagDTO) {
        this.openingBalanceFlagDTO = openingBalanceFlagDTO;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalHutang() {
        return totalHutang;
    }

    public void setTotalHutang(double totalHutang) {
        this.totalHutang = totalHutang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getSatuanNew() {
        return satuanNew;
    }

    public void setSatuanNew(String satuanNew) {
        this.satuanNew = satuanNew;
    }

    public ListModelList<String> getListSatuan() {
        return listSatuan;
    }

    public void setListSatuan(ListModelList<String> listSatuan) {
        this.listSatuan = listSatuan;
    }

    public ListModelList<String> getListNamaPersediaan() {
        return listNamaPersediaan;
    }

    public void setListNamaPersediaan(ListModelList<String> listNamaPersediaan) {
        this.listNamaPersediaan = listNamaPersediaan;
    }

    public String getTransaksiTab1() {
        return transaksiTab1;
    }

    public void setTransaksiTab1(String transaksiTab1) {
        this.transaksiTab1 = transaksiTab1;
    }

    public TransaksiDTO getTransaksiDTO() {
        return transaksiDTO;
    }

    public void setTransaksiDTO(TransaksiDTO transaksiDTO) {
        this.transaksiDTO = transaksiDTO;
    }

    public List<TransaksiDTO> getTransaksiDTOs() {
        return transaksiDTOs;
    }

    public void setTransaksiDTOs(List<TransaksiDTO> transaksiDTOs) {
        this.transaksiDTOs = transaksiDTOs;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public ListModelList<String> getListJenisTransaksi() {
        return listJenisTransaksi;
    }

    public void setListJenisTransaksi(ListModelList<String> listJenisTransaksi) {
        this.listJenisTransaksi = listJenisTransaksi;
    }

    public PembelianDTO getPembelianDTO() {
        return pembelianDTO;
    }

    public void setPembelianDTO(PembelianDTO pembelianDTO) {
        this.pembelianDTO = pembelianDTO;
    }

    public List<PembelianDTO> getPembelianDTOs() {
        return pembelianDTOs;
    }

    public void setPembelianDTOs(List<PembelianDTO> pembelianDTOs) {
        this.pembelianDTOs = pembelianDTOs;
    }

    public PenjualanDTO getPenjualanDTO() {
        return penjualanDTO;
    }

    public void setPenjualanDTO(PenjualanDTO penjualanDTO) {
        this.penjualanDTO = penjualanDTO;
    }

    public List<PenjualanDTO> getPenjualanDTOs() {
        return penjualanDTOs;
    }

    public void setPenjualanDTOs(List<PenjualanDTO> penjualanDTOs) {
        this.penjualanDTOs = penjualanDTOs;
    }

    public String getTipePembayaran() {
        return tipePembayaran;
    }

    public void setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
    }

    public ListModelList<String> getListTipePembayaran() {
        return listTipePembayaran;
    }

    public void setListTipePembayaran(ListModelList<String> listTipePembayaran) {
        this.listTipePembayaran = listTipePembayaran;
    }

    public double getSaldoKas() {
        return saldoKas;
    }

    public void setSaldoKas(double saldoKas) {
        this.saldoKas = saldoKas;
    }

    public double getSaldoBank() {
        return saldoBank;
    }

    public void setSaldoBank(double saldoBank) {
        this.saldoBank = saldoBank;
    }

    public double getSaldoLabaRugi() {
        return saldoLabaRugi;
    }

    public void setSaldoLabaRugi(double saldoLabaRugi) {
        this.saldoLabaRugi = saldoLabaRugi;
    }

    public double getModalDisetor() {
        return modalDisetor;
    }

    public void setModalDisetor(double modalDisetor) {
        this.modalDisetor = modalDisetor;
    }

}
