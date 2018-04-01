package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class OpeningBalanceFlag implements EntityObject<OpeningBalanceFlag> {

    long id;
    private String openingBalanceFlagID;
    private String userID;
    private boolean isFormSaldo;
    private boolean isFormHutang;
    private boolean isFormPiutang;
    private boolean isFormPersediaan;
    private boolean isFormActiva;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public OpeningBalanceFlag() {
    }

    public OpeningBalanceFlag(String openingBalanceFlagID, String userID, boolean isFormSaldo, boolean isFormHutang, boolean isFormPiutang, boolean isFormPersediaan, boolean isFormActiva, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.openingBalanceFlagID = openingBalanceFlagID;
        this.userID = userID;
        this.isFormSaldo = isFormSaldo;
        this.isFormHutang = isFormHutang;
        this.isFormPiutang = isFormPiutang;
        this.isFormPersediaan = isFormPersediaan;
        this.isFormActiva = isFormActiva;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getOpeningBalanceFlagID() {
        return openingBalanceFlagID;
    }

    public void setOpeningBalanceFlagID(String openingBalanceFlagID) {
        this.openingBalanceFlagID = openingBalanceFlagID;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isIsFormSaldo() {
        return isFormSaldo;
    }

    public void setIsFormSaldo(boolean isFormSaldo) {
        this.isFormSaldo = isFormSaldo;
    }

    public boolean isIsFormHutang() {
        return isFormHutang;
    }

    public void setIsFormHutang(boolean isFormHutang) {
        this.isFormHutang = isFormHutang;
    }

    public boolean isIsFormPiutang() {
        return isFormPiutang;
    }

    public void setIsFormPiutang(boolean isFormPiutang) {
        this.isFormPiutang = isFormPiutang;
    }

    public boolean isIsFormPersediaan() {
        return isFormPersediaan;
    }

    public void setIsFormPersediaan(boolean isFormPersediaan) {
        this.isFormPersediaan = isFormPersediaan;
    }

    public boolean isIsFormActiva() {
        return isFormActiva;
    }

    public void setIsFormActiva(boolean isFormActiva) {
        this.isFormActiva = isFormActiva;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.openingBalanceFlagID);
        hash = 11 * hash + Objects.hashCode(this.userID);
        hash = 11 * hash + (this.isFormSaldo ? 1 : 0);
        hash = 11 * hash + (this.isFormHutang ? 1 : 0);
        hash = 11 * hash + (this.isFormPiutang ? 1 : 0);
        hash = 11 * hash + (this.isFormPersediaan ? 1 : 0);
        hash = 11 * hash + (this.isFormActiva ? 1 : 0);
        hash = 11 * hash + Objects.hashCode(this.createdBy);
        hash = 11 * hash + Objects.hashCode(this.createdDate);
        hash = 11 * hash + Objects.hashCode(this.modifiedBy);
        hash = 11 * hash + Objects.hashCode(this.modifiedDate);
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
        final OpeningBalanceFlag other = (OpeningBalanceFlag) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewOpeningBalanceFlag(OpeningBalanceFlag flag) {
        this.userID = flag.userID;
        this.isFormSaldo = flag.isFormSaldo;
        this.isFormHutang = flag.isFormHutang;
        this.isFormPiutang = flag.isFormPiutang;
        this.isFormPersediaan = flag.isFormPersediaan;
        this.isFormActiva = flag.isFormActiva;
        this.modifiedBy = flag.modifiedBy;
        this.modifiedDate = flag.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(OpeningBalanceFlag other) {
        return this.equals(other);
    }

}
