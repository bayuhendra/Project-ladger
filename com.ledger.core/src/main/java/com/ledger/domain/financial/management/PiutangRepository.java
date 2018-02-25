package com.ledger.domain.financial.management;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PiutangRepository {

    void saveOrUpdate(Piutang piutang);

    void deleteData(Piutang piutang);

    Piutang findByID(String piutangID);

    List<Piutang> findAll();

    List<Piutang> findByUserID(String userID);

    List<Piutang> findByParams(Map map);

}
