package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.SaldoKasDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface SaldoKasService {

    void SaveOrUpdate(SaldoKasDTO saldoKas);

    void deleteData(SaldoKasDTO saldoKas);

    SaldoKasDTO getDummyData();

    SaldoKasDTO findByID(String saldoKasID);

    List<SaldoKasDTO> findAll();

    SaldoKasDTO findByUserID(String userID);

    List<SaldoKasDTO> findByParams(Map map);
}
