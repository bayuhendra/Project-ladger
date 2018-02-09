/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.dto.finance.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.Jenis;
import com.ledger.shared.type.Kategori;
import java.util.Date;


public class PembelianDTOBuilder {

    private String pembelianID;
    private String namaBarang;
    private Kategori kategoriPembelian;
    private Jenis jenisPembelian;
    private int jumlah;
    private int diskon;
    private int total;
    private Date tanggalTransaksiPembelian;
    private String catatan;
    private StatusTransaksi statusTransaksi;
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

    public PembelianDTOBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PembelianDTOBuilder setKategoriPembelian(Kategori kategoriPembelian) {
        this.kategoriPembelian = kategoriPembelian;
        return this;
    }

    public PembelianDTOBuilder setJenisPembelian(Jenis jenisPembelian) {
        this.jenisPembelian = jenisPembelian;
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

    public PembelianDTOBuilder setTotal(int total) {
        this.total = total;
        return this;
    }

    public PembelianDTOBuilder setTanggalTransaksiPembelian(Date tanggalTransaksiPembelian) {
        this.tanggalTransaksiPembelian = tanggalTransaksiPembelian;
        return this;
    }

    public PembelianDTOBuilder setCatatan(String catatan) {
        this.catatan = catatan;
        return this;
    }

    public PembelianDTOBuilder setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
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
        return new PembelianDTO(pembelianID, namaBarang, kategoriPembelian, jenisPembelian, jumlah, diskon, total, tanggalTransaksiPembelian, catatan, statusTransaksi, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
