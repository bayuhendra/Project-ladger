package com.ledger.domain.financial.management.asset;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface AssetRepository {

    void saveOrUpdate(Asset asset);

    void deleteData(Asset asset);

    Asset findByID(String assetID);

    List<Asset> findAll();
    
    List<Asset> findByUserID(String userID);

    List<Asset> findByParams(Map map);

}
