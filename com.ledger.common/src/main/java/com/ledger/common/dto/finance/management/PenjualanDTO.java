package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class PenjualanDTO implements Serializable {

    private String userID;
    private String penjualanID;
    private String namaBarang;
    private String jenisBarang;
    private String satuan;
    private int jumlah;
    private int diskon;
    private double hargaBarang;
    private double totalHarga;
    private double hargaPokokPenjualan;
    private double pendapatanUsaha;
    private Date tanggalPenjualan;
    private String buktiPenjualan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PenjualanDTO() {
    }

    public PenjualanDTO(String penjualanID, String userID, String namaBarang, String jenisBarang, String satuan, int jumlah, int diskon, double hargaBarang, double totalHarga, double hargaPokokPenjualan, double pendapatanUsaha, Date tanggalPenjualan, String buktiPenjualan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.penjualanID = penjualanID;
        this.userID = userID;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.satuan = satuan;
        this.jumlah = jumlah;
        this.diskon = diskon;
        this.hargaBarang = hargaBarang;
        this.totalHarga = totalHarga;
        this.hargaPokokPenjualan = hargaPokokPenjualan;
        this.pendapatanUsaha = pendapatanUsaha;
        this.tanggalPenjualan = tanggalPenjualan;
        this.buktiPenjualan = buktiPenjualan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPenjualanID() {
        return penjualanID;
    }

    public void setPenjualanID(String penjualanID) {
        this.penjualanID = penjualanID;
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

    public double getHargaPokokPenjualan() {
        return hargaPokokPenjualan;
    }

    public void setHargaPokokPenjualan(double hargaPokokPenjualan) {
        this.hargaPokokPenjualan = hargaPokokPenjualan;
    }

    public double getPendapatanUsaha() {
        return pendapatanUsaha;
    }

    public void setPendapatanUsaha(double pendapatanUsaha) {
        this.pendapatanUsaha = pendapatanUsaha;
    }

    public Date getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(Date tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public String getBuktiPenjualan() {
        return buktiPenjualan;
    }

    public void setBuktiPenjualan(String buktiPenjualan) {
        this.buktiPenjualan = buktiPenjualan;
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
        return "PenjualanDTO{" + "userID=" + userID + ", penjualanID=" + penjualanID + ", namaBarang=" + namaBarang + ", jenisBarang=" + jenisBarang + ", satuan=" + satuan + ", jumlah=" + jumlah + ", diskon=" + diskon + ", hargaBarang=" + hargaBarang + ", totalHarga=" + totalHarga + ", hargaPokokPenjualan=" + hargaPokokPenjualan + ", pendapatanUsaha=" + pendapatanUsaha + ", tanggalPenjualan=" + tanggalPenjualan + ", buktiPenjualan=" + buktiPenjualan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
