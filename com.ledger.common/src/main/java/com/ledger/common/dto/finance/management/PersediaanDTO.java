package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class PersediaanDTO implements Serializable {

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

    public PersediaanDTO() {
    }

    public PersediaanDTO(String userID, String persediaanID, String namaPersediaan, String jenisPersediaan, int jumlahPersediaan, double hargaPersediaan, double totalHargaPersediaan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.persediaanID = persediaanID;
        this.namaPersediaan = namaPersediaan;
        this.jenisPersediaan = jenisPersediaan;
        this.jumlahPersediaan = jumlahPersediaan;
        this.hargaPersediaan = hargaPersediaan;
        this.totalHargaPersediaan = totalHargaPersediaan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPersediaanID() {
        return persediaanID;
    }

    public void setPersediaanID(String persediaanID) {
        this.persediaanID = persediaanID;
    }

    public String getNamaPersediaan() {
        return namaPersediaan;
    }

    public void setNamaPersediaan(String namaPersediaan) {
        this.namaPersediaan = namaPersediaan;
    }

    public int getJumlahPersediaan() {
        return jumlahPersediaan;
    }

    public void setJumlahPersediaan(int jumlahPersediaan) {
        this.jumlahPersediaan = jumlahPersediaan;
    }

    public double getHargaPersediaan() {
        return hargaPersediaan;
    }

    public void setHargaPersediaan(double hargaPersediaan) {
        this.hargaPersediaan = hargaPersediaan;
    }

    public double getTotalHargaPersediaan() {
        return totalHargaPersediaan;
    }

    public void setTotalHargaPersediaan(double totalHargaPersediaan) {
        this.totalHargaPersediaan = totalHargaPersediaan;
    }

    public String getJenisPersediaan() {
        return jenisPersediaan;
    }

    public void setJenisPersediaan(String jenisPersediaan) {
        this.jenisPersediaan = jenisPersediaan;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
