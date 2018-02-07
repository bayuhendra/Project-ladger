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
public interface PembelianRepository {

    void saveOrUpdate(Pembelian pembelian);

    void deleteData(Pembelian pembelian);

    Pembelian findByID(String pembelianID);

    List<Pembelian> findAll();

    List<Pembelian> findByParams(Map map);

    List<Pembelian> findAllByStatus(StatusTransaksi statusTransaksi);
}
