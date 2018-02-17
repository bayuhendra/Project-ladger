package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.asset.AssetDTO;
import com.ledger.common.dto.finance.management.asset.AssetDTOBuilder;
import com.ledger.domain.financial.management.asset.Asset;
import com.ledger.domain.financial.management.asset.AssetBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class AssetDTOAssembler implements IObjectAssembler<Asset, AssetDTO> {

    @Override
    public AssetDTO toDTO(Asset domainObject) {
        return new AssetDTOBuilder()
                .setAssetdID(domainObject.getAssetdID())
                .setNamaAsset(domainObject.getNamaAsset())
                .setUserID(domainObject.getUserID())
                .setJenisAsset(domainObject.getJenisAsset())
                .setNilaiAsset(domainObject.getNilaiAsset())
                .setKeterangan(domainObject.getKeterangan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createAssetDTO();
    }

    @Override
    public Asset toDomain(AssetDTO dtoObject) {
        return new AssetBuilder()
                .setAssetdID(dtoObject.getAssetdID())
                .setNamaAsset(dtoObject.getNamaAsset())
                .setUserID(dtoObject.getUserID())
                .setJenisAsset(dtoObject.getJenisAsset())
                .setNilaiAsset(dtoObject.getNilaiAsset())
                .setKeterangan(dtoObject.getKeterangan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createAsset();
    }

    public List<Asset> toDomains(List<AssetDTO> arg0) {
        List<Asset> res = new ArrayList<>();
        for (AssetDTO t : arg0) {
            res.add(new AssetDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<AssetDTO> toDTOs(List<Asset> arg0) {
        List<AssetDTO> res = new ArrayList<>();
        for (Asset t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
