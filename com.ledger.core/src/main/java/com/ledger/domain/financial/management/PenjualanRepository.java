package com.ledger.domain.financial.management;

import com.ledger.shared.status.StatusTransaksi;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface PenjualanRepository {

    void saveOrUpdate(Penjualan penjualan);

    void deleteData(Penjualan penjualan);

    Penjualan findByID(String penjualanID);

    List<Penjualan> findAll();
    
    List<Penjualan> findbyName(String namaBarang);

    List<Penjualan> findByParams(Map map);

    List<Penjualan> findAllByStatus(StatusTransaksi statusTransaksi);
}
