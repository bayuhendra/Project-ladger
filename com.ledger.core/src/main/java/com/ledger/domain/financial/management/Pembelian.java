package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Pembelian implements EntityObject<Pembelian> {

    long id;
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

    public Pembelian() {
    }

    public Pembelian(String pembelianID, String userID, String namaBarang, String buktiPembelian, String jenisBarang, String satuan, int jumlah, int diskon, double hargaBarang, double totalHarga, Date tanggalPembelian, String tipePembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.pembelianID);
        hash = 89 * hash + Objects.hashCode(this.userID);
        hash = 89 * hash + Objects.hashCode(this.namaBarang);
        hash = 89 * hash + Objects.hashCode(this.jenisBarang);
        hash = 89 * hash + Objects.hashCode(this.satuan);
        hash = 89 * hash + this.jumlah;
        hash = 89 * hash + this.diskon;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.hargaBarang) ^ (Double.doubleToLongBits(this.hargaBarang) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.totalHarga) ^ (Double.doubleToLongBits(this.totalHarga) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.tanggalPembelian);
        hash = 89 * hash + Objects.hashCode(this.tipePembayaran);
        hash = 89 * hash + Objects.hashCode(this.buktiPembelian);
        hash = 89 * hash + Objects.hashCode(this.createdBy);
        hash = 89 * hash + Objects.hashCode(this.createdDate);
        hash = 89 * hash + Objects.hashCode(this.modifiedBy);
        hash = 89 * hash + Objects.hashCode(this.modifiedDate);
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
        final Pembelian other = (Pembelian) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataPembelian(Pembelian pembelian) {
        this.pembelianID = pembelian.pembelianID;
        this.userID = pembelian.userID;
        this.namaBarang = pembelian.namaBarang;
        this.jenisBarang = pembelian.jenisBarang;
        this.satuan = pembelian.satuan;
        this.jumlah = pembelian.jumlah;
        this.diskon = pembelian.diskon;
        this.hargaBarang = pembelian.hargaBarang;
        this.totalHarga = pembelian.totalHarga;
        this.tanggalPembelian = pembelian.tanggalPembelian;
        this.tipePembayaran = pembelian.tipePembayaran;
        this.buktiPembelian = pembelian.buktiPembelian;
        this.createdBy = pembelian.createdBy;
        this.createdDate = pembelian.createdDate;
        this.modifiedBy = pembelian.modifiedBy;
        this.modifiedDate = pembelian.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Pembelian other) {
        return this.equals(other);
    }

}
