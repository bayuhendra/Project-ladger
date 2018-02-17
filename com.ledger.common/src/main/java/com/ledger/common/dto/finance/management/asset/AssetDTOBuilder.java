package com.ledger.common.dto.finance.management.asset;

import java.util.Date;

public class AssetDTOBuilder {

    private String assetdID;
    private String namaAsset;
    private String userID;
    private String jenisAsset;
    private double nilaiAsset;
    private String keterangan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public AssetDTOBuilder() {
    }

    public AssetDTOBuilder setAssetdID(String assetdID) {
        this.assetdID = assetdID;
        return this;
    }

    public AssetDTOBuilder setNamaAsset(String namaAsset) {
        this.namaAsset = namaAsset;
        return this;
    }

    public AssetDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public AssetDTOBuilder setJenisAsset(String jenisAsset) {
        this.jenisAsset = jenisAsset;
        return this;
    }

    public AssetDTOBuilder setNilaiAsset(double nilaiAsset) {
        this.nilaiAsset = nilaiAsset;
        return this;
    }

    public AssetDTOBuilder setKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public AssetDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AssetDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AssetDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public AssetDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public AssetDTO createAssetDTO() {
        return new AssetDTO(assetdID, namaAsset, userID, jenisAsset, nilaiAsset, keterangan, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
