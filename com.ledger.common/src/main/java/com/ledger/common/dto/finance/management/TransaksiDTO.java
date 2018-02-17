/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.common.dto.finance.management;

import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.JenisPembayaran;
import com.ledger.shared.type.Kategori;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class TransaksiDTO implements Serializable {

    private String transaksiID;
    private String userIDTransaksi;
    private String namaProduk;
    private Kategori kategoriTransaksi;
    private JenisBarang jenisBarang;
    private double harga;
    private double diskon;
    private double total;
    private Date tanggalTransaksi;
    private String deskripsi;
    private StatusTransaksi statusTransaksi;
    private JenisPembayaran jenisPembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TransaksiDTO() {
    }

    public TransaksiDTO(String transaksiID, String userIDTransaksi, String namaProduk, Kategori kategoriTransaksi, JenisBarang jenisBarang, double harga, double diskon, double total, Date tanggalTransaksi, String deskripsi, StatusTransaksi statusTransaksi, JenisPembayaran jenisPembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.transaksiID = transaksiID;
        this.userIDTransaksi = userIDTransaksi;
        this.namaProduk = namaProduk;
        this.kategoriTransaksi = kategoriTransaksi;
        this.jenisBarang = jenisBarang;
        this.harga = harga;
        this.diskon = diskon;
        this.total = total;
        this.tanggalTransaksi = tanggalTransaksi;
        this.deskripsi = deskripsi;
        this.statusTransaksi = statusTransaksi;
        this.jenisPembayaran = jenisPembayaran;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getTransaksiID() {
        return transaksiID;
    }

    public String getUserIDTransaksi() {
        return userIDTransaksi;
    }

    public void setUserIDTransaksi(String userIDTransaksi) {
        this.userIDTransaksi = userIDTransaksi;
    }

    public void setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Kategori getKategoriTransaksi() {
        return kategoriTransaksi;
    }

    public void setKategoriTransaksi(Kategori kategoriTransaksi) {
        this.kategoriTransaksi = kategoriTransaksi;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(JenisBarang jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public StatusTransaksi getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public JenisPembayaran getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(JenisPembayaran jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
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
        return "TransaksiDTO{" + "transaksiID=" + transaksiID + ", namaProduk=" + namaProduk + ", kategoriTransaksi=" + kategoriTransaksi + ", jenisBarang=" + jenisBarang + ", harga=" + harga + ", diskon=" + diskon + ", total=" + total + ", tanggalTransaksi=" + tanggalTransaksi + ", deskripsi=" + deskripsi + ", statusTransaksi=" + statusTransaksi + ", jenisPembayaran=" + jenisPembayaran + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
