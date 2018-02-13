/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.main.viewmodel.financial.management.pembelian;

import com.ledger.common.application.finance.management.PembelianService;
import com.ledger.common.dto.finance.management.PembelianDTO;
import com.ledger.common.dto.finance.management.PembelianDTOBuilder;
import com.ledger.common.security.SecurityUtil;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.Kategori;
import com.ledger.shared.zul.CommonViewModel;
import com.ledger.shared.zul.PageNavigation;
import com.ledger.util.CommonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author BayuHS
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PembelianVM {

    @WireVariable
    PembelianService pembelianService;

    private PembelianDTO pembelianDTO = new PembelianDTO();
    private List<PembelianDTO> pembelianDTOs = new ArrayList<>();

    private ListModelList<Kategori> kategoris = new ListModelList<>();
    private ListModelList<JenisBarang> jenises = new ListModelList<>();
    private ListModelList<StatusTransaksi> statusTransaksis = new ListModelList<>();

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 9;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    private String pembelianID;
    private String namaBarang;

    @Init
    public void init(
            @ExecutionArgParam("pembelianDTO") PembelianDTO pembelian,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();
        checkValidity(pembelian, previous);

    }

    private void initData() {
        pembelianDTOs = pembelianService.findAll();
        if (pembelianDTOs.isEmpty()) {
            pembelianDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(PembelianDTO pembelian, PageNavigation previous) {
        if (pembelian == null) {
            ListModelList<PembelianDTO> parameterList = new ListModelList<>(pembelianService.findAll());
            String pembelianID = "";
            if (parameterList.isEmpty()) {
                pembelianID = "001";
            } else {
                pembelianID = getLatestObjectID(parameterList, "pembelianID");
            }
            pembelianDTO = new PembelianDTOBuilder()
                    .setPembelianID(pembelianID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPembelianDTO();
        } else {
            this.pembelianDTO = pembelian;
            pembelianID = pembelianDTO.getPembelianID();
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

    @Command("detailPembelian")
    @NotifyChange("pembelian")
    public void detailPembelian(@BindingParam("object") PembelianDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("pembelianDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/pembelian/add.pembelian.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"pembelianDTO", "pembelianDTOs"})
    public void buttonKembaliCivitas(@BindingParam("object") PembelianDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    public PembelianService getPembelianService() {
        return pembelianService;
    }

    public void setPembelianService(PembelianService pembelianService) {
        this.pembelianService = pembelianService;
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

    public String getPembelianID() {
        return pembelianID;
    }

    public void setPembelianID(String pembelianID) {
        this.pembelianID = pembelianID;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
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

}
