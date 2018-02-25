package com.ledger.domain.financial.management;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface HutangRepository {

    void saveOrUpdate(Hutang hutang);

    void deleteData(Hutang hutang);

    Hutang findByID(String hutangID);

    List<Hutang> findAll();

    List<Hutang> findByUserID(String userID);

    List<Hutang> findByParams(Map map);

}
