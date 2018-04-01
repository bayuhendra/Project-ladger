package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class OpeningBalanceFlagDTO implements Serializable {

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

    public OpeningBalanceFlagDTO() {
    }

    public OpeningBalanceFlagDTO(String openingBalanceFlagID, String userID, boolean isFormSaldo, boolean isFormHutang, boolean isFormPiutang, boolean isFormPersediaan, boolean isFormActiva, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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

}
