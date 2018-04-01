package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class ActivaTetapDTO implements Serializable {

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
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public ActivaTetapDTO() {
    }

    public ActivaTetapDTO(String userID, String activaTetapID, String jenisActiva, String namaActivaTetap, double hargaActivaTetap, int lamaPemakaian, int jangkaWaktuPenyusutan, int persenPenyusutan, double totalPenyusutan, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.activaTetapID = activaTetapID;
        this.jenisActiva = jenisActiva;
        this.namaActivaTetap = namaActivaTetap;
        this.hargaActivaTetap = hargaActivaTetap;
        this.lamaPemakaian = lamaPemakaian;
        this.jangkaWaktuPenyusutan = jangkaWaktuPenyusutan;
        this.persenPenyusutan = persenPenyusutan;
        this.totalPenyusutan = totalPenyusutan;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getActivaTetapID() {
        return activaTetapID;
    }

    public void setActivaTetapID(String activaTetapID) {
        this.activaTetapID = activaTetapID;
    }

    public String getNamaActivaTetap() {
        return namaActivaTetap;
    }

    public void setNamaActivaTetap(String namaActivaTetap) {
        this.namaActivaTetap = namaActivaTetap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getHargaActivaTetap() {
        return hargaActivaTetap;
    }

    public void setHargaActivaTetap(double hargaActivaTetap) {
        this.hargaActivaTetap = hargaActivaTetap;
    }

    public int getLamaPemakaian() {
        return lamaPemakaian;
    }

    public void setLamaPemakaian(int lamaPemakaian) {
        this.lamaPemakaian = lamaPemakaian;
    }

    public int getJangkaWaktuPenyusutan() {
        return jangkaWaktuPenyusutan;
    }

    public void setJangkaWaktuPenyusutan(int jangkaWaktuPenyusutan) {
        this.jangkaWaktuPenyusutan = jangkaWaktuPenyusutan;
    }

    public int getPersenPenyusutan() {
        return persenPenyusutan;
    }

    public void setPersenPenyusutan(int persenPenyusutan) {
        this.persenPenyusutan = persenPenyusutan;
    }

    public double getTotalPenyusutan() {
        return totalPenyusutan;
    }

    public void setTotalPenyusutan(double totalPenyusutan) {
        this.totalPenyusutan = totalPenyusutan;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getJenisActiva() {
        return jenisActiva;
    }

    public void setJenisActiva(String jenisActiva) {
        this.jenisActiva = jenisActiva;
    }

}
