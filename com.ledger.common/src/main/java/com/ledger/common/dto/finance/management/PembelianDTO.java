package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class PembelianDTO implements Serializable {

    private String userID;
    private String pembelianID;
    private String namaBarang;
    private String jenisBarang;
    private String satuan;
    private int jumlah;
    private int diskon;
    private double hargaBarang;
    private double totalHarga;
    private Date tanggalPembelian;
    private String tipePembayaran;
    private String buktiPembelian;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PembelianDTO() {
    }

    public PembelianDTO(String pembelianID, String userID, String namaBarang, String buktiPembelian, String jenisBarang, String satuan, int jumlah, int diskon, double hargaBarang, double totalHarga, Date tanggalPembelian, String tipePembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pembelianID = pembelianID;
        this.userID = userID;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.satuan = satuan;
        this.jumlah = jumlah;
        this.diskon = diskon;
        this.hargaBarang = hargaBarang;
        this.totalHarga = totalHarga;
        this.tanggalPembelian = tanggalPembelian;
        this.tipePembayaran = tipePembayaran;
        this.buktiPembelian = buktiPembelian;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPembelianID() {
        return pembelianID;
    }

    public void setPembelianID(String pembelianID) {
        this.pembelianID = pembelianID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
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

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
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

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public String getTipePembayaran() {
        return tipePembayaran;
    }

    public void setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
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

    public String getBuktiPembelian() {
        return buktiPembelian;
    }

    public void setBuktiPembelian(String buktiPembelian) {
        this.buktiPembelian = buktiPembelian;
    }

    @Override
    public String toString() {
        return "PembelianDTO{" + "userID=" + userID + ", pembelianID=" + pembelianID + ", namaBarang=" + namaBarang + ", jenisBarang=" + jenisBarang + ", satuan=" + satuan + ", jumlah=" + jumlah + ", diskon=" + diskon + ", hargaBarang=" + hargaBarang + ", totalHarga=" + totalHarga + ", tanggalPembelian=" + tanggalPembelian + ", tipePembayaran=" + tipePembayaran + ", buktiPembelian=" + buktiPembelian + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
