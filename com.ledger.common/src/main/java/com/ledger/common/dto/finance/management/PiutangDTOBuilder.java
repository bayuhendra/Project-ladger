package com.ledger.common.dto.finance.management;

import java.util.Date;


public class PiutangDTOBuilder {
    private String userID;
    private String piutangID;
    private String jenisPiutang;
    private String namaPiutang;
    private double jumlahPiutang;
    private Date tanggalJatuhTempo;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PiutangDTOBuilder() {
    }

    public PiutangDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public PiutangDTOBuilder setPiutangID(String piutangID) {
        this.piutangID = piutangID;
        return this;
    }

    public PiutangDTOBuilder setJenisPiutang(String jenisPiutang) {
        this.jenisPiutang = jenisPiutang;
        return this;
    }

    public PiutangDTOBuilder setNamaPiutang(String namaPiutang) {
        this.namaPiutang = namaPiutang;
        return this;
    }

    public PiutangDTOBuilder setJumlahPiutang(double jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
        return this;
    }

    public PiutangDTOBuilder setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        return this;
    }

    public PiutangDTOBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public PiutangDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PiutangDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PiutangDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PiutangDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PiutangDTO createPiutangDTO() {
        return new PiutangDTO(userID, piutangID, jenisPiutang, namaPiutang, jumlahPiutang, tanggalJatuhTempo, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
