package com.ledger.domain.financial.management;

import com.ledger.shared.type.Kategori;
import java.util.Date;

public class TransaksiBuilder {

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

    public TransaksiBuilder() {
    }

    public TransaksiBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public TransaksiBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public TransaksiBuilder setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
        return this;
    }

    public TransaksiBuilder setKategoriTransaksi(Kategori kategoriTransaksi) {
        this.kategoriTransaksi = kategoriTransaksi;
        return this;
    }

    public TransaksiBuilder setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public TransaksiBuilder setHarga(double harga) {
        this.harga = harga;
        return this;
    }

    public TransaksiBuilder setDiskon(double diskon) {
        this.diskon = diskon;
        return this;
    }

    public TransaksiBuilder setTotal(double total) {
        this.total = total;
        return this;
    }

    public TransaksiBuilder setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
        return this;
    }

    public TransaksiBuilder setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    public TransaksiBuilder setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
        return this;
    }

    public TransaksiBuilder setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
        return this;
    }

    public TransaksiBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TransaksiBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TransaksiBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TransaksiBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Transaksi createTransaksi() {
        return new Transaksi(transaksiID, userID, namaProduk, kategoriTransaksi, jenisBarang, harga, diskon, total, tanggalTransaksi, deskripsi, statusTransaksi, jenisPembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
