package com.ledger.domain.financial.management;

import java.util.Date;


public class OpeningBalanceFlagBuilder {
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

    public OpeningBalanceFlagBuilder() {
    }

    public OpeningBalanceFlagBuilder setOpeningBalanceFlagID(String openingBalanceFlagID) {
        this.openingBalanceFlagID = openingBalanceFlagID;
        return this;
    }

    public OpeningBalanceFlagBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public OpeningBalanceFlagBuilder setIsFormSaldo(boolean isFormSaldo) {
        this.isFormSaldo = isFormSaldo;
        return this;
    }

    public OpeningBalanceFlagBuilder setIsFormHutang(boolean isFormHutang) {
        this.isFormHutang = isFormHutang;
        return this;
    }

    public OpeningBalanceFlagBuilder setIsFormPiutang(boolean isFormPiutang) {
        this.isFormPiutang = isFormPiutang;
        return this;
    }

    public OpeningBalanceFlagBuilder setIsFormPersediaan(boolean isFormPersediaan) {
        this.isFormPersediaan = isFormPersediaan;
        return this;
    }

    public OpeningBalanceFlagBuilder setIsFormActiva(boolean isFormActiva) {
        this.isFormActiva = isFormActiva;
        return this;
    }

    public OpeningBalanceFlagBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OpeningBalanceFlagBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public OpeningBalanceFlagBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public OpeningBalanceFlagBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public OpeningBalanceFlag createOpeningBalanceFlag() {
        return new OpeningBalanceFlag(openingBalanceFlagID, userID, isFormSaldo, isFormHutang, isFormPiutang, isFormPersediaan, isFormActiva, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
