package com.ledger.common.dto.finance.management;

import java.util.Date;

public class ReturDTOBuilder {

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

    public ReturDTOBuilder() {
    }

    public ReturDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public ReturDTOBuilder setReturID(String returID) {
        this.returID = returID;
        return this;
    }

    public ReturDTOBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public ReturDTOBuilder setJenisRetur(String jenisRetur) {
        this.jenisRetur = jenisRetur;
        return this;
    }

    public ReturDTOBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public ReturDTOBuilder setSatuan(String satuan) {
        this.satuan = satuan;
        return this;
    }

    public ReturDTOBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public ReturDTOBuilder setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
        return this;
    }

    public ReturDTOBuilder setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
        return this;
    }

    public ReturDTOBuilder setTanggalRetur(Date tanggalRetur) {
        this.tanggalRetur = tanggalRetur;
        return this;
    }

    public ReturDTOBuilder setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
        return this;
    }

    public ReturDTOBuilder setBuktiPembelian(String buktiPembelian) {
        this.buktiPembelian = buktiPembelian;
        return this;
    }

    public ReturDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ReturDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ReturDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ReturDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ReturDTO createReturDTO() {
        return new ReturDTO(userID, returID, transaksiID, jenisRetur, namaBarang, satuan, jumlah, hargaBarang, totalHarga, tanggalRetur, tipePembayaran, buktiPembelian, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
