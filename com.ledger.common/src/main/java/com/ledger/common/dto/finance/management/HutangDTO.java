package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class HutangDTO implements Serializable {

    private String userID;
    private String hutangID;
    private String jenisHutang;
    private String namaHutang;
    private double jumlahHutang;
    private Date tanggalJatuhTempo;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public HutangDTO() {
    }

    public HutangDTO(String userID, String hutangID, String jenisHutang, String namaHutang, double jumlahHutang, Date tanggalJatuhTempo, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.hutangID = hutangID;
        this.jenisHutang = jenisHutang;
        this.namaHutang = namaHutang;
        this.jumlahHutang = jumlahHutang;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getHutangID() {
        return hutangID;
    }

    public void setHutangID(String hutangID) {
        this.hutangID = hutangID;
    }

    public String getNamaHutang() {
        return namaHutang;
    }

    public void setNamaHutang(String namaHutang) {
        this.namaHutang = namaHutang;
    }

    public double getJumlahHutang() {
        return jumlahHutang;
    }

    public void setJumlahHutang(double jumlahHutang) {
        this.jumlahHutang = jumlahHutang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getJenisHutang() {
        return jenisHutang;
    }

    public void setJenisHutang(String jenisHutang) {
        this.jenisHutang = jenisHutang;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

}
