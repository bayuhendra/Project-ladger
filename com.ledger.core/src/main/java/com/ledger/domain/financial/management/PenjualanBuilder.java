package com.ledger.domain.financial.management;

import java.util.Date;

public class PenjualanBuilder {

    private String penjualanID;
    private String userID;
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

    public PenjualanBuilder() {
    }

    public PenjualanBuilder setPenjualanID(String penjualanID) {
        this.penjualanID = penjualanID;
        return this;
    }

    public PenjualanBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PenjualanBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PenjualanBuilder setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public PenjualanBuilder setSatuan(String satuan) {
        this.satuan = satuan;
        return this;
    }

    public PenjualanBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public PenjualanBuilder setDiskon(int diskon) {
        this.diskon = diskon;
        return this;
    }

    public PenjualanBuilder setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
        return this;
    }

    public PenjualanBuilder setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
        return this;
    }

    public PenjualanBuilder setHargaPokokPenjualan(double hargaPokokPenjualan) {
        this.hargaPokokPenjualan = hargaPokokPenjualan;
        return this;
    }

    public PenjualanBuilder setPendapatanUsaha(double pendapatanUsaha) {
        this.pendapatanUsaha = pendapatanUsaha;
        return this;
    }

    public PenjualanBuilder setTanggalPenjualan(Date tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
        return this;
    }

    public PenjualanBuilder setBuktiPenjualan(String buktiPenjualan) {
        this.buktiPenjualan = buktiPenjualan;
        return this;
    }

    public PenjualanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PenjualanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PenjualanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PenjualanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Penjualan createPenjualan() {
        return new Penjualan(penjualanID, userID, namaBarang, jenisBarang, satuan, jumlah, diskon, hargaBarang, totalHarga, hargaPokokPenjualan, pendapatanUsaha, tanggalPenjualan, buktiPenjualan, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
