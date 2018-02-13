/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.financial.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.Kategori;
import java.util.Date;


public class PenjualanBuilder {

    private long id;
    private String penjualanID;
    private String namaBarang;
    private Kategori kategoriPenjualan;
    private JenisBarang jenisPenjualan;
    private int jumlah;
    private int diskon;
    private int total;
    private Date tanggalTransaksiPenjualan;
    private String catatan;
    private StatusTransaksi statusTransaksi;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PenjualanBuilder() {
    }

    public PenjualanBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public PenjualanBuilder setPenjualanID(String penjualanID) {
        this.penjualanID = penjualanID;
        return this;
    }

    public PenjualanBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PenjualanBuilder setKategoriPenjualan(Kategori kategoriPenjualan) {
        this.kategoriPenjualan = kategoriPenjualan;
        return this;
    }

    public PenjualanBuilder setJenisPenjualan(JenisBarang jenisPenjualan) {
        this.jenisPenjualan = jenisPenjualan;
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

    public PenjualanBuilder setTotal(int total) {
        this.total = total;
        return this;
    }

    public PenjualanBuilder setTanggalTransaksiPenjualan(Date tanggalTransaksiPenjualan) {
        this.tanggalTransaksiPenjualan = tanggalTransaksiPenjualan;
        return this;
    }

    public PenjualanBuilder setCatatan(String catatan) {
        this.catatan = catatan;
        return this;
    }

    public PenjualanBuilder setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
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
        return new Penjualan(id, penjualanID, namaBarang, kategoriPenjualan, jenisPenjualan, jumlah, diskon, total, tanggalTransaksiPenjualan, catatan, statusTransaksi, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
