package com.ledger.common.dto.finance.management;

import java.util.Date;


public class PembelianDTOBuilder {
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

    public PembelianDTOBuilder() {
    }

    public PembelianDTOBuilder setPembelianID(String pembelianID) {
        this.pembelianID = pembelianID;
        return this;
    }

    public PembelianDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PembelianDTOBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PembelianDTOBuilder setBuktiPembelian(String buktiPembelian) {
        this.buktiPembelian = buktiPembelian;
        return this;
    }

    public PembelianDTOBuilder setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public PembelianDTOBuilder setSatuan(String satuan) {
        this.satuan = satuan;
        return this;
    }

    public PembelianDTOBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public PembelianDTOBuilder setDiskon(int diskon) {
        this.diskon = diskon;
        return this;
    }

    public PembelianDTOBuilder setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
        return this;
    }

    public PembelianDTOBuilder setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
        return this;
    }

    public PembelianDTOBuilder setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
        return this;
    }

    public PembelianDTOBuilder setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
        return this;
    }

    public PembelianDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PembelianDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PembelianDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PembelianDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PembelianDTO createPembelianDTO() {
        return new PembelianDTO(pembelianID, userID, namaBarang, buktiPembelian, jenisBarang, satuan, jumlah, diskon, hargaBarang, totalHarga, tanggalPembelian, tipePembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
