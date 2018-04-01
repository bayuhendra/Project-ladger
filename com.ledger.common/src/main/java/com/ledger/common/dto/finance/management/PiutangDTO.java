package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class PiutangDTO implements Serializable {

    private String userID;
    private String piutangID;
    private String jenisPiutang;
    private String namaPiutang;
    private double jumlahPiutang;
    private Date tanggalJatuhTempo;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PiutangDTO() {
    }

    public PiutangDTO(String userID, String piutangID, String jenisPiutang, String namaPiutang, double jumlahPiutang, Date tanggalJatuhTempo, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.piutangID = piutangID;
        this.jenisPiutang = jenisPiutang;
        this.namaPiutang = namaPiutang;
        this.jumlahPiutang = jumlahPiutang;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPiutangID() {
        return piutangID;
    }

    public void setPiutangID(String piutangID) {
        this.piutangID = piutangID;
    }

    public String getNamaPiutang() {
        return namaPiutang;
    }

    public void setNamaPiutang(String namaPiutang) {
        this.namaPiutang = namaPiutang;
    }

    public double getJumlahPiutang() {
        return jumlahPiutang;
    }

    public void setJumlahPiutang(double jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
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

    public String getJenisPiutang() {
        return jenisPiutang;
    }

    public void setJenisPiutang(String jenisPiutang) {
        this.jenisPiutang = jenisPiutang;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

}
