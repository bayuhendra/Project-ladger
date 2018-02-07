/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    List<Penjualan> findByParams(Map map);

    List<Penjualan> findAllByStatus(StatusTransaksi statusTransaksi);
}
