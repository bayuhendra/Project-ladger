package com.ledger.common.dto.finance.management;

import java.util.Date;

public class TransaksiDTOBuilder {

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

    public TransaksiDTOBuilder() {
    }

    public TransaksiDTOBuilder setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
        return this;
    }

    public TransaksiDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public TransaksiDTOBuilder setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setNamaTransaksi(String namaTransaksi) {
        this.namaTransaksi = namaTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setNilaiTransaksi(double nilaiTransaksi) {
        this.nilaiTransaksi = nilaiTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setCash(double cash) {
        this.cash = cash;
        return this;
    }

    public TransaksiDTOBuilder setKredit(double kredit) {
        this.kredit = kredit;
        return this;
    }

    public TransaksiDTOBuilder setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
        return this;
    }

    public TransaksiDTOBuilder setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
        return this;
    }

    public TransaksiDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TransaksiDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TransaksiDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TransaksiDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public TransaksiDTO createTransaksiDTO() {
        return new TransaksiDTO(transaksiID, userID, jenisTransaksi, namaTransaksi, nilaiTransaksi, cash, kredit, tanggalTransaksi, jenisPembayaran, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
