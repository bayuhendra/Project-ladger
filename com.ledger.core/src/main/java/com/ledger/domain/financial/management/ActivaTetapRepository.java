package com.ledger.domain.financial.management;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface ActivaTetapRepository {

    void saveOrUpdate(ActivaTetap activaTetap);

    void deleteData(ActivaTetap activaTetap);

    ActivaTetap findByID(String activaTetapID);

    List<ActivaTetap> findAll();

    List<ActivaTetap> findByUserID(String userID);

    List<ActivaTetap> findByParams(Map map);

}
