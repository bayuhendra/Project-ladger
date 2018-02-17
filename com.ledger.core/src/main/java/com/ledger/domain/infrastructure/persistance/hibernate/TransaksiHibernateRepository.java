/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Transaksi;
import com.ledger.domain.financial.management.TransaksiRepository;
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
        if (StringUtil.hasValue(map.get("userIDTransaksi"))) {
            criteria.add(Restrictions.like("userIDTransaksi", "%" + map.get("userIDTransaksi") + "%").ignoreCase());
        }

        return criteria.list();
    }

    @Override
    public List<Transaksi> findAllByStatus(StatusTransaksi statusTransaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
