/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.JenisPembayaran;
import com.ledger.shared.type.Kategori;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Transaksi implements EntityObject<Transaksi> {

    long id;
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

    public Transaksi() {
    }

    public Transaksi(long id, String transaksiID, String userIDTransaksi, String namaProduk, Kategori kategoriTransaksi, JenisBarang jenisBarang, int harga, int diskon, int total, Date tanggalTransaksi, String deskripsi, StatusTransaksi statusTransaksi, JenisPembayaran jenisPembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransaksiID() {
        return transaksiID;
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
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

    public String getUserIDTransaksi() {
        return userIDTransaksi;
    }

    public void setUserIDTransaksi(String userIDTransaksi) {
        this.userIDTransaksi = userIDTransaksi;
    }

    public void assignNewDataTransaksi(Transaksi transaksi) {
        this.transaksiID = transaksi.transaksiID;
        this.userIDTransaksi = transaksi.userIDTransaksi;
        this.namaProduk = transaksi.namaProduk;
        this.kategoriTransaksi = transaksi.kategoriTransaksi;
        this.jenisBarang = transaksi.jenisBarang;
        this.harga = transaksi.harga;
        this.diskon = transaksi.diskon;
        this.total = total;
        this.tanggalTransaksi = transaksi.tanggalTransaksi;
        this.deskripsi = transaksi.deskripsi;
        this.statusTransaksi = transaksi.statusTransaksi;
        this.jenisPembayaran = transaksi.jenisPembayaran;
        this.createdBy = transaksi.createdBy;
        this.createdDate = transaksi.createdDate;
        this.modifiedBy = transaksi.modifiedBy;
        this.modifiedDate = transaksi.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Transaksi other) {
        return this.equals(other);
    }

}
