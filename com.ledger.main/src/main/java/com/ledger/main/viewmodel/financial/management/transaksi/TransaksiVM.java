/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.main.viewmodel.financial.management.transaksi;

import com.ledger.common.application.finance.management.TransaksiService;
import com.ledger.common.dto.finance.management.TransaksiDTO;
import com.ledger.common.dto.finance.management.TransaksiDTOBuilder;
import com.ledger.common.dto.usermanagement.UserDTO;
import com.ledger.common.security.SecurityUtil;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.JenisPembayaran;
import com.ledger.shared.type.Kategori;
import com.ledger.shared.zul.CommonViewModel;
import static com.ledger.shared.zul.CommonViewModel.showInformationMessagebox;
import com.ledger.shared.zul.PageNavigation;
import com.ledger.user.management.application.UserService;
import com.ledger.util.CommonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author BayuHS
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TransaksiVM {

    @WireVariable
    TransaksiService transaksiService;

    @WireVariable
    UserService userService;

    private TransaksiDTO transaksiDTO = new TransaksiDTO();
    private List<TransaksiDTO> transaksiDTOs = new ArrayList<>();

    private UserDTO user;
    private UserDTO userDTO = new UserDTO();

    private ListModelList<Kategori> kategoris = new ListModelList<>();
    private ListModelList<JenisBarang> jenises = new ListModelList<>();
    private ListModelList<StatusTransaksi> statusTransaksis = new ListModelList<>();
    private ListModelList<JenisPembayaran> jenisPembayarans = new ListModelList<>();

    /* search option*/
    private Kategori kategori;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 9;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    private String transaksiID;
    private String namaProduk;

    @Init
    public void init(
            @ExecutionArgParam("transaksiDTO") TransaksiDTO transaksi,
            @ExecutionArgParam("userDTO") UserDTO user,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(transaksi, user, previous);

    }

    private void initData() {
        userDTO = userService.findByID(SecurityUtil.getUserName());
        Map<String, Object> map1 = new HashMap();
        map1.put("userIDTransaksi", userDTO.getUserID());
        transaksiDTOs = transaksiService.findByParams(map1);
        if (transaksiDTOs.isEmpty()) {
            transaksiDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(TransaksiDTO transaksi, UserDTO user, PageNavigation previous) {
        if (transaksi == null) {
            ListModelList<TransaksiDTO> parameterList = new ListModelList<>(transaksiService.findAll());
            String transaksiID = "";
            if (parameterList.isEmpty()) {
                transaksiID = "TRANSAKSI001";
            } else {
                transaksiID = getLatestObjectID(parameterList, "transaksiID");
            }
            transaksiDTO = new TransaksiDTOBuilder()
                    .setTransaksiID(transaksiID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setTanggalTransaksi(new Date())
                    .setCreatedDate(new Date())
                    .setStatusTransaksi(StatusTransaksi.IN_PROGRESS)
                    .createTransaksiDTO();
        } else {
            this.transaksiDTO = transaksi;
            transaksiID = transaksiDTO.getTransaksiID();
            kategori = transaksiDTO.getKategoriTransaksi();
            this.previous = previous;
        }
    }

    protected String getLatestObjectID(ListModelList list, String attribute) {
        int count = 0;
        int pointer = 0;
        int max = 0;
        String s = "";
        for (Object obj : list) {
            Map<String, Object> map = CommonUtil.convertObject2Map(obj);
            String att = attribute;
            String[] arr = new String[attribute.length()];
            String key = "";

            if (att.contains(".")) {
                arr = att.split("\\.");
                int f = 1;
                for (Object x : arr) {
                    if (f != arr.length) {
                        map = CommonUtil.convertObject2Map(map.get(x.toString()));
                    } else {
                        key = x.toString();
                    }
                    f += 1;
                }
            } else {
                key = att;
            }

            att = map.get(key).toString();

            String temp = "";
            int countTemp = 0;
            for (int i = att.length(); i > 0; i--) {
                if (Character.isLetter(att.charAt(i - 1))) {
                    pointer = i;
                    s = att.substring(0, pointer);
                    break;
                }
                countTemp += 1;
                temp = att.charAt(i - 1) + temp;
            }
            if (Integer.parseInt(temp) > max) {
                max = Integer.parseInt(temp);
            }
            count = countTemp;
        }

        return s + String.format("%0" + count + "d", max + 1);
    }

    @Command("buttonCreateTransaksi")
    @NotifyChange("transaksi")
    public void detailPembelian(@BindingParam("object") TransaksiDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("transaksiDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/add.transaksi.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"transaksiDTO", "transaksiDTOs"})
    public void buttonKembaliCivitas(@BindingParam("object") TransaksiDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSimpanTransaksi")
    @NotifyChange("transaksiDTO")
    public void buttonSimpanTransaksi(@BindingParam("object") TransaksiDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        transaksiDTO.setUserIDTransaksi(userDTO.getUserID());
        transaksiDTO.setKategoriTransaksi(kategori);
        transaksiDTO.setTanggalTransaksi(new Date());
        transaksiService.SaveOrUpdate(transaksiDTO);
        showInformationMessagebox("Data Transaksi Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataSubmitTransaksi", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("transaksiDTOs")
    public void refreshData() {
        transaksiDTOs = transaksiService.findAll();
    }

    @GlobalCommand
    @NotifyChange("transaksiDTOs")
    public void refreshDataSubmitTransaksi() {
        Map<String, Object> map1 = new HashMap();
        map1.put("userIDTransaksi", userDTO.getUserID());
        transaksiDTOs = transaksiService.findByParams(map1);
    }

    @Command("detailTransaksi")
    @NotifyChange("transaksi")
    public void detailTransaksi(@BindingParam("object") TransaksiDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("transaksiDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/transaksi/add.transaksi.zul", window, params);
    }

    @Command("deleteTransaksi")
    @NotifyChange("transaksiDTOs")
    public void deleteTransaksi(@BindingParam("object") TransaksiDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        transaksiDTO = (TransaksiDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Transaksi?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    transaksiService.deleteData(transaksiDTO);
                    showInformationMessagebox("Transaksi Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshData", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    public TransaksiService getTransaksiService() {
        return transaksiService;
    }

    public void setTransaksiService(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
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

    public ListModelList<Kategori> getKategoris() {
        return new ListModelList<>(Kategori.values());
    }

    public void setKategoris(ListModelList<Kategori> kategoris) {
        this.kategoris = kategoris;
    }

    public ListModelList<JenisBarang> getJenises() {
        return new ListModelList<>(JenisBarang.values());
    }

    public void setJenises(ListModelList<JenisBarang> jenises) {
        this.jenises = jenises;
    }

    public ListModelList<StatusTransaksi> getStatusTransaksis() {
        return new ListModelList<>(StatusTransaksi.values());
    }

    public void setStatusTransaksis(ListModelList<StatusTransaksi> statusTransaksis) {
        this.statusTransaksis = statusTransaksis;
    }

    public ListModelList<JenisPembayaran> getJenisPembayarans() {
        return new ListModelList<>(JenisPembayaran.values());
    }

    public void setJenisPembayarans(ListModelList<JenisPembayaran> jenisPembayarans) {
        this.jenisPembayarans = jenisPembayarans;
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

    public String getTransaksiID() {
        return transaksiID;
    }

    public void setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
