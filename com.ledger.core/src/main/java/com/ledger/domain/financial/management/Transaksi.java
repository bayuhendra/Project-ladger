package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import com.ledger.shared.type.Kategori;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Transaksi implements EntityObject<Transaksi> {

    long id;
    private String transaksiID;
    private String userID;
    private String namaProduk;
    private Kategori kategoriTransaksi;
    private String jenisBarang;
    private double harga;
    private double diskon;
    private double total;
    private Date tanggalTransaksi;
    private String deskripsi;
    private String statusTransaksi;
    private String jenisPembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Transaksi() {
    }

    public Transaksi(String transaksiID, String userID, String namaProduk, Kategori kategoriTransaksi, String jenisBarang, double harga, double diskon, double total, Date tanggalTransaksi, String deskripsi, String statusTransaksi, String jenisPembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.transaksiID = transaksiID;
        this.userID = userID;
        this.namaProduk = namaProduk;
        this.kategoriTransaksi = kategoriTransaksi;
        this.jenisBarang = jenisBarang;
        this.harga = harga;
        this.diskon = diskon;
        this.total = total;
        this.tanggalTransaksi = tanggalTransaksi;
        this.deskripsi = deskripsi;
        this.statusTransaksi = statusTransaksi;
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

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Kategori getKategoriTransaksi() {
        return kategoriTransaksi;
    }

    public void setKategoriTransaksi(Kategori kategoriTransaksi) {
        this.kategoriTransaksi = kategoriTransaksi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.transaksiID);
        hash = 89 * hash + Objects.hashCode(this.userID);
        hash = 89 * hash + Objects.hashCode(this.namaProduk);
        hash = 89 * hash + Objects.hashCode(this.kategoriTransaksi);
        hash = 89 * hash + Objects.hashCode(this.jenisBarang);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.harga) ^ (Double.doubleToLongBits(this.harga) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.diskon) ^ (Double.doubleToLongBits(this.diskon) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.tanggalTransaksi);
        hash = 89 * hash + Objects.hashCode(this.deskripsi);
        hash = 89 * hash + Objects.hashCode(this.statusTransaksi);
        hash = 89 * hash + Objects.hashCode(this.jenisPembayaran);
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
        final Transaksi other = (Transaksi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataTransaksi(Transaksi transaksi) {
        this.transaksiID = transaksi.transaksiID;
        this.userID = transaksi.userID;
        this.namaProduk = transaksi.namaProduk;
        this.kategoriTransaksi = transaksi.kategoriTransaksi;
        this.jenisBarang = transaksi.jenisBarang;
        this.harga = transaksi.harga;
        this.diskon = transaksi.diskon;
        this.total = transaksi.total;
        this.tanggalTransaksi = transaksi.tanggalTransaksi;
        this.deskripsi = transaksi.deskripsi;
        this.statusTransaksi = transaksi.statusTransaksi;
        this.jenisPembayaran = transaksi.jenisPembayaran;
        this.createdBy = transaksi.createdBy;
        this.createdDate = transaksi.createdDate;
        this.modifiedBy = transaksi.modifiedBy;
        this.modifiedDate = transaksi.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Transaksi other) {
        return this.equals(other);
    }

}
