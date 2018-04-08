package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Penjualan implements EntityObject<Penjualan> {

    long id;
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

    public Penjualan() {
    }

    public Penjualan(String penjualanID, String userID, String namaBarang, String jenisBarang, String satuan, int jumlah, int diskon, double hargaBarang, double totalHarga, double hargaPokokPenjualan, double pendapatanUsaha, Date tanggalPenjualan, String buktiPenjualan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.penjualanID);
        hash = 17 * hash + Objects.hashCode(this.userID);
        hash = 17 * hash + Objects.hashCode(this.namaBarang);
        hash = 17 * hash + Objects.hashCode(this.jenisBarang);
        hash = 17 * hash + Objects.hashCode(this.satuan);
        hash = 17 * hash + this.jumlah;
        hash = 17 * hash + this.diskon;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.hargaBarang) ^ (Double.doubleToLongBits(this.hargaBarang) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.totalHarga) ^ (Double.doubleToLongBits(this.totalHarga) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.hargaPokokPenjualan) ^ (Double.doubleToLongBits(this.hargaPokokPenjualan) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.pendapatanUsaha) ^ (Double.doubleToLongBits(this.pendapatanUsaha) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.tanggalPenjualan);
        hash = 17 * hash + Objects.hashCode(this.buktiPenjualan);
        hash = 17 * hash + Objects.hashCode(this.createdBy);
        hash = 17 * hash + Objects.hashCode(this.createdDate);
        hash = 17 * hash + Objects.hashCode(this.modifiedBy);
        hash = 17 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Penjualan other = (Penjualan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataPenjualan(Penjualan penjualan) {
        this.penjualanID = penjualan.penjualanID;
        this.userID = penjualan.userID;
        this.namaBarang = penjualan.namaBarang;
        this.jenisBarang = penjualan.jenisBarang;
        this.satuan = penjualan.satuan;
        this.jumlah = penjualan.jumlah;
        this.diskon = penjualan.diskon;
        this.hargaBarang = penjualan.hargaBarang;
        this.totalHarga = penjualan.totalHarga;
        this.hargaPokokPenjualan = penjualan.hargaPokokPenjualan;
        this.pendapatanUsaha = penjualan.pendapatanUsaha;
        this.tanggalPenjualan = penjualan.tanggalPenjualan;
        this.buktiPenjualan = penjualan.buktiPenjualan;
        this.createdBy = penjualan.createdBy;
        this.createdDate = penjualan.createdDate;
        this.modifiedBy = penjualan.modifiedBy;
        this.modifiedDate = penjualan.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Penjualan other) {
        return this.equals(other);
    }

}
