package com.ledger.domain.financial.management;

import java.util.Date;


public class PersediaanBuilder {
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

    public PersediaanBuilder() {
    }

    public PersediaanBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PersediaanBuilder setPersediaanID(String persediaanID) {
        this.persediaanID = persediaanID;
        return this;
    }

    public PersediaanBuilder setNamaPersediaan(String namaPersediaan) {
        this.namaPersediaan = namaPersediaan;
        return this;
    }

    public PersediaanBuilder setJenisPersediaan(String jenisPersediaan) {
        this.jenisPersediaan = jenisPersediaan;
        return this;
    }

    public PersediaanBuilder setJumlahPersediaan(int jumlahPersediaan) {
        this.jumlahPersediaan = jumlahPersediaan;
        return this;
    }

    public PersediaanBuilder setHargaPersediaan(double hargaPersediaan) {
        this.hargaPersediaan = hargaPersediaan;
        return this;
    }

    public PersediaanBuilder setTotalHargaPersediaan(double totalHargaPersediaan) {
        this.totalHargaPersediaan = totalHargaPersediaan;
        return this;
    }

    public PersediaanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PersediaanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PersediaanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PersediaanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Persediaan createPersediaan() {
        return new Persediaan(userID, persediaanID, namaPersediaan, jenisPersediaan, jumlahPersediaan, hargaPersediaan, totalHargaPersediaan, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
