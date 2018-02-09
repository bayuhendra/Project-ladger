/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.PenjualanDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface PenjualanService {

    void SaveOrUpdate(PenjualanDTO penjualan);

    void deleteData(PenjualanDTO penjualan);

    PenjualanDTO getDummyData();

    PenjualanDTO findByID(String penjualanID);

    List<PenjualanDTO> findAll();

    List<PenjualanDTO> findByParams(Map map);
}
