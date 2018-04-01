package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.OpeningBalanceFlagDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface OpeningBalanceFlagService {

    void SaveOrUpdate(OpeningBalanceFlagDTO openingBalanceFlag);

    void deleteData(OpeningBalanceFlagDTO openingBalanceFlag);

    OpeningBalanceFlagDTO getDummyData();

    OpeningBalanceFlagDTO findByID(String openingBalanceFlagID);

    List<OpeningBalanceFlagDTO> findAll();

    OpeningBalanceFlagDTO findByUserID(String userID);

    List<OpeningBalanceFlagDTO> findByParams(Map map);
}
