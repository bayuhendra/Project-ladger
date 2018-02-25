package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class SaldoKas implements EntityObject<SaldoKas> {

    long id;
    private String userID;
    private String saldoKasID;
    private double saldoKas;
    private double saldoBank;
    private double saldoKasBank;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public SaldoKas() {
    }

    public SaldoKas(String userID, String saldoKasID, double saldoKas, double saldoBank, double saldoKasBank, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.saldoKasID = saldoKasID;
        this.saldoKas = saldoKas;
        this.saldoBank = saldoBank;
        this.saldoKasBank = saldoKasBank;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getSaldoKasID() {
        return saldoKasID;
    }

    public void setSaldoKasID(String saldoKasID) {
        this.saldoKasID = saldoKasID;
    }

    public double getSaldoKas() {
        return saldoKas;
    }

    public void setSaldoKas(double saldoKas) {
        this.saldoKas = saldoKas;
    }

    public double getSaldoBank() {
        return saldoBank;
    }

    public void setSaldoBank(double saldoBank) {
        this.saldoBank = saldoBank;
    }

    public double getSaldoKasBank() {
        return saldoKasBank;
    }

    public void setSaldoKasBank(double saldoKasBank) {
        this.saldoKasBank = saldoKasBank;
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
        hash = 97 * hash + Objects.hashCode(this.userID);
        hash = 97 * hash + Objects.hashCode(this.saldoKasID);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldoKas) ^ (Double.doubleToLongBits(this.saldoKas) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldoBank) ^ (Double.doubleToLongBits(this.saldoBank) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldoKasBank) ^ (Double.doubleToLongBits(this.saldoKasBank) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.createdBy);
        hash = 97 * hash + Objects.hashCode(this.createdDate);
        hash = 97 * hash + Objects.hashCode(this.modifiedBy);
        hash = 97 * hash + Objects.hashCode(this.modifiedDate);
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
        final SaldoKas other = (SaldoKas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewSaldoKas(SaldoKas saldoKas) {
        this.userID = saldoKas.userID;
        this.saldoKasID = saldoKas.saldoKasID;
        this.saldoKas = saldoKas.saldoKas;
        this.saldoBank = saldoKas.saldoBank;
        this.saldoKasBank = saldoKas.saldoKasBank;
        this.modifiedBy = saldoKas.modifiedBy;
        this.modifiedDate = saldoKas.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(SaldoKas other) {
        return this.equals(other);
    }

}
