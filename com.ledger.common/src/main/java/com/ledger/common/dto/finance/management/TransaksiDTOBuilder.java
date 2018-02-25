package com.ledger.common.dto.finance.management;

import com.ledger.shared.type.Kategori;
import java.util.Date;


public class TransaksiDTOBuilder {
    private String transaksiID;
    private String userIDTransaksi;
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

    public TransaksiDTOBuilder() {
    }

    public TransaksiDTOBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public TransaksiDTOBuilder setUserIDTransaksi(String userIDTransaksi) {
        this.userIDTransaksi = userIDTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
        return this;
    }

    public TransaksiDTOBuilder setKategoriTransaksi(Kategori kategoriTransaksi) {
        this.kategoriTransaksi = kategoriTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public TransaksiDTOBuilder setHarga(double harga) {
        this.harga = harga;
        return this;
    }

    public TransaksiDTOBuilder setDiskon(double diskon) {
        this.diskon = diskon;
        return this;
    }

    public TransaksiDTOBuilder setTotal(double total) {
        this.total = total;
        return this;
    }

    public TransaksiDTOBuilder setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    public TransaksiDTOBuilder setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
        return this;
    }

    public TransaksiDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TransaksiDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TransaksiDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TransaksiDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public TransaksiDTO createTransaksiDTO() {
        return new TransaksiDTO(transaksiID, userIDTransaksi, namaProduk, kategoriTransaksi, jenisBarang, harga, diskon, total, tanggalTransaksi, deskripsi, statusTransaksi, jenisPembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
