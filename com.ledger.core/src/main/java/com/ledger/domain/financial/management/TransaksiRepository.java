package com.ledger.domain.financial.management;

import com.ledger.shared.status.StatusTransaksi;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface TransaksiRepository {

    void saveOrUpdate(Transaksi transaksi);

    void deleteData(Transaksi transaksi);

    Transaksi findByID(String transaksiID);

    List<Transaksi> findAll();

    List<Transaksi> findByParams(Map map);

    List<Transaksi> findAllByStatus(String statusTransaksi);
}
