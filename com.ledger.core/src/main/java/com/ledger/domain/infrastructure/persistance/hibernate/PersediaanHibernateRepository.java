package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Persediaan;
import com.ledger.domain.financial.management.PersediaanRepository;
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
public class PersediaanHibernateRepository extends HibernateRepository implements PersediaanRepository {

    @Override
    public void saveOrUpdate(Persediaan persediaan) {
        getSession().saveOrUpdate(persediaan);
    }

    @Override
    public void deleteData(Persediaan persediaan) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Persediaan where persediaanID = :cid");
        query.setParameter("cid", persediaan.getPersediaanID());
        query.executeUpdate();
    }

    @Override
    public Persediaan findByID(String persediaanID) {
        return (Persediaan) getSession()
                .createQuery("from com.ledger.domain.financial.management.Persediaan where persediaanID = :cid")
                .setParameter("cid", persediaanID)
                .uniqueResult();
    }

    @Override
    public List<Persediaan> findAll() {
        return (List<Persediaan>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Persediaan")
                .list();
    }

    @Override
    public List<Persediaan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Persediaan.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("persediaanID"))) {
            criteria.add(Restrictions.eq("persediaanID", map.get("persediaanID")));
        }
        if (StringUtil.hasValue(map.get("namaPersediaan"))) {
            criteria.add(Restrictions.eq("namaPersediaan", map.get("namaPersediaan")));
        }
        return criteria.list();
    }

    @Override
    public List<Persediaan> findByUserID(String userID) {
        return (List<Persediaan>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Persediaan where userID = :cid")
                .setParameter("cid", userID)
                .list();
    }

}
