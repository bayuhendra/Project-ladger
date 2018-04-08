package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class ReturDTO implements Serializable {

    private String userID;
    private String returID;
    private String transaksiID;
    private String jenisRetur;
    private String namaBarang;
    private String satuan;
    private int jumlah;
    private double hargaBarang;
    private double totalHarga;
    private Date tanggalRetur;
    private String tipePembayaran;
    private String buktiPembelian;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public ReturDTO() {
    }

    public ReturDTO(String userID, String returID, String transaksiID, String jenisRetur, String namaBarang, String satuan, int jumlah, double hargaBarang, double totalHarga, Date tanggalRetur, String tipePembayaran, String buktiPembelian, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.returID = returID;
        this.transaksiID = transaksiID;
        this.jenisRetur = jenisRetur;
        this.namaBarang = namaBarang;
        this.satuan = satuan;
        this.jumlah = jumlah;
        this.hargaBarang = hargaBarang;
        this.totalHarga = totalHarga;
        this.tanggalRetur = tanggalRetur;
        this.tipePembayaran = tipePembayaran;
        this.buktiPembelian = buktiPembelian;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReturID() {
        return returID;
    }

    public void setReturID(String returID) {
        this.returID = returID;
    }

    public String getTransaksiID() {
        return transaksiID;
    }

    public void setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
    }

    public String getJenisRetur() {
        return jenisRetur;
    }

    public void setJenisRetur(String jenisRetur) {
        this.jenisRetur = jenisRetur;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Date getTanggalRetur() {
        return tanggalRetur;
    }

    public void setTanggalRetur(Date tanggalRetur) {
        this.tanggalRetur = tanggalRetur;
    }

    public String getTipePembayaran() {
        return tipePembayaran;
    }

    public void setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
    }

    public String getBuktiPembelian() {
        return buktiPembelian;
    }

    public void setBuktiPembelian(String buktiPembelian) {
        this.buktiPembelian = buktiPembelian;
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

}
