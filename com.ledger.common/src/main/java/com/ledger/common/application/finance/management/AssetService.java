package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.asset.AssetDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface AssetService {

    void SaveOrUpdate(AssetDTO asset);

    void deleteData(AssetDTO asset);

    AssetDTO getDummyData();

    AssetDTO findByID(String assetID);

    List<AssetDTO> findAll();
    
    List<AssetDTO> findByUserID(String userID);

    List<AssetDTO> findByParams(Map map);
}
