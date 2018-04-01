package com.ledger.common.dto.finance.management;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class SaldoKasDTO implements Serializable {

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

    public SaldoKasDTO() {
    }

    public SaldoKasDTO(String userID, String saldoKasID, double saldoKas, double saldoBank, double saldoLabaRugi, double modalDisetor, double saldoKasBank, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.saldoKasID = saldoKasID;
        this.saldoKas = saldoKas;
        this.saldoBank = saldoBank;
        this.saldoLabaRugi = saldoLabaRugi;
        this.modalDisetor = modalDisetor;
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

    public double getSaldoLabaRugi() {
        return saldoLabaRugi;
    }

    public void setSaldoLabaRugi(double saldoLabaRugi) {
        this.saldoLabaRugi = saldoLabaRugi;
    }

    public double getModalDisetor() {
        return modalDisetor;
    }

    public void setModalDisetor(double modalDisetor) {
        this.modalDisetor = modalDisetor;
    }

    @Override
    public String toString() {
        return "SaldoKasDTO{" + "userID=" + userID + ", saldoKasID=" + saldoKasID + ", saldoKas=" + saldoKas + ", saldoBank=" + saldoBank + ", saldoLabaRugi=" + saldoLabaRugi + ", modalDisetor=" + modalDisetor + ", saldoKasBank=" + saldoKasBank + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
