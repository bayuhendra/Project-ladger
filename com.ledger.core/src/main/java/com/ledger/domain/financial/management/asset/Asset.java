package com.ledger.domain.financial.management.asset;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class Asset implements EntityObject<Asset> {

    long id;
    private String assetdID;
    private String namaAsset;
    private String jenisAsset;
    private double nilaiAsset;
    private String keterangan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Asset() {
    }

    public Asset(String assetdID, String namaAsset, String jenisAsset, double nilaiAsset, String keterangan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.assetdID = assetdID;
        this.namaAsset = namaAsset;
        this.jenisAsset = jenisAsset;
        this.nilaiAsset = nilaiAsset;
        this.keterangan = keterangan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public String getAssetdID() {
        return assetdID;
    }

    public void setAssetdID(String assetdID) {
        this.assetdID = assetdID;
    }

    public String getNamaAsset() {
        return namaAsset;
    }

    public void setNamaAsset(String namaAsset) {
        this.namaAsset = namaAsset;
    }

    public String getJenisAsset() {
        return jenisAsset;
    }

    public void setJenisAsset(String jenisAsset) {
        this.jenisAsset = jenisAsset;
    }

    public double getNilaiAsset() {
        return nilaiAsset;
    }

    public void setNilaiAsset(double nilaiAsset) {
        this.nilaiAsset = nilaiAsset;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.assetdID);
        hash = 37 * hash + Objects.hashCode(this.namaAsset);
        hash = 37 * hash + Objects.hashCode(this.jenisAsset);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.nilaiAsset) ^ (Double.doubleToLongBits(this.nilaiAsset) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.keterangan);
        hash = 37 * hash + Objects.hashCode(this.createdBy);
        hash = 37 * hash + Objects.hashCode(this.createdDate);
        hash = 37 * hash + Objects.hashCode(this.modifiedBy);
        hash = 37 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asset other = (Asset) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataAsset(Asset asset) {
        this.assetdID = asset.assetdID;
        this.namaAsset = asset.namaAsset;
        this.jenisAsset = asset.jenisAsset;
        this.nilaiAsset = asset.nilaiAsset;
        this.keterangan = asset.keterangan;
        this.modifiedBy = asset.modifiedBy;
        this.modifiedDate = asset.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Asset other) {
        return this.equals(other);
    }

}
