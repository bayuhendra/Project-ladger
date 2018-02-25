package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class Hutang implements EntityObject<Hutang> {

    long id;
    private String userID;
    private String hutangID;
    private String namaHutang;
    private double jumlahHutang;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Hutang() {
    }

    public Hutang(String userID, String hutangID, String namaHutang, double jumlahHutang, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.hutangID = hutangID;
        this.namaHutang = namaHutang;
        this.jumlahHutang = jumlahHutang;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getHutangID() {
        return hutangID;
    }

    public void setHutangID(String hutangID) {
        this.hutangID = hutangID;
    }

    public String getNamaHutang() {
        return namaHutang;
    }

    public void setNamaHutang(String namaHutang) {
        this.namaHutang = namaHutang;
    }

    public double getJumlahHutang() {
        return jumlahHutang;
    }

    public void setJumlahHutang(double jumlahHutang) {
        this.jumlahHutang = jumlahHutang;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.userID);
        hash = 41 * hash + Objects.hashCode(this.hutangID);
        hash = 41 * hash + Objects.hashCode(this.namaHutang);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.jumlahHutang) ^ (Double.doubleToLongBits(this.jumlahHutang) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.status);
        hash = 41 * hash + Objects.hashCode(this.createdBy);
        hash = 41 * hash + Objects.hashCode(this.createdDate);
        hash = 41 * hash + Objects.hashCode(this.modifiedBy);
        hash = 41 * hash + Objects.hashCode(this.modifiedDate);
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
        final Hutang other = (Hutang) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewHutang(Hutang hutang) {
        this.userID = hutang.userID;
        this.hutangID = hutang.hutangID;
        this.namaHutang = hutang.namaHutang;
        this.jumlahHutang = hutang.jumlahHutang;
        this.status = hutang.status;
        this.modifiedBy = hutang.modifiedBy;
        this.modifiedDate = hutang.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Hutang other) {
        return this.equals(other);
    }

}
