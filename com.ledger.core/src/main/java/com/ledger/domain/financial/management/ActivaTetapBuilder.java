package com.ledger.domain.financial.management;

import java.util.Date;

public class ActivaTetapBuilder {

    private String userID;
    private String alamat;
    private String noSertifikat;
    private String sertifikat;
    private String activaTetapID;
    private String jenisActiva;
    private String namaActivaTetap;
    private double hargaActivaTetap;
    private int lamaPemakaian;
    private int jangkaWaktuPenyusutan;
    private int persenPenyusutan;
    private double totalPenyusutan;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public ActivaTetapBuilder() {
    }

    public ActivaTetapBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public ActivaTetapBuilder setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public ActivaTetapBuilder setNoSertifikat(String noSertifikat) {
        this.noSertifikat = noSertifikat;
        return this;
    }

    public ActivaTetapBuilder setSertifikat(String sertifikat) {
        this.sertifikat = sertifikat;
        return this;
    }

    public ActivaTetapBuilder setActivaTetapID(String activaTetapID) {
        this.activaTetapID = activaTetapID;
        return this;
    }

    public ActivaTetapBuilder setJenisActiva(String jenisActiva) {
        this.jenisActiva = jenisActiva;
        return this;
    }

    public ActivaTetapBuilder setNamaActivaTetap(String namaActivaTetap) {
        this.namaActivaTetap = namaActivaTetap;
        return this;
    }

    public ActivaTetapBuilder setHargaActivaTetap(double hargaActivaTetap) {
        this.hargaActivaTetap = hargaActivaTetap;
        return this;
    }

    public ActivaTetapBuilder setLamaPemakaian(int lamaPemakaian) {
        this.lamaPemakaian = lamaPemakaian;
        return this;
    }

    public ActivaTetapBuilder setJangkaWaktuPenyusutan(int jangkaWaktuPenyusutan) {
        this.jangkaWaktuPenyusutan = jangkaWaktuPenyusutan;
        return this;
    }

    public ActivaTetapBuilder setPersenPenyusutan(int persenPenyusutan) {
        this.persenPenyusutan = persenPenyusutan;
        return this;
    }

    public ActivaTetapBuilder setTotalPenyusutan(double totalPenyusutan) {
        this.totalPenyusutan = totalPenyusutan;
        return this;
    }

    public ActivaTetapBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public ActivaTetapBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ActivaTetapBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ActivaTetapBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ActivaTetapBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ActivaTetap createActivaTetap() {
        return new ActivaTetap(userID, alamat, noSertifikat, sertifikat, activaTetapID, jenisActiva, namaActivaTetap, hargaActivaTetap, lamaPemakaian, jangkaWaktuPenyusutan, persenPenyusutan, totalPenyusutan, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
