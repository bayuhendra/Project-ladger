package com.ledger.domain.financial.management;

import java.util.Date;


public class HutangBuilder {
    private String userID;
    private String hutangID;
    private String jenisHutang;
    private String namaHutang;
    private Date tanggalJatuhTempo;
    private double jumlahHutang;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public HutangBuilder() {
    }

    public HutangBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public HutangBuilder setHutangID(String hutangID) {
        this.hutangID = hutangID;
        return this;
    }

    public HutangBuilder setJenisHutang(String jenisHutang) {
        this.jenisHutang = jenisHutang;
        return this;
    }

    public HutangBuilder setNamaHutang(String namaHutang) {
        this.namaHutang = namaHutang;
        return this;
    }

    public HutangBuilder setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        return this;
    }

    public HutangBuilder setJumlahHutang(double jumlahHutang) {
        this.jumlahHutang = jumlahHutang;
        return this;
    }

    public HutangBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public HutangBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public HutangBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public HutangBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public HutangBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Hutang createHutang() {
        return new Hutang(userID, hutangID, jenisHutang, namaHutang, tanggalJatuhTempo, jumlahHutang, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
