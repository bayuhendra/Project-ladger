package com.ledger.application.impl;

import com.ledger.common.application.finance.management.AssetService;
import com.ledger.common.dto.finance.management.asset.AssetDTO;
import com.ledger.domain.financial.management.asset.Asset;
import com.ledger.domain.financial.management.asset.AssetBuilder;
import com.ledger.domain.financial.management.asset.AssetRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.AssetDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class AssetServiceImpl implements AssetService {

    private AssetDTOAssembler assetDTOAssembler;
    private AssetRepository assetRepository;

    public void setAssetDTOAssembler(AssetDTOAssembler assetDTOAssembler) {
        this.assetDTOAssembler = assetDTOAssembler;
    }

    public void setAssetRepository(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public void SaveOrUpdate(AssetDTO asset) {
        Asset t = assetRepository.findByID(asset.getAssetdID());

        if (t == null) {
            t = assetDTOAssembler.toDomain(asset);
        } else {
            Asset newAsset = assetDTOAssembler.toDomain(asset);
            t.assignNewDataAsset(newAsset);

        }
        assetRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(AssetDTO asset) {
        Asset p = assetDTOAssembler.toDomain(asset);
        assetRepository.deleteData(p);
    }

    @Override
    public AssetDTO getDummyData() {
        Asset asset = new AssetBuilder()
                .setAssetdID("ASSET001")
                .setNamaAsset("TANAH")
                .setJenisAsset("NON ELEKTRONIK")
                .setNilaiAsset(50000000.0)
                .setKeterangan("Keterangan")
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createAsset();
        return assetDTOAssembler.toDTO(asset);
    }

    @Override
    public AssetDTO findByID(String assetID) {
        Validate.notNull(assetRepository);
        Asset b = (Asset) assetRepository.findByID(assetID);
        if (b != null) {
            return assetDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<AssetDTO> findAll() {
        Validate.notNull(assetRepository);
        List<Asset> listAsset = assetRepository.findAll();
        if (listAsset != null) {
            return (List<AssetDTO>) assetDTOAssembler.toDTOs(listAsset);
        }
        return null;
    }

    @Override
    public List<AssetDTO> findByParams(Map map) {
        Validate.notNull(assetRepository);
        List<Asset> listAsset = assetRepository.findByParams(map);
        if (listAsset != null) {
            return (List<AssetDTO>) assetDTOAssembler.toDTOs(listAsset);
        }
        return null;
    }

    @Override
    public List<AssetDTO> findByUserID(String userID) {
        Validate.notNull(assetRepository);
        List<Asset> listAsset = assetRepository.findByUserID(userID);
        if (listAsset != null) {
            return (List<AssetDTO>) assetDTOAssembler.toDTOs(listAsset);
        }
        return null;
    }

}
