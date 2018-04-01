package com.ledger.domain.financial.management;

import java.util.Date;

public class PiutangBuilder {

    private String userID;
    private String piutangID;
    private String jenisPiutang;
    private Date tanggalJatuhTempo;
    private String namaPiutang;
    private double jumlahPiutang;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PiutangBuilder() {
    }

    public PiutangBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PiutangBuilder setPiutangID(String piutangID) {
        this.piutangID = piutangID;
        return this;
    }

    public PiutangBuilder setJenisPiutang(String jenisPiutang) {
        this.jenisPiutang = jenisPiutang;
        return this;
    }

    public PiutangBuilder setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        return this;
    }

    public PiutangBuilder setNamaPiutang(String namaPiutang) {
        this.namaPiutang = namaPiutang;
        return this;
    }

    public PiutangBuilder setJumlahPiutang(double jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
        return this;
    }

    public PiutangBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public PiutangBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PiutangBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PiutangBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PiutangBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Piutang createPiutang() {
        return new Piutang(userID, piutangID, jenisPiutang, tanggalJatuhTempo, namaPiutang, jumlahPiutang, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
