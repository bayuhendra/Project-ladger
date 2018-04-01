package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.OpeningBalanceFlag;
import com.ledger.domain.financial.management.OpeningBalanceFlagRepository;
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
public class OpeningBalanceFlagHibernateRepository extends HibernateRepository implements OpeningBalanceFlagRepository {

    @Override
    public void saveOrUpdate(OpeningBalanceFlag openingBalanceFlag) {
        getSession().saveOrUpdate(openingBalanceFlag);
    }

    @Override
    public void deleteData(OpeningBalanceFlag openingBalanceFlag) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.OpeningBalanceFlag where openingBalanceFlagID = :cid");
        query.setParameter("cid", openingBalanceFlag.getOpeningBalanceFlagID());
        query.executeUpdate();
    }

    @Override
    public OpeningBalanceFlag findByID(String openingBalanceFlagID) {
        return (OpeningBalanceFlag) getSession()
                .createQuery("from com.ledger.domain.financial.management.OpeningBalanceFlag where openingBalanceFlagID = :cid")
                .setParameter("cid", openingBalanceFlagID)
                .uniqueResult();
    }

    @Override
    public List<OpeningBalanceFlag> findAll() {
        return (List<OpeningBalanceFlag>) getSession()
                .createQuery("from com.ledger.domain.financial.management.OpeningBalanceFlag")
                .list();
    }

    @Override
    public List<OpeningBalanceFlag> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(OpeningBalanceFlag.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("openingBalanceFlagID"))) {
            criteria.add(Restrictions.eq("openingBalanceFlagID", map.get("openingBalanceFlagID")));
        }
        return criteria.list();
    }

    @Override
    public OpeningBalanceFlag findByUserID(String userID) {
        return (OpeningBalanceFlag) getSession()
                .createQuery("from com.ledger.domain.financial.management.OpeningBalanceFlag where userID = :cid")
                .setParameter("cid", userID)
                .uniqueResult();
    }

}
