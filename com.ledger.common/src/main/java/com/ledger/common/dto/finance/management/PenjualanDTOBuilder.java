/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.dto.finance.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.Kategori;
import java.util.Date;


public class PenjualanDTOBuilder {

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

    public PenjualanDTOBuilder() {
    }

    public PenjualanDTOBuilder setPenjualanID(String penjualanID) {
        this.penjualanID = penjualanID;
        return this;
    }

    public PenjualanDTOBuilder setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        return this;
    }

    public PenjualanDTOBuilder setKategoriPenjualan(Kategori kategoriPenjualan) {
        this.kategoriPenjualan = kategoriPenjualan;
        return this;
    }

    public PenjualanDTOBuilder setJenisPenjualan(JenisBarang jenisPenjualan) {
        this.jenisPenjualan = jenisPenjualan;
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

    public PenjualanDTOBuilder setTotal(int total) {
        this.total = total;
        return this;
    }

    public PenjualanDTOBuilder setTanggalTransaksiPenjualan(Date tanggalTransaksiPenjualan) {
        this.tanggalTransaksiPenjualan = tanggalTransaksiPenjualan;
        return this;
    }

    public PenjualanDTOBuilder setCatatan(String catatan) {
        this.catatan = catatan;
        return this;
    }

    public PenjualanDTOBuilder setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
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
        return new PenjualanDTO(penjualanID, namaBarang, kategoriPenjualan, jenisPenjualan, jumlah, diskon, total, tanggalTransaksiPenjualan, catatan, statusTransaksi, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
