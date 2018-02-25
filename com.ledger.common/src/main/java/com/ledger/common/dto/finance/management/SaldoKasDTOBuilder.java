package com.ledger.common.dto.finance.management;

import java.util.Date;

public class SaldoKasDTOBuilder {

    private String userID;
    private String saldoKasID;
    private double saldoKas;
    private double saldoBank;
    private double saldoKasBank;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public SaldoKasDTOBuilder() {
    }

    public SaldoKasDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public SaldoKasDTOBuilder setSaldoKasID(String saldoKasID) {
        this.saldoKasID = saldoKasID;
        return this;
    }

    public SaldoKasDTOBuilder setSaldoKas(double saldoKas) {
        this.saldoKas = saldoKas;
        return this;
    }

    public SaldoKasDTOBuilder setSaldoBank(double saldoBank) {
        this.saldoBank = saldoBank;
        return this;
    }

    public SaldoKasDTOBuilder setSaldoKasBank(double saldoKasBank) {
        this.saldoKasBank = saldoKasBank;
        return this;
    }

    public SaldoKasDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public SaldoKasDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public SaldoKasDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public SaldoKasDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public SaldoKasDTO createSaldoKasDTO() {
        return new SaldoKasDTO(userID, saldoKasID, saldoKas, saldoBank, saldoKasBank, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
