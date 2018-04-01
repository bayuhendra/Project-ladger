package com.ledger.domain.financial.management;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PersediaanRepository {

    void saveOrUpdate(Persediaan persediaan);

    void deleteData(Persediaan persediaan);

    Persediaan findByID(String persediaanID);
    
    Persediaan findByName(String namaPersediaan);

    List<Persediaan> findAll();

    List<Persediaan> findByUserID(String userID);

    List<Persediaan> findByParams(Map map);

}
