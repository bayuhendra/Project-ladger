package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Transaksi;
import com.ledger.domain.financial.management.TransaksiRepository;
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
public class TransaksiHibernateRepository extends HibernateRepository implements TransaksiRepository {

    @Override
    public void saveOrUpdate(Transaksi transaksi) {
        getSession().saveOrUpdate(transaksi);
    }

    @Override
    public void deleteData(Transaksi transaksi) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Transaksi where transaksiID = :cid");
        query.setParameter("cid", transaksi.getTransaksiID());
        query.executeUpdate();
    }

    @Override
    public Transaksi findByID(String transaksiID) {
        return (Transaksi) getSession()
                .createQuery("from com.ledger.domain.financial.management.Transaksi where transaksiID = :cid")
                .setParameter("cid", transaksiID)
                .uniqueResult();
    }

    @Override
    public List<Transaksi> findAll() {
        return (List<Transaksi>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Transaksi ")
                .list();
    }

    @Override
    public List<Transaksi> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Transaksi.class);
        if (StringUtil.hasValue(map.get("transaksiID"))) {
            criteria.add(Restrictions.eq("transaksiID", map.get("transaksiID")));
        }
        if (StringUtil.hasValue(map.get("namaBarang"))) {
            criteria.add(Restrictions.like("namaBarang", "%" + map.get("namaBarang") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("statusTransaksi"))) {
            criteria.add(Restrictions.eq("statusTransaksi", map.get("statusTransaksi")));
        }
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.like("userID", "%" + map.get("userID") + "%").ignoreCase());
        }

        return criteria.list();
    }

    @Override
    public List<Transaksi> findAllByStatus(String statusTransaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaksi> findByUserID(String userID) {
        return (List<Transaksi>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Transaksi where userID = :cid")
                .setParameter("cid", userID)
                .list();
    }

}
