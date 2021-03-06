/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.PembelianDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface PembelianService {
    
    void SaveOrUpdate(PembelianDTO pembelian);

    void deleteData(PembelianDTO pembelian);

    PembelianDTO getDummyData();

    PembelianDTO findByID(String pembelianID);
    
    List<PembelianDTO> findbyName(String namaBarang);

    List<PembelianDTO> findAll();

    List<PembelianDTO> findByParams(Map map);

}
