/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.TransaksiDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface TransaksiService {

    void SaveOrUpdate(TransaksiDTO transaksi);

    void deleteData(TransaksiDTO transaksi);

    TransaksiDTO getDummyData();

    TransaksiDTO findByID(String transaksiID);

    List<TransaksiDTO> findAll();

    List<TransaksiDTO> findByParams(Map map);
}
