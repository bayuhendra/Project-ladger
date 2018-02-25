package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.PersediaanDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PersediaanService {

    void SaveOrUpdate(PersediaanDTO persediaan);

    void deleteData(PersediaanDTO persediaan);

    PersediaanDTO getDummyData();

    PersediaanDTO findByID(String persediaanID);

    List<PersediaanDTO> findAll();

    List<PersediaanDTO> findByUserID(String userID);

    List<PersediaanDTO> findByParams(Map map);
}
