package com.ledger.main.viewmodel.financial.management.ledger;

import com.ledger.common.application.finance.management.AssetService;
import com.ledger.common.dto.finance.management.asset.AssetDTO;
import com.ledger.shared.zul.CommonViewModel;
import com.ledger.shared.zul.PageNavigation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LaporanVM {

    @WireVariable
    AssetService assetService;

    private AssetDTO assetDTO = new AssetDTO();
    private List<AssetDTO> assetDTOs = new ArrayList<>();

    private String src = "/financial-management/ledger/laba.rugi.zul.zul";

    @Init
    public void init(
            @ExecutionArgParam("assetDTO") AssetDTO asset,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(asset, previous);

    }

    private void initData() {
        assetDTOs = assetService.findAll();
        if (assetDTOs.isEmpty()) {
            assetDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(AssetDTO asset, PageNavigation previous) {
    }

    @Command("buttonLabaRugi")
    @NotifyChange("src")
    public void buttonLabaRugi(@BindingParam("object") AssetDTO obj,
            @ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/laba.rugi.zul.zul";
    }

    @Command("buttonNeraca")
    @NotifyChange("src")
    public void buttonNeraca(@BindingParam("object") AssetDTO obj,
            @ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/neraca.zul";
    }

    @Command("buttonKas")
    @NotifyChange("src")
    public void buttonKas(@BindingParam("object") AssetDTO obj,
            @ContextParam(ContextType.VIEW) Window window) {
        src = "/financial-management/ledger/kas.zul";
    }

    @Command("buttonKembali")
    @NotifyChange({"assetDTO", "assetDTOs"})
    public void buttonKembali(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("assetDTOs")
    public void refreshData() {
        assetDTOs = assetService.findAll();
    }

    @Command("detailAsset")
    @NotifyChange("asset")
    public void detailAsset(@BindingParam("object") AssetDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("assetDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/financial-management/asset/add.asset.zul", window, params);
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
