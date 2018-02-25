package com.ledger.domain.financial.management;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface SaldoKasRepository {

    void saveOrUpdate(SaldoKas saldoKas);

    void deleteData(SaldoKas saldoKas);

    SaldoKas findByID(String saldoKasID);

    List<SaldoKas> findAll();

    SaldoKas findByUserID(String userID);

    List<SaldoKas> findByParams(Map map);

}
