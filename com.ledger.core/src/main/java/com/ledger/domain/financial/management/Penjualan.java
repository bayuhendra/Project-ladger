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
public class Penjualan implements EntityObject<Penjualan> {

    long id;
    private String penjualanID;
    private String namaBarang;
    private Kategori kategoriPenjualan;
    private Jenis jenisPenjualan;
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

    public Penjualan() {
    }

    public Penjualan(long id, String penjualanID, String namaBarang, Kategori kategoriPenjualan, Jenis jenisPenjualan, int jumlah, int diskon, int total, Date tanggalTransaksiPenjualan, String catatan, StatusTransaksi statusTransaksi, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Jenis getJenisPenjualan() {
        return jenisPenjualan;
    }

    public void setJenisPenjualan(Jenis jenisPenjualan) {
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
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.penjualanID);
        hash = 43 * hash + Objects.hashCode(this.namaBarang);
        hash = 43 * hash + Objects.hashCode(this.kategoriPenjualan);
        hash = 43 * hash + Objects.hashCode(this.jenisPenjualan);
        hash = 43 * hash + this.jumlah;
        hash = 43 * hash + this.diskon;
        hash = 43 * hash + this.total;
        hash = 43 * hash + Objects.hashCode(this.tanggalTransaksiPenjualan);
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
        final Penjualan other = (Penjualan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataPenjualan(Penjualan penjualan) {
        this.penjualanID = penjualan.penjualanID;
        this.namaBarang = penjualan.namaBarang;
        this.kategoriPenjualan = penjualan.kategoriPenjualan;
        this.jenisPenjualan = penjualan.jenisPenjualan;
        this.jumlah = penjualan.jumlah;
        this.diskon = penjualan.diskon;
        this.total = penjualan.total;
        this.tanggalTransaksiPenjualan = penjualan.tanggalTransaksiPenjualan;
        this.catatan = penjualan.catatan;
        this.statusTransaksi = penjualan.statusTransaksi;
        this.createdBy = penjualan.createdBy;
        this.createdDate = penjualan.createdDate;
        this.modifiedBy = penjualan.modifiedBy;
        this.modifiedDate = penjualan.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Penjualan other) {
        return this.equals(other);
    }

}
