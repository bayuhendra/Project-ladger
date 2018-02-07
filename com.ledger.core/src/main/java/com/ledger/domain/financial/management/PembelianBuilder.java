/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.financial.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.Jenis;
import com.ledger.shared.type.Kategori;
import java.util.Date;


public class PembelianBuilder {

    private long id;
    private String pembelianID;
    private String namaBarang;
    private Kategori kategoriPembelian;
    private Jenis jenisPembelian;
    private int jumlah;
    private int diskon;
    private int total;
    private Date tanggalTransaksiPembelian;
    private String catatan;
    private StatusTransaksi statusPembelian;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PembelianBuilder() {
    }

    public PembelianBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public PembelianBuilder setPembelianID(String pembelianID) {
        this.pembelianID = pembelianID;
        return this;
    }

    public PembelianBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PembelianBuilder setKategoriPembelian(Kategori kategoriPembelian) {
        this.kategoriPembelian = kategoriPembelian;
        return this;
    }

    public PembelianBuilder setJenisPembelian(Jenis jenisPembelian) {
        this.jenisPembelian = jenisPembelian;
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

    public PembelianBuilder setTotal(int total) {
        this.total = total;
        return this;
    }

    public PembelianBuilder setTanggalTransaksiPembelian(Date tanggalTransaksiPembelian) {
        this.tanggalTransaksiPembelian = tanggalTransaksiPembelian;
        return this;
    }

    public PembelianBuilder setCatatan(String catatan) {
        this.catatan = catatan;
        return this;
    }

    public PembelianBuilder setStatusPembelian(StatusTransaksi statusPembelian) {
        this.statusPembelian = statusPembelian;
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
        return new Pembelian(id, pembelianID, namaBarang, kategoriPembelian, jenisPembelian, jumlah, diskon, total, tanggalTransaksiPembelian, catatan, statusPembelian, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
