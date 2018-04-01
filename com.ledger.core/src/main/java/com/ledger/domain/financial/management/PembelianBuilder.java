package com.ledger.domain.financial.management;

import java.util.Date;

public class PembelianBuilder {

    private String pembelianID;
    private String userID;
    private String namaBarang;
    private String buktiPembelian;
    private String jenisBarang;
    private String satuan;
    private int jumlah;
    private int diskon;
    private double hargaBarang;
    private double totalHarga;
    private Date tanggalPembelian;
    private String tipePembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PembelianBuilder() {
    }

    public PembelianBuilder setPembelianID(String pembelianID) {
        this.pembelianID = pembelianID;
        return this;
    }

    public PembelianBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PembelianBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PembelianBuilder setBuktiPembelian(String buktiPembelian) {
        this.buktiPembelian = buktiPembelian;
        return this;
    }

    public PembelianBuilder setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public PembelianBuilder setSatuan(String satuan) {
        this.satuan = satuan;
        return this;
    }

    public PembelianBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public PembelianBuilder setDiskon(int diskon) {
        this.diskon = diskon;
        return this;
    }

    public PembelianBuilder setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
        return this;
    }

    public PembelianBuilder setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
        return this;
    }

    public PembelianBuilder setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
        return this;
    }

    public PembelianBuilder setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
        return this;
    }

    public PembelianBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PembelianBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PembelianBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PembelianBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Pembelian createPembelian() {
        return new Pembelian(pembelianID, userID, namaBarang, buktiPembelian, jenisBarang, satuan, jumlah, diskon, hargaBarang, totalHarga, tanggalPembelian, tipePembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
