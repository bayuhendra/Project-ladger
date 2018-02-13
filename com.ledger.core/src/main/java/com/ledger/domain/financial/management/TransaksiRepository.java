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
public interface TransaksiRepository {

    void saveOrUpdate(Transaksi transaksi);

    void deleteData(Transaksi transaksi);

    Transaksi findByID(String transaksiID);

    List<Transaksi> findAll();

    List<Transaksi> findByParams(Map map);

    List<Transaksi> findAllByStatus(StatusTransaksi statusTransaksi);
}
