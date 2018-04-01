package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class TransaksiDTO implements Serializable {

    private String transaksiID;
    private String userID;
    private String jenisTransaksi;
    private String namaTransaksi;
    private double nilaiTransaksi;
    private double cash;
    private double kredit;
    private Date tanggalTransaksi;
    private String jenisPembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TransaksiDTO() {
    }

    public TransaksiDTO(String transaksiID, String userID, String jenisTransaksi, String namaTransaksi, double nilaiTransaksi, double cash, double kredit, Date tanggalTransaksi, String jenisPembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.transaksiID = transaksiID;
        this.userID = userID;
        this.jenisTransaksi = jenisTransaksi;
        this.namaTransaksi = namaTransaksi;
        this.nilaiTransaksi = nilaiTransaksi;
        this.cash = cash;
        this.kredit = kredit;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jenisPembayaran = jenisPembayaran;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getTransaksiID() {
        return transaksiID;
    }

    public void setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public String getNamaTransaksi() {
        return namaTransaksi;
    }

    public void setNamaTransaksi(String namaTransaksi) {
        this.namaTransaksi = namaTransaksi;
    }

    public double getNilaiTransaksi() {
        return nilaiTransaksi;
    }

    public void setNilaiTransaksi(double nilaiTransaksi) {
        this.nilaiTransaksi = nilaiTransaksi;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
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
        return "TransaksiDTO{" + "transaksiID=" + transaksiID + ", userID=" + userID + ", jenisTransaksi=" + jenisTransaksi + ", namaTransaksi=" + namaTransaksi + ", nilaiTransaksi=" + nilaiTransaksi + ", cash=" + cash + ", kredit=" + kredit + ", tanggalTransaksi=" + tanggalTransaksi + ", jenisPembayaran=" + jenisPembayaran + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
