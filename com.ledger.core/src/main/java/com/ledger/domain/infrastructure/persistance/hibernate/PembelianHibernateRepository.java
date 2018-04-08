/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Pembelian;
import com.ledger.domain.financial.management.PembelianRepository;
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
public class PembelianHibernateRepository extends HibernateRepository implements PembelianRepository {

    @Override
    public void saveOrUpdate(Pembelian pembelian) {
        getSession().saveOrUpdate(pembelian);
    }

    @Override
    public void deleteData(Pembelian pembelian) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Pembelian where pembelianID = :cid");
        query.setParameter("cid", pembelian.getPembelianID());
        query.executeUpdate();
    }

    @Override
    public Pembelian findByID(String pembelianID) {
        return (Pembelian) getSession()
                .createQuery("from com.ledger.domain.financial.management.Pembelian where pembelianID = :cid")
                .setParameter("cid", pembelianID)
                .uniqueResult();
    }

    @Override
    public List<Pembelian> findAll() {
        return (List<Pembelian>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Pembelian ")
                .list();
    }

    @Override
    public List<Pembelian> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Pembelian.class);
        if (StringUtil.hasValue(map.get("pembelianID"))) {
            criteria.add(Restrictions.eq("pembelianID", map.get("pembelianID")));
        }
        if (StringUtil.hasValue(map.get("namaBarang"))) {
            criteria.add(Restrictions.like("namaBarang", "%" + map.get("namaBarang") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("statusPembelian"))) {
            criteria.add(Restrictions.eq("statusPembelian", map.get("statusPembelian")));
        }

        return criteria.list();
    }

    @Override
    public List<Pembelian> findAllByStatus(StatusTransaksi statusTransaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pembelian> findbyName(String namaBarang) {
        return (List<Pembelian>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Pembelian where namaBarang = :cid")
                .setParameter("cid", namaBarang)
                .list();
    }

}
