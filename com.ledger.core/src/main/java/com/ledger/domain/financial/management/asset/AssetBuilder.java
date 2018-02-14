package com.ledger.domain.financial.management.asset;

import java.util.Date;

public class AssetBuilder {

    private String assetdID;
    private String namaAsset;
    private String jenisAsset;
    private double nilaiAsset;
    private String keterangan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public AssetBuilder() {
    }

    public AssetBuilder setAssetdID(String assetdID) {
        this.assetdID = assetdID;
        return this;
    }

    public AssetBuilder setNamaAsset(String namaAsset) {
        this.namaAsset = namaAsset;
        return this;
    }

    public AssetBuilder setJenisAsset(String jenisAsset) {
        this.jenisAsset = jenisAsset;
        return this;
    }

    public AssetBuilder setNilaiAsset(double nilaiAsset) {
        this.nilaiAsset = nilaiAsset;
        return this;
    }

    public AssetBuilder setKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public AssetBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AssetBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AssetBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public AssetBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Asset createAsset() {
        return new Asset(assetdID, namaAsset, jenisAsset, nilaiAsset, keterangan, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
