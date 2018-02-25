package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class ActivaTetap implements EntityObject<ActivaTetap> {

    long id;
    private String userID;
    private String activaTetapID;
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

    public ActivaTetap() {
    }

    public ActivaTetap(String userID, String activaTetapID, String namaActivaTetap, double hargaActivaTetap, int lamaPemakaian, int jangkaWaktuPenyusutan, int persenPenyusutan, double totalPenyusutan, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.activaTetapID = activaTetapID;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.userID);
        hash = 53 * hash + Objects.hashCode(this.activaTetapID);
        hash = 53 * hash + Objects.hashCode(this.namaActivaTetap);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.hargaActivaTetap) ^ (Double.doubleToLongBits(this.hargaActivaTetap) >>> 32));
        hash = 53 * hash + this.lamaPemakaian;
        hash = 53 * hash + this.jangkaWaktuPenyusutan;
        hash = 53 * hash + this.persenPenyusutan;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.totalPenyusutan) ^ (Double.doubleToLongBits(this.totalPenyusutan) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.status);
        hash = 53 * hash + Objects.hashCode(this.createdBy);
        hash = 53 * hash + Objects.hashCode(this.createdDate);
        hash = 53 * hash + Objects.hashCode(this.modifiedBy);
        hash = 53 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActivaTetap other = (ActivaTetap) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewActivaTetap(ActivaTetap activaTetap) {
        this.userID = activaTetap.userID;
        this.activaTetapID = activaTetap.activaTetapID;
        this.namaActivaTetap = activaTetap.namaActivaTetap;
        this.hargaActivaTetap = activaTetap.hargaActivaTetap;
        this.lamaPemakaian = activaTetap.lamaPemakaian;
        this.jangkaWaktuPenyusutan = activaTetap.jangkaWaktuPenyusutan;
        this.persenPenyusutan = activaTetap.persenPenyusutan;
        this.totalPenyusutan = activaTetap.totalPenyusutan;
        this.status = activaTetap.status;
        this.modifiedBy = activaTetap.modifiedBy;
        this.modifiedDate = activaTetap.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(ActivaTetap other) {
        return this.equals(other);
    }

}