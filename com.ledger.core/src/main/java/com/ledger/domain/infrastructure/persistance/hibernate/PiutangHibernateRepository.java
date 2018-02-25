package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Piutang;
import com.ledger.domain.financial.management.PiutangRepository;
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
public class PiutangHibernateRepository extends HibernateRepository implements PiutangRepository {

    @Override
    public void saveOrUpdate(Piutang piutang) {
        getSession().saveOrUpdate(piutang);
    }

    @Override
    public void deleteData(Piutang piutang) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Piutang where piutangID = :cid");
        query.setParameter("cid", piutang.getPiutangID());
        query.executeUpdate();
    }

    @Override
    public Piutang findByID(String piutangID) {
        return (Piutang) getSession()
                .createQuery("from com.ledger.domain.financial.management.Piutang where piutangID = :cid")
                .setParameter("cid", piutangID)
                .uniqueResult();
    }

    @Override
    public List<Piutang> findAll() {
        return (List<Piutang>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Piutang")
                .list();
    }

    @Override
    public List<Piutang> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Piutang.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("piutangID"))) {
            criteria.add(Restrictions.eq("piutangID", map.get("piutangID")));
        }
        if (StringUtil.hasValue(map.get("namaPiutang"))) {
            criteria.add(Restrictions.eq("namaPiutang", map.get("namaPiutang")));
        }
        return criteria.list();
    }

    @Override
    public List<Piutang> findByUserID(String userID) {
        return (List<Piutang>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Piutang where userID = :cid")
                .setParameter("cid", userID)
                .list();
    }

}
