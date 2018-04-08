package com.ledger.domain.financial.management;

import com.ledger.shared.status.StatusTransaksi;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface ReturRepository {

    void saveOrUpdate(Retur retur);

    void deleteData(Retur retur);

    Retur findByID(String returID);

    List<Retur> findAll();

    List<Retur> findByParams(Map map);

    List<Retur> findAllByStatus(StatusTransaksi statusTransaksi);
}
