package com.ledger.common.dto.finance.management.asset;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class AssetDTO implements Serializable {

    private String assetdID;
    private String namaAsset;
    private String jenisAsset;
    private double nilaiAsset;
    private String keterangan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public AssetDTO() {
    }

    public AssetDTO(String assetdID, String namaAsset, String jenisAsset, double nilaiAsset, String keterangan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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
    public String toString() {
        return "AssetDTO{" + "assetdID=" + assetdID + ", namaAsset=" + namaAsset + ", jenisAsset=" + jenisAsset + ", nilaiAsset=" + nilaiAsset + ", keterangan=" + keterangan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
