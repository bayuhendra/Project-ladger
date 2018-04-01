package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Transaksi implements EntityObject<Transaksi> {

    long id;
    private String transaksiID;
    private String userID;
    private String jenisTransaksi;
    private String namaTransaksi;
    private double nilaiTransaksi;
    private double cash;
    private double kredit;
    private Date tanggalTransaksi;
    private String jenisPembayaran;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Transaksi() {
    }

    public Transaksi(String transaksiID, String userID, String jenisTransaksi, String namaTransaksi, double nilaiTransaksi, double cash, double kredit, Date tanggalTransaksi, String jenisPembayaran, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.transaksiID = transaksiID;
        this.userID = userID;
        this.jenisTransaksi = jenisTransaksi;
        this.namaTransaksi = namaTransaksi;
        this.nilaiTransaksi = nilaiTransaksi;
        this.cash = cash;
        this.kredit = kredit;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jenisPembayaran = jenisPembayaran;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getTransaksiID() {
        return transaksiID;
    }

    public void setTransaksiID(String transaksiID) {
        this.transaksiID = transaksiID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public String getNamaTransaksi() {
        return namaTransaksi;
    }

    public void setNamaTransaksi(String namaTransaksi) {
        this.namaTransaksi = namaTransaksi;
    }

    public double getNilaiTransaksi() {
        return nilaiTransaksi;
    }

    public void setNilaiTransaksi(double nilaiTransaksi) {
        this.nilaiTransaksi = nilaiTransaksi;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.transaksiID);
        hash = 97 * hash + Objects.hashCode(this.userID);
        hash = 97 * hash + Objects.hashCode(this.jenisTransaksi);
        hash = 97 * hash + Objects.hashCode(this.namaTransaksi);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.nilaiTransaksi) ^ (Double.doubleToLongBits(this.nilaiTransaksi) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cash) ^ (Double.doubleToLongBits(this.cash) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.kredit) ^ (Double.doubleToLongBits(this.kredit) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.tanggalTransaksi);
        hash = 97 * hash + Objects.hashCode(this.jenisPembayaran);
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
        final Transaksi other = (Transaksi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataTransaksi(Transaksi transaksi) {
        this.transaksiID = transaksi.transaksiID;
        this.userID = transaksi.userID;
        this.jenisTransaksi = transaksi.jenisTransaksi;
        this.namaTransaksi = transaksi.namaTransaksi;
        this.nilaiTransaksi = transaksi.nilaiTransaksi;
        this.cash = transaksi.cash;
        this.kredit = transaksi.kredit;
        this.tanggalTransaksi = transaksi.tanggalTransaksi;
        this.jenisPembayaran = transaksi.jenisPembayaran;
        this.createdBy = transaksi.createdBy;
        this.createdDate = transaksi.createdDate;
        this.modifiedBy = transaksi.modifiedBy;
        this.modifiedDate = transaksi.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Transaksi other) {
        return this.equals(other);
    }

}
