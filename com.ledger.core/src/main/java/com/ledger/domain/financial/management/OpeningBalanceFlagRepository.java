package com.ledger.domain.financial.management;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface OpeningBalanceFlagRepository {

    void saveOrUpdate(OpeningBalanceFlag openingBalanceFlag);

    void deleteData(OpeningBalanceFlag openingBalanceFlag);

    OpeningBalanceFlag findByID(String openingBalanceFlagID);

    List<OpeningBalanceFlag> findAll();

    OpeningBalanceFlag findByUserID(String userID);

    List<OpeningBalanceFlag> findByParams(Map map);

}
