package com.ledger.domain.financial.management;

import java.util.Date;

public class SaldoKasBuilder {

    private String userID;
    private String saldoKasID;
    private double saldoKas;
    private double saldoBank;
    private double saldoLabaRugi;
    private double modalDisetor;
    private double saldoKasBank;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public SaldoKasBuilder() {
    }

    public SaldoKasBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public SaldoKasBuilder setSaldoKasID(String saldoKasID) {
        this.saldoKasID = saldoKasID;
        return this;
    }

    public SaldoKasBuilder setSaldoKas(double saldoKas) {
        this.saldoKas = saldoKas;
        return this;
    }

    public SaldoKasBuilder setSaldoBank(double saldoBank) {
        this.saldoBank = saldoBank;
        return this;
    }

    public SaldoKasBuilder setSaldoLabaRugi(double saldoLabaRugi) {
        this.saldoLabaRugi = saldoLabaRugi;
        return this;
    }

    public SaldoKasBuilder setModalDisetor(double modalDisetor) {
        this.modalDisetor = modalDisetor;
        return this;
    }

    public SaldoKasBuilder setSaldoKasBank(double saldoKasBank) {
        this.saldoKasBank = saldoKasBank;
        return this;
    }

    public SaldoKasBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public SaldoKasBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public SaldoKasBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public SaldoKasBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public SaldoKas createSaldoKas() {
        return new SaldoKas(userID, saldoKasID, saldoKas, saldoBank, saldoLabaRugi, modalDisetor, saldoKasBank, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
