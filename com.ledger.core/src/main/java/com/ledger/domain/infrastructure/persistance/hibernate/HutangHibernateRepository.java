package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Hutang;
import com.ledger.domain.financial.management.HutangRepository;
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
public class HutangHibernateRepository extends HibernateRepository implements HutangRepository {

    @Override
    public void saveOrUpdate(Hutang hutang) {
        getSession().saveOrUpdate(hutang);
    }

    @Override
    public void deleteData(Hutang hutang) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Hutang where hutangID = :cid");
        query.setParameter("cid", hutang.getHutangID());
        query.executeUpdate();
    }

    @Override
    public Hutang findByID(String hutangID) {
        return (Hutang) getSession()
                .createQuery("from com.ledger.domain.financial.management.Hutang where hutangID = :cid")
                .setParameter("cid", hutangID)
                .uniqueResult();
    }

    @Override
    public List<Hutang> findAll() {
        return (List<Hutang>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Hutang")
                .list();
    }

    @Override
    public List<Hutang> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Hutang.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("hutangID"))) {
            criteria.add(Restrictions.eq("hutangID", map.get("hutangID")));
        }
        if (StringUtil.hasValue(map.get("namaHutang"))) {
            criteria.add(Restrictions.eq("namaHutang", map.get("namaHutang")));
        }
        return criteria.list();
    }

    @Override
    public List<Hutang> findByUserID(String userID) {
        return (List<Hutang>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Hutang where userID = :cid")
                .setParameter("cid", userID)
                .list();
    }

}
