package com.ledger.common.application.finance.management;

import com.ledger.common.dto.finance.management.PiutangDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PiutangService {

    void SaveOrUpdate(PiutangDTO piutang);

    void deleteData(PiutangDTO piutang);

    PiutangDTO getDummyData();

    PiutangDTO findByID(String piutangID);

    List<PiutangDTO> findAll();

    List<PiutangDTO> findByUserID(String userID);

    List<PiutangDTO> findByParams(Map map);
}
