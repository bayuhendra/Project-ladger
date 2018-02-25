package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.ActivaTetap;
import com.ledger.domain.financial.management.ActivaTetapRepository;
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
public class ActivaTetapHibernateRepository extends HibernateRepository implements ActivaTetapRepository {

    @Override
    public void saveOrUpdate(ActivaTetap activaTetap) {
        getSession().saveOrUpdate(activaTetap);
    }

    @Override
    public void deleteData(ActivaTetap activaTetap) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.ActivaTetap where activaTetapID = :cid");
        query.setParameter("cid", activaTetap.getActivaTetapID());
        query.executeUpdate();
    }

    @Override
    public ActivaTetap findByID(String activaTetapID) {
        return (ActivaTetap) getSession()
                .createQuery("from com.ledger.domain.financial.management.ActivaTetap where activaTetapID = :cid")
                .setParameter("cid", activaTetapID)
                .uniqueResult();
    }

    @Override
    public List<ActivaTetap> findAll() {
        return (List<ActivaTetap>) getSession()
                .createQuery("from com.ledger.domain.financial.management.ActivaTetap")
                .list();
    }

    @Override
    public List<ActivaTetap> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(ActivaTetap.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("activaTetapID"))) {
            criteria.add(Restrictions.eq("activaTetapID", map.get("activaTetapID")));
        }
        if (StringUtil.hasValue(map.get("namaActivaTetap"))) {
            criteria.add(Restrictions.eq("namaActivaTetap", map.get("namaActivaTetap")));
        }
        return criteria.list();
    }

    @Override
    public List<ActivaTetap> findByUserID(String userID) {
        return (List<ActivaTetap>) getSession()
                .createQuery("from com.ledger.domain.financial.management.ActivaTetap where userID = :cid")
                .setParameter("cid", userID)
                .list();
    }

}
