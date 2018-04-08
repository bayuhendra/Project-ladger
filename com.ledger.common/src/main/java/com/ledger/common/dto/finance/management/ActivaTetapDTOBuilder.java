package com.ledger.common.dto.finance.management;

import java.util.Date;


public class ActivaTetapDTOBuilder {
    private String userID;
    private String activaTetapID;
    private String jenisActiva;
    private String namaActivaTetap;
    private double hargaActivaTetap;
    private int lamaPemakaian;
    private int jangkaWaktuPenyusutan;
    private int persenPenyusutan;
    private double totalPenyusutan;
    private String status;
    private String alamat;
    private String noSertifikat;
    private String sertifikat;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public ActivaTetapDTOBuilder() {
    }

    public ActivaTetapDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public ActivaTetapDTOBuilder setActivaTetapID(String activaTetapID) {
        this.activaTetapID = activaTetapID;
        return this;
    }

    public ActivaTetapDTOBuilder setJenisActiva(String jenisActiva) {
        this.jenisActiva = jenisActiva;
        return this;
    }

    public ActivaTetapDTOBuilder setNamaActivaTetap(String namaActivaTetap) {
        this.namaActivaTetap = namaActivaTetap;
        return this;
    }

    public ActivaTetapDTOBuilder setHargaActivaTetap(double hargaActivaTetap) {
        this.hargaActivaTetap = hargaActivaTetap;
        return this;
    }

    public ActivaTetapDTOBuilder setLamaPemakaian(int lamaPemakaian) {
        this.lamaPemakaian = lamaPemakaian;
        return this;
    }

    public ActivaTetapDTOBuilder setJangkaWaktuPenyusutan(int jangkaWaktuPenyusutan) {
        this.jangkaWaktuPenyusutan = jangkaWaktuPenyusutan;
        return this;
    }

    public ActivaTetapDTOBuilder setPersenPenyusutan(int persenPenyusutan) {
        this.persenPenyusutan = persenPenyusutan;
        return this;
    }

    public ActivaTetapDTOBuilder setTotalPenyusutan(double totalPenyusutan) {
        this.totalPenyusutan = totalPenyusutan;
        return this;
    }

    public ActivaTetapDTOBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public ActivaTetapDTOBuilder setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public ActivaTetapDTOBuilder setNoSertifikat(String noSertifikat) {
        this.noSertifikat = noSertifikat;
        return this;
    }

    public ActivaTetapDTOBuilder setSertifikat(String sertifikat) {
        this.sertifikat = sertifikat;
        return this;
    }

    public ActivaTetapDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ActivaTetapDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ActivaTetapDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ActivaTetapDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ActivaTetapDTO createActivaTetapDTO() {
        return new ActivaTetapDTO(userID, activaTetapID, jenisActiva, namaActivaTetap, hargaActivaTetap, lamaPemakaian, jangkaWaktuPenyusutan, persenPenyusutan, totalPenyusutan, status, alamat, noSertifikat, sertifikat, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
