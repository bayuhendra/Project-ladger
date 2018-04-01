package com.ledger.common.dto.finance.management;

import java.util.Date;


public class HutangDTOBuilder {
    private String userID;
    private String hutangID;
    private String jenisHutang;
    private String namaHutang;
    private double jumlahHutang;
    private Date tanggalJatuhTempo;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public HutangDTOBuilder() {
    }

    public HutangDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public HutangDTOBuilder setHutangID(String hutangID) {
        this.hutangID = hutangID;
        return this;
    }

    public HutangDTOBuilder setJenisHutang(String jenisHutang) {
        this.jenisHutang = jenisHutang;
        return this;
    }

    public HutangDTOBuilder setNamaHutang(String namaHutang) {
        this.namaHutang = namaHutang;
        return this;
    }

    public HutangDTOBuilder setJumlahHutang(double jumlahHutang) {
        this.jumlahHutang = jumlahHutang;
        return this;
    }

    public HutangDTOBuilder setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        return this;
    }

    public HutangDTOBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public HutangDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public HutangDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public HutangDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public HutangDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public HutangDTO createHutangDTO() {
        return new HutangDTO(userID, hutangID, jenisHutang, namaHutang, jumlahHutang, tanggalJatuhTempo, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
