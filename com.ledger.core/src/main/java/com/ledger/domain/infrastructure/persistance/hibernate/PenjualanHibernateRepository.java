/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.infrastructure.persistance.hibernate;

import com.ledger.domain.financial.management.Penjualan;
import com.ledger.domain.financial.management.PenjualanRepository;
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
public class PenjualanHibernateRepository extends HibernateRepository implements PenjualanRepository {

    @Override
    public void saveOrUpdate(Penjualan penjualan) {
        getSession().saveOrUpdate(penjualan);
    }

    @Override
    public void deleteData(Penjualan penjualan) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.Penjualan where penjualanID = :cid");
        query.setParameter("cid", penjualan.getPenjualanID());
        query.executeUpdate();
    }

    @Override
    public Penjualan findByID(String penjualanID) {
        return (Penjualan) getSession()
                .createQuery("from com.ledger.domain.financial.management.Penjualan where penjualanID = :cid")
                .setParameter("cid", penjualanID)
                .uniqueResult();
    }

    @Override
    public List<Penjualan> findAll() {
        return (List<Penjualan>) getSession()
                .createQuery("from com.ledger.domain.financial.management.Penjualan ")
                .list();
    }

    @Override
    public List<Penjualan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Penjualan.class);
        if (StringUtil.hasValue(map.get("penjualanID"))) {
            criteria.add(Restrictions.eq("penjualanID", map.get("penjualanID")));
        }
        if (StringUtil.hasValue(map.get("namaBarang"))) {
            criteria.add(Restrictions.like("namaBarang", "%" + map.get("namaBarang") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("statusPenjualan"))) {
            criteria.add(Restrictions.eq("statusPenjualan", map.get("statusPenjualan")));
        }

        return criteria.list();
    }

    @Override
    public List<Penjualan> findAllByStatus(StatusTransaksi statusTransaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
