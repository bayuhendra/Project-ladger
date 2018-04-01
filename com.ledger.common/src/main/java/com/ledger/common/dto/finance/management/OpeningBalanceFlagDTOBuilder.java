package com.ledger.common.dto.finance.management;

import java.util.Date;


public class OpeningBalanceFlagDTOBuilder {
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

    public OpeningBalanceFlagDTOBuilder() {
    }

    public OpeningBalanceFlagDTOBuilder setOpeningBalanceFlagID(String openingBalanceFlagID) {
        this.openingBalanceFlagID = openingBalanceFlagID;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setIsFormSaldo(boolean isFormSaldo) {
        this.isFormSaldo = isFormSaldo;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setIsFormHutang(boolean isFormHutang) {
        this.isFormHutang = isFormHutang;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setIsFormPiutang(boolean isFormPiutang) {
        this.isFormPiutang = isFormPiutang;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setIsFormPersediaan(boolean isFormPersediaan) {
        this.isFormPersediaan = isFormPersediaan;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setIsFormActiva(boolean isFormActiva) {
        this.isFormActiva = isFormActiva;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public OpeningBalanceFlagDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public OpeningBalanceFlagDTO createOpeningBalanceFlagDTO() {
        return new OpeningBalanceFlagDTO(openingBalanceFlagID, userID, isFormSaldo, isFormHutang, isFormPiutang, isFormPersediaan, isFormActiva, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
