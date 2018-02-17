/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.financial.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.JenisPembayaran;
import com.ledger.shared.type.Kategori;
import java.util.Date;


public class TransaksiBuilder {

    private long id;
    private String transaksiID;
    private String userIDTransaksi;
    private String namaProduk;
    private Kategori kategoriTransaksi;
    private JenisBarang jenisBarang;
    private int harga;
    private int diskon;
    private int total;
    private Date tanggalTransaksi;
    private String deskripsi;
    private StatusTransaksi statusTransaksi;
    private JenisPembayaran jenisPembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TransaksiBuilder() {
    }

    public TransaksiBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public TransaksiBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public TransaksiBuilder setUserIDTransaksi(String userIDTransaksi) {
        this.userIDTransaksi = userIDTransaksi;
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

    public TransaksiBuilder setJenisBarang(JenisBarang jenisBarang) {
        this.jenisBarang = jenisBarang;
        return this;
    }

    public TransaksiBuilder setHarga(int harga) {
        this.harga = harga;
        return this;
    }

    public TransaksiBuilder setDiskon(int diskon) {
        this.diskon = diskon;
        return this;
    }

    public TransaksiBuilder setTotal(int total) {
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

    public TransaksiBuilder setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
        return this;
    }

    public TransaksiBuilder setJenisPembayaran(JenisPembayaran jenisPembayaran) {
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
        return new Transaksi(id, transaksiID, userIDTransaksi, namaProduk, kategoriTransaksi, jenisBarang, harga, diskon, total, tanggalTransaksi, deskripsi, statusTransaksi, jenisPembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
