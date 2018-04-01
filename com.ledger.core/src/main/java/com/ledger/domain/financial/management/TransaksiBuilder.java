package com.ledger.domain.financial.management;

import java.util.Date;

public class TransaksiBuilder {

    private String transaksiID;
    private String userID;
    private String jenisTransaksi;
    private String namaTransaksi;
    private double nilaiTransaksi;
    private double cash;
    private double kredit;
    private Date tanggalTransaksi;
    private String jenisPembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TransaksiBuilder() {
    }

    public TransaksiBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public TransaksiBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public TransaksiBuilder setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
        return this;
    }

    public TransaksiBuilder setNamaTransaksi(String namaTransaksi) {
        this.namaTransaksi = namaTransaksi;
        return this;
    }

    public TransaksiBuilder setNilaiTransaksi(double nilaiTransaksi) {
        this.nilaiTransaksi = nilaiTransaksi;
        return this;
    }

    public TransaksiBuilder setCash(double cash) {
        this.cash = cash;
        return this;
    }

    public TransaksiBuilder setKredit(double kredit) {
        this.kredit = kredit;
        return this;
    }

    public TransaksiBuilder setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
        return this;
    }

    public TransaksiBuilder setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
        return this;
    }

    public TransaksiBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TransaksiBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TransaksiBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TransaksiBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Transaksi createTransaksi() {
        return new Transaksi(transaksiID, userID, jenisTransaksi, namaTransaksi, nilaiTransaksi, cash, kredit, tanggalTransaksi, jenisPembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
