package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.SaldoKas;
import com.ledger.domain.financial.management.SaldoKasRepository;
import com.ledger.domain.financial.management.asset.Asset;
import com.ledger.domain.financial.management.asset.AssetRepository;
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
 * @author lintang
 */
@Repository
@Transactional
public class SaldoKasHibernateRepository extends HibernateRepository implements SaldoKasRepository {

    @Override
    public void saveOrUpdate(SaldoKas saldoKas) {
        getSession().saveOrUpdate(saldoKas);
    }

    @Override
    public void deleteData(SaldoKas saldoKas) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.SaldoKas where saldoKasID = :cid");
        query.setParameter("cid", saldoKas.getSaldoKasID());
        query.executeUpdate();
    }

    @Override
    public SaldoKas findByID(String saldoKasID) {
        return (SaldoKas) getSession()
                .createQuery("from com.ledger.domain.financial.management.SaldoKas where saldoKasID = :cid")
                .setParameter("cid", saldoKasID)
                .uniqueResult();
    }

    @Override
    public List<SaldoKas> findAll() {
        return (List<SaldoKas>) getSession()
                .createQuery("from com.ledger.domain.financial.management.SaldoKas")
                .list();
    }

    @Override
    public List<SaldoKas> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(SaldoKas.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("saldoKasID"))) {
            criteria.add(Restrictions.eq("saldoKasID", map.get("saldoKasID")));
        }
        return criteria.list();
    }

    @Override
    public SaldoKas findByUserID(String userID) {
        return (SaldoKas) getSession()
                .createQuery("from com.ledger.domain.financial.management.SaldoKas where userID = :cid")
                .setParameter("cid", userID)
                .uniqueResult();
    }

}
