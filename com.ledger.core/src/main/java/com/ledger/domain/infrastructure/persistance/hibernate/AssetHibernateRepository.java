package com.ledger.domain.infrastructure.persistance.hibernate;

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
public class AssetHibernateRepository extends HibernateRepository implements AssetRepository {

    @Override
    public void saveOrUpdate(Asset asset) {
        getSession().saveOrUpdate(asset);
    }

    @Override
    public void deleteData(Asset asset) {
        Query query = getSession().createQuery("delete from com.ledger.domain.financial.management.asset.Asset where assetdID = :cid");
        query.setParameter("cid", asset.getAssetdID());
        query.executeUpdate();
    }

    @Override
    public Asset findByID(String assetID) {
        return (Asset) getSession()
                .createQuery("from com.ledger.domain.financial.management.asset.Asset where assetdID = :cid")
                .setParameter("cid", assetID)
                .uniqueResult();
    }

    @Override
    public List<Asset> findAll() {
        return (List<Asset>) getSession()
                .createQuery("from com.ledger.domain.financial.management.asset.Asset")
                .list();
    }

    @Override
    public List<Asset> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Asset.class);
        if (StringUtil.hasValue(map.get("userID"))) {
            criteria.add(Restrictions.eq("userID", map.get("userID")));
        }
        if (StringUtil.hasValue(map.get("assetdID"))) {
            criteria.add(Restrictions.eq("assetdID", map.get("assetdID")));
        }
        if (StringUtil.hasValue(map.get("namaAsset"))) {
            criteria.add(Restrictions.like("namaAsset", "%" + map.get("namaAsset") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("jenisAsset"))) {
            criteria.add(Restrictions.eq("jenisAsset", map.get("jenisAsset")));
        }

        return criteria.list();
    }

    @Override
    public List<Asset> findByUserID(String userID) {
        return (List<Asset>) getSession()
                .createQuery("from com.ledger.domain.financial.management.asset.Asset where userID = :cid")
                .setParameter("cid", userID)
                .list();
    }

}
