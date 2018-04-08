package com.ledger.domain.financial.management;

import java.util.Date;

public class ReturBuilder {

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

    public ReturBuilder() {
    }

    public ReturBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public ReturBuilder setReturID(String returID) {
        this.returID = returID;
        return this;
    }

    public ReturBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public ReturBuilder setJenisRetur(String jenisRetur) {
        this.jenisRetur = jenisRetur;
        return this;
    }

    public ReturBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public ReturBuilder setSatuan(String satuan) {
        this.satuan = satuan;
        return this;
    }

    public ReturBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public ReturBuilder setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
        return this;
    }

    public ReturBuilder setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
        return this;
    }

    public ReturBuilder setTanggalRetur(Date tanggalRetur) {
        this.tanggalRetur = tanggalRetur;
        return this;
    }

    public ReturBuilder setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
        return this;
    }

    public ReturBuilder setBuktiPembelian(String buktiPembelian) {
        this.buktiPembelian = buktiPembelian;
        return this;
    }

    public ReturBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ReturBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ReturBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ReturBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Retur createRetur() {
        return new Retur(userID, returID, transaksiID, jenisRetur, namaBarang, satuan, jumlah, hargaBarang, totalHarga, tanggalRetur, tipePembayaran, buktiPembelian, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
