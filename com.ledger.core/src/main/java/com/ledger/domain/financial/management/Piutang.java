package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class Piutang implements EntityObject<Piutang> {

    long id;
    private String userID;
    private String piutangID;
    private String jenisPiutang;
    private String namaPiutang;
    private double jumlahPiutang;
    private String status;
    private Date tanggalJatuhTempo;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Piutang() {
    }

    public Piutang(String userID, String piutangID, String jenisPiutang, Date tanggalJatuhTempo, String namaPiutang, double jumlahPiutang, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.piutangID = piutangID;
        this.jenisPiutang = jenisPiutang;
        this.namaPiutang = namaPiutang;
        this.jumlahPiutang = jumlahPiutang;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPiutangID() {
        return piutangID;
    }

    public void setPiutangID(String piutangID) {
        this.piutangID = piutangID;
    }

    public String getNamaPiutang() {
        return namaPiutang;
    }

    public void setNamaPiutang(String namaPiutang) {
        this.namaPiutang = namaPiutang;
    }

    public double getJumlahPiutang() {
        return jumlahPiutang;
    }

    public void setJumlahPiutang(double jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getJenisPiutang() {
        return jenisPiutang;
    }

    public void setJenisPiutang(String jenisPiutang) {
        this.jenisPiutang = jenisPiutang;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.userID);
        hash = 71 * hash + Objects.hashCode(this.piutangID);
        hash = 71 * hash + Objects.hashCode(this.jenisPiutang);
        hash = 71 * hash + Objects.hashCode(this.namaPiutang);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.jumlahPiutang) ^ (Double.doubleToLongBits(this.jumlahPiutang) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + Objects.hashCode(this.tanggalJatuhTempo);
        hash = 71 * hash + Objects.hashCode(this.createdBy);
        hash = 71 * hash + Objects.hashCode(this.createdDate);
        hash = 71 * hash + Objects.hashCode(this.modifiedBy);
        hash = 71 * hash + Objects.hashCode(this.modifiedDate);
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
        final Piutang other = (Piutang) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewPiutang(Piutang piutang) {
        this.userID = piutang.userID;
        this.piutangID = piutang.piutangID;
        this.jenisPiutang = piutang.jenisPiutang;
        this.namaPiutang = piutang.namaPiutang;
        this.jumlahPiutang = piutang.jumlahPiutang;
        this.tanggalJatuhTempo = piutang.tanggalJatuhTempo;
        this.status = piutang.status;
        this.modifiedBy = piutang.modifiedBy;
        this.modifiedDate = piutang.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Piutang other) {
        return this.equals(other);
    }

}
