package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Retur;
import com.ledger.domain.financial.management.ReturRepository;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.util.StringUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BayuHS
 */
@Repository
@Transactional
public class ReturHibernateRepository extends HibernateRepository implements ReturRepository {

    @Override
    public void saveOrUpdate(Retur retur) {
        getSession().saveOrUpdate(retur);
    }

    @Override
    public void deleteData(Retur retur) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Retur where returID = :cid");
        query.setParameter("cid", retur.getReturID());
        query.executeUpdate();
    }

    @Override
    public Retur findByID(String returID) {
        return (Retur) getSession()
                .createQuery("from com.ledger.domain.financial.management.Retur where returID = :cid")
                .setParameter("cid", returID)
                .uniqueResult();
    }

    @Override
    public List<Retur> findAll() {
        return (List<Retur>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Retur ")
                .list();
    }

    @Override
    public List<Retur> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Retur.class);
        if (StringUtil.hasValue(map.get("returID"))) {
            criteria.add(Restrictions.eq("returID", map.get("returID")));
        }
        if (StringUtil.hasValue(map.get("transaksiID"))) {
            criteria.add(Restrictions.eq("transaksiID", map.get("transaksiID")));
        }
        if (StringUtil.hasValue(map.get("jenisRetur"))) {
            criteria.add(Restrictions.eq("jenisRetur", map.get("jenisRetur")));
        }
        if (StringUtil.hasValue(map.get("namaBarang"))) {
            criteria.add(Restrictions.like("namaBarang", "%" + map.get("namaBarang") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("statusRetur"))) {
            criteria.add(Restrictions.eq("statusRetur", map.get("statusRetur")));
        }

        return criteria.list();
    }

    @Override
    public List<Retur> findAllByStatus(StatusTransaksi statusTransaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
