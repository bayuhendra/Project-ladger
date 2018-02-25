package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.HutangDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface HutangService {

    void SaveOrUpdate(HutangDTO hutang);

    void deleteData(HutangDTO hutang);

    HutangDTO getDummyData();

    HutangDTO findByID(String hutangID);

    List<HutangDTO> findAll();

    List<HutangDTO> findByUserID(String userID);

    List<HutangDTO> findByParams(Map map);
}
