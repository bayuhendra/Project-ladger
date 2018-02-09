/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.dto.finance.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.Jenis;
import com.ledger.shared.type.Kategori;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class PembelianDTO implements Serializable {

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

    public PembelianDTO() {
    }

    public PembelianDTO(String pembelianID, String namaBarang, Kategori kategoriPembelian, Jenis jenisPembelian, int jumlah, int diskon, int total, Date tanggalTransaksiPembelian, String catatan, StatusTransaksi statusTransaksi, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pembelianID = pembelianID;
        this.namaBarang = namaBarang;
        this.kategoriPembelian = kategoriPembelian;
        this.jenisPembelian = jenisPembelian;
        this.jumlah = jumlah;
        this.diskon = diskon;
        this.total = total;
        this.tanggalTransaksiPembelian = tanggalTransaksiPembelian;
        this.catatan = catatan;
        this.statusTransaksi = statusTransaksi;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPembelianID() {
        return pembelianID;
    }

    public void setPembelianID(String pembelianID) {
        this.pembelianID = pembelianID;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Kategori getKategoriPembelian() {
        return kategoriPembelian;
    }

    public void setKategoriPembelian(Kategori kategoriPembelian) {
        this.kategoriPembelian = kategoriPembelian;
    }

    public Jenis getJenisPembelian() {
        return jenisPembelian;
    }

    public void setJenisPembelian(Jenis jenisPembelian) {
        this.jenisPembelian = jenisPembelian;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getTanggalTransaksiPembelian() {
        return tanggalTransaksiPembelian;
    }

    public void setTanggalTransaksiPembelian(Date tanggalTransaksiPembelian) {
        this.tanggalTransaksiPembelian = tanggalTransaksiPembelian;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public StatusTransaksi getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "PembelianDTO{" + "pembelianID=" + pembelianID + ", namaBarang=" + namaBarang + ", kategoriPembelian=" + kategoriPembelian + ", jenisPembelian=" + jenisPembelian + ", jumlah=" + jumlah + ", diskon=" + diskon + ", total=" + total + ", tanggalTransaksiPembelian=" + tanggalTransaksiPembelian + ", catatan=" + catatan + ", statusTransaksi=" + statusTransaksi + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
