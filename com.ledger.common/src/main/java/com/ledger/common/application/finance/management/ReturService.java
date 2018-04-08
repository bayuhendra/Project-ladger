package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.ReturDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface ReturService {

    void SaveOrUpdate(ReturDTO retur);

    void deleteData(ReturDTO retur);

    ReturDTO getDummyData();

    ReturDTO findByID(String returID);

    List<ReturDTO> findAll();

    List<ReturDTO> findByParams(Map map);

}
