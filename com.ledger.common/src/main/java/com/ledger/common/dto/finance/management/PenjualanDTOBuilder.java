package com.ledger.common.dto.finance.management;

import java.util.Date;

public class PenjualanDTOBuilder {

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

    public PenjualanDTOBuilder() {
    }

    public PenjualanDTOBuilder setPenjualanID(String penjualanID) {
        this.penjualanID = penjualanID;
        return this;
    }

    public PenjualanDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PenjualanDTOBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PenjualanDTOBuilder setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public PenjualanDTOBuilder setSatuan(String satuan) {
        this.satuan = satuan;
        return this;
    }

    public PenjualanDTOBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public PenjualanDTOBuilder setDiskon(int diskon) {
        this.diskon = diskon;
        return this;
    }

    public PenjualanDTOBuilder setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
        return this;
    }

    public PenjualanDTOBuilder setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
        return this;
    }

    public PenjualanDTOBuilder setHargaPokokPenjualan(double hargaPokokPenjualan) {
        this.hargaPokokPenjualan = hargaPokokPenjualan;
        return this;
    }

    public PenjualanDTOBuilder setPendapatanUsaha(double pendapatanUsaha) {
        this.pendapatanUsaha = pendapatanUsaha;
        return this;
    }

    public PenjualanDTOBuilder setTanggalPenjualan(Date tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
        return this;
    }

    public PenjualanDTOBuilder setBuktiPenjualan(String buktiPenjualan) {
        this.buktiPenjualan = buktiPenjualan;
        return this;
    }

    public PenjualanDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PenjualanDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PenjualanDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PenjualanDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PenjualanDTO createPenjualanDTO() {
        return new PenjualanDTO(penjualanID, userID, namaBarang, jenisBarang, satuan, jumlah, diskon, hargaBarang, totalHarga, hargaPokokPenjualan, pendapatanUsaha, tanggalPenjualan, buktiPenjualan, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
