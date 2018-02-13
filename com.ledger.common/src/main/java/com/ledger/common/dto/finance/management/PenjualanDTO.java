/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.dto.finance.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.Kategori;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class PenjualanDTO implements Serializable {

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

    public PenjualanDTO() {
    }

    public PenjualanDTO(String penjualanID, String namaBarang, Kategori kategoriPenjualan, JenisBarang jenisPenjualan, int jumlah, int diskon, int total, Date tanggalTransaksiPenjualan, String catatan, StatusTransaksi statusTransaksi, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.penjualanID = penjualanID;
        this.namaBarang = namaBarang;
        this.kategoriPenjualan = kategoriPenjualan;
        this.jenisPenjualan = jenisPenjualan;
        this.jumlah = jumlah;
        this.diskon = diskon;
        this.total = total;
        this.tanggalTransaksiPenjualan = tanggalTransaksiPenjualan;
        this.catatan = catatan;
        this.statusTransaksi = statusTransaksi;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPenjualanID() {
        return penjualanID;
    }

    public void setPenjualanID(String penjualanID) {
        this.penjualanID = penjualanID;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Kategori getKategoriPenjualan() {
        return kategoriPenjualan;
    }

    public void setKategoriPenjualan(Kategori kategoriPenjualan) {
        this.kategoriPenjualan = kategoriPenjualan;
    }

    public JenisBarang getJenisPenjualan() {
        return jenisPenjualan;
    }

    public void setJenisPenjualan(JenisBarang jenisPenjualan) {
        this.jenisPenjualan = jenisPenjualan;
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

    public Date getTanggalTransaksiPenjualan() {
        return tanggalTransaksiPenjualan;
    }

    public void setTanggalTransaksiPenjualan(Date tanggalTransaksiPenjualan) {
        this.tanggalTransaksiPenjualan = tanggalTransaksiPenjualan;
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
        return "PenjualanDTO{" + "penjualanID=" + penjualanID + ", namaBarang=" + namaBarang + ", kategoriPenjualan=" + kategoriPenjualan + ", jenisPenjualan=" + jenisPenjualan + ", jumlah=" + jumlah + ", diskon=" + diskon + ", total=" + total + ", tanggalTransaksiPenjualan=" + tanggalTransaksiPenjualan + ", catatan=" + catatan + ", statusTransaksi=" + statusTransaksi + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
