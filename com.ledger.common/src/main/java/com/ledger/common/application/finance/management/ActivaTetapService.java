package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.ActivaTetapDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface ActivaTetapService {

    void SaveOrUpdate(ActivaTetapDTO activaTetap);

    void deleteData(ActivaTetapDTO activaTetap);

    ActivaTetapDTO getDummyData();

    ActivaTetapDTO findByID(String activaTetapID);

    List<ActivaTetapDTO> findAll();

    List<ActivaTetapDTO> findByUserID(String userID);

    List<ActivaTetapDTO> findByParams(Map map);
}
