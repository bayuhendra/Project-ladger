package com.ledger.main.viewmodel.financial.management.asset;

import com.ledger.common.application.finance.management.AssetService;
import com.ledger.common.dto.finance.management.asset.AssetDTO;
import com.ledger.common.dto.finance.management.asset.AssetDTOBuilder;
import com.ledger.common.security.SecurityUtil;
import com.ledger.shared.zul.CommonViewModel;
import static com.ledger.shared.zul.CommonViewModel.showInformationMessagebox;
import com.ledger.shared.zul.PageNavigation;
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
 * @author lintang
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AssetVM {

    @WireVariable
    AssetService assetService;

    private AssetDTO assetDTO = new AssetDTO();
    private List<AssetDTO> assetDTOs = new ArrayList<>();

    private ListModelList<String> listJenisAsset = new ListModelList<>();

    /* search option*/
    private String searchByNamaAsset;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 10;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    private String assetID;
    private String namaAsset;
    private String jenisAsset;
    private double nilaiAsset;
    private String keterangan;

    @Init
    public void init(
            @ExecutionArgParam("assetDTO") AssetDTO asset,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(asset, previous);

    }

    private void initData() {
        listJenisAsset.add("ELEKTRONIK");
        listJenisAsset.add("NON ELEKTRONIK");
        assetDTOs = assetService.findByUserID(SecurityUtil.getUserName());
        if (assetDTOs.isEmpty()) {
            assetDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(AssetDTO asset, PageNavigation previous) {
        if (asset == null) {
            ListModelList<AssetDTO> parameterList = new ListModelList<>(assetService.findAll());
            String assetdID = "";
            if (parameterList.isEmpty()) {
                assetdID = "ASSET001";
            } else {
                assetdID = getLatestObjectID(parameterList, "assetdID");
            }
            assetDTO = new AssetDTOBuilder()
                    .setAssetdID(assetdID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createAssetDTO();
        } else {
            this.assetDTO = asset;
            searchByNamaAsset = assetDTO.getNamaAsset();
            namaAsset = assetDTO.getNamaAsset();
            jenisAsset = assetDTO.getJenisAsset();
            nilaiAsset = assetDTO.getNilaiAsset();
            keterangan = assetDTO.getKeterangan();
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

    @Command("buttonSearch")
    @NotifyChange("assetDTOs")
    public void buttonSearch(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("userID", SecurityUtil.getUserName());
        params.put("namaAsset", searchByNamaAsset);

        assetDTOs = assetService.findByParams(params);
    }

    @Command("buttonCreateAsset")
    @NotifyChange("asset")
    public void buttonCreateAsset(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("assetDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/asset/add.asset.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"assetDTO", "assetDTOs"})
    public void buttonKembali(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSimpan")
    @NotifyChange("assetDTO")
    public void buttonSimpan(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        assetDTO.setNamaAsset(namaAsset);
        assetDTO.setJenisAsset(jenisAsset);
        assetDTO.setNilaiAsset(nilaiAsset);
        assetDTO.setKeterangan(keterangan);
        assetDTO.setUserID(SecurityUtil.getUserName());
        assetService.SaveOrUpdate(assetDTO);
        showInformationMessagebox("Data Asset Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("assetDTOs")
    public void refreshData() {
        assetDTOs = assetService.findByUserID(SecurityUtil.getUserName());
    }

    @Command("detailAsset")
    @NotifyChange("asset")
    public void detailAsset(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("assetDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/asset/add.asset.zul", window, params);
    }

    @Command("deleteAsset")
    @NotifyChange("assetDTOs")
    public void deleteAsset(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        assetDTO = (AssetDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Asset?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            assetService.deleteData(assetDTO);
                            showInformationMessagebox("Data Asset Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshData", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    public AssetDTO getAssetDTO() {
        return assetDTO;
    }

    public void setAssetDTO(AssetDTO assetDTO) {
        this.assetDTO = assetDTO;
    }

    public List<AssetDTO> getAssetDTOs() {
        return assetDTOs;
    }

    public void setAssetDTOs(List<AssetDTO> assetDTOs) {
        this.assetDTOs = assetDTOs;
    }

    public ListModelList<String> getListJenisAsset() {
        return listJenisAsset;
    }

    public void setListJenisAsset(ListModelList<String> listJenisAsset) {
        this.listJenisAsset = listJenisAsset;
    }

    public String getSearchByNamaAsset() {
        return searchByNamaAsset;
    }

    public void setSearchByNamaAsset(String searchByNamaAsset) {
        this.searchByNamaAsset = searchByNamaAsset;
    }

    public String getNamaAsset() {
        return namaAsset;
    }

    public void setNamaAsset(String namaAsset) {
        this.namaAsset = namaAsset;
    }

    public String getJenisAsset() {
        return jenisAsset;
    }

    public void setJenisAsset(String jenisAsset) {
        this.jenisAsset = jenisAsset;
    }

    public double getNilaiAsset() {
        return nilaiAsset;
    }

    public void setNilaiAsset(double nilaiAsset) {
        this.nilaiAsset = nilaiAsset;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

}
