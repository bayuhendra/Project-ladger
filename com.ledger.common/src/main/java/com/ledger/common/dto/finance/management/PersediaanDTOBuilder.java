package com.ledger.common.dto.finance.management;

import java.util.Date;


public class PersediaanDTOBuilder {
    private String userID;
    private String persediaanID;
    private String namaPersediaan;
    private String jenisPersediaan;
    private int jumlahPersediaan;
    private double hargaPersediaan;
    private double totalHargaPersediaan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PersediaanDTOBuilder() {
    }

    public PersediaanDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PersediaanDTOBuilder setPersediaanID(String persediaanID) {
        this.persediaanID = persediaanID;
        return this;
    }

    public PersediaanDTOBuilder setNamaPersediaan(String namaPersediaan) {
        this.namaPersediaan = namaPersediaan;
        return this;
    }

    public PersediaanDTOBuilder setJenisPersediaan(String jenisPersediaan) {
        this.jenisPersediaan = jenisPersediaan;
        return this;
    }

    public PersediaanDTOBuilder setJumlahPersediaan(int jumlahPersediaan) {
        this.jumlahPersediaan = jumlahPersediaan;
        return this;
    }

    public PersediaanDTOBuilder setHargaPersediaan(double hargaPersediaan) {
        this.hargaPersediaan = hargaPersediaan;
        return this;
    }

    public PersediaanDTOBuilder setTotalHargaPersediaan(double totalHargaPersediaan) {
        this.totalHargaPersediaan = totalHargaPersediaan;
        return this;
    }

    public PersediaanDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PersediaanDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PersediaanDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PersediaanDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PersediaanDTO createPersediaanDTO() {
        return new PersediaanDTO(userID, persediaanID, namaPersediaan, jenisPersediaan, jumlahPersediaan, hargaPersediaan, totalHargaPersediaan, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
