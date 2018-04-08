package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Retur implements EntityObject<Retur> {

    long id;
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

    public Retur() {
    }

    public Retur(String userID, String returID, String transaksiID, String jenisRetur, String namaBarang, String satuan, int jumlah, double hargaBarang, double totalHarga, Date tanggalRetur, String tipePembayaran, String buktiPembelian, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.userID);
        hash = 59 * hash + Objects.hashCode(this.returID);
        hash = 59 * hash + Objects.hashCode(this.transaksiID);
        hash = 59 * hash + Objects.hashCode(this.jenisRetur);
        hash = 59 * hash + Objects.hashCode(this.namaBarang);
        hash = 59 * hash + Objects.hashCode(this.satuan);
        hash = 59 * hash + this.jumlah;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.hargaBarang) ^ (Double.doubleToLongBits(this.hargaBarang) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.totalHarga) ^ (Double.doubleToLongBits(this.totalHarga) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.tanggalRetur);
        hash = 59 * hash + Objects.hashCode(this.tipePembayaran);
        hash = 59 * hash + Objects.hashCode(this.buktiPembelian);
        hash = 59 * hash + Objects.hashCode(this.createdBy);
        hash = 59 * hash + Objects.hashCode(this.createdDate);
        hash = 59 * hash + Objects.hashCode(this.modifiedBy);
        hash = 59 * hash + Objects.hashCode(this.modifiedDate);
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
        final Retur other = (Retur) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataRetur(Retur retur) {
        this.userID = retur.userID;
        this.returID = retur.returID;
        this.transaksiID = retur.transaksiID;
        this.jenisRetur = retur.jenisRetur;
        this.namaBarang = retur.namaBarang;
        this.satuan = retur.satuan;
        this.jumlah = retur.jumlah;
        this.hargaBarang = retur.hargaBarang;
        this.totalHarga = retur.totalHarga;
        this.tanggalRetur = retur.tanggalRetur;
        this.tipePembayaran = retur.tipePembayaran;
        this.buktiPembelian = retur.buktiPembelian;
        this.modifiedBy = retur.modifiedBy;
        this.modifiedDate = retur.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Retur other) {
        return this.equals(other);
    }

}
