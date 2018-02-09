/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.Jenis;
import com.ledger.shared.type.Kategori;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Pembelian implements EntityObject<Pembelian> {

    long id;
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

    public Pembelian() {
    }

    public Pembelian(long id, String pembelianID, String namaBarang, Kategori kategoriPembelian, Jenis jenisPembelian, int jumlah, int diskon, int total, Date tanggalTransaksiPembelian, String catatan, StatusTransaksi statusTransaksi, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public StatusTransaksi getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.pembelianID);
        hash = 43 * hash + Objects.hashCode(this.namaBarang);
        hash = 43 * hash + Objects.hashCode(this.kategoriPembelian);
        hash = 43 * hash + Objects.hashCode(this.jenisPembelian);
        hash = 43 * hash + this.jumlah;
        hash = 43 * hash + this.diskon;
        hash = 43 * hash + this.total;
        hash = 43 * hash + Objects.hashCode(this.tanggalTransaksiPembelian);
        hash = 43 * hash + Objects.hashCode(this.catatan);
        hash = 43 * hash + Objects.hashCode(this.statusTransaksi);
        hash = 43 * hash + Objects.hashCode(this.createdBy);
        hash = 43 * hash + Objects.hashCode(this.createdDate);
        hash = 43 * hash + Objects.hashCode(this.modifiedBy);
        hash = 43 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pembelian other = (Pembelian) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataPembelian(Pembelian pembelian) {
        this.pembelianID = pembelian.pembelianID;
        this.namaBarang = pembelian.namaBarang;
        this.kategoriPembelian = pembelian.kategoriPembelian;
        this.jenisPembelian = pembelian.jenisPembelian;
        this.jumlah = pembelian.jumlah;
        this.diskon = pembelian.diskon;
        this.total = pembelian.total;
        this.tanggalTransaksiPembelian = pembelian.tanggalTransaksiPembelian;
        this.catatan = pembelian.catatan;
        this.statusTransaksi = pembelian.statusTransaksi;
        this.createdBy = pembelian.createdBy;
        this.createdDate = pembelian.createdDate;
        this.modifiedBy = pembelian.modifiedBy;
        this.modifiedDate = pembelian.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Pembelian other) {
        return this.equals(other);
    }

}
