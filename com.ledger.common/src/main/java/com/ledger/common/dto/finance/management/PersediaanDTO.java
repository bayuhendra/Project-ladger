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
    private String tipePersediaan;
    private String namaPersediaan;
    private String jenisPersediaan;
    private String satuan;
    private int jumlahPersediaan;
    private double hargaPersediaan;
    private double totalHargaPersediaan;
    private double hargaRataRata;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PersediaanDTO() {
    }

    public PersediaanDTO(String userID, String persediaanID, String tipePersediaan, String namaPersediaan, String jenisPersediaan, String satuan, int jumlahPersediaan, double hargaPersediaan, double totalHargaPersediaan, double hargaRataRata, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.persediaanID = persediaanID;
        this.tipePersediaan = tipePersediaan;
        this.namaPersediaan = namaPersediaan;
        this.jenisPersediaan = jenisPersediaan;
        this.satuan = satuan;
        this.jumlahPersediaan = jumlahPersediaan;
        this.hargaPersediaan = hargaPersediaan;
        this.totalHargaPersediaan = totalHargaPersediaan;
        this.hargaRataRata = hargaRataRata;
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

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public double getHargaRataRata() {
        return getTotalHargaPersediaan() / getJumlahPersediaan();
    }

    public void setHargaRataRata(double hargaRataRata) {
        this.hargaRataRata = hargaRataRata;
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

    public String getTipePersediaan() {
        return tipePersediaan;
    }

    public void setTipePersediaan(String tipePersediaan) {
        this.tipePersediaan = tipePersediaan;
    }

    @Override
    public String toString() {
        return "PersediaanDTO{" + "userID=" + userID + ", persediaanID=" + persediaanID + ", tipePersediaan=" + tipePersediaan + ", namaPersediaan=" + namaPersediaan + ", jenisPersediaan=" + jenisPersediaan + ", satuan=" + satuan + ", jumlahPersediaan=" + jumlahPersediaan + ", hargaPersediaan=" + hargaPersediaan + ", totalHargaPersediaan=" + totalHargaPersediaan + ", hargaRataRata=" + hargaRataRata + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
