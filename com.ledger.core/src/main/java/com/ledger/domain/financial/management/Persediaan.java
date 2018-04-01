package com.ledger.domain.financial.management;

import com.ledger.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class Persediaan implements EntityObject<Persediaan> {

    long id;
    private String userID;
    private String persediaanID;
    private String tipePersediaan;
    private String namaPersediaan;
    private String jenisPersediaan;
    private String satuan;
    private int jumlahPersediaan;
    private double hargaPersediaan;
    private double totalHargaPersediaan;
    private double hargaRataRata;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Persediaan() {
    }

    public Persediaan(String userID, String persediaanID, String tipePersediaan, String namaPersediaan, String satuan, String jenisPersediaan, int jumlahPersediaan, double hargaPersediaan, double hargaRataRata, double totalHargaPersediaan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.persediaanID = persediaanID;
        this.tipePersediaan = tipePersediaan;
        this.namaPersediaan = namaPersediaan;
        this.jenisPersediaan = jenisPersediaan;
        this.satuan = satuan;
        this.jumlahPersediaan = jumlahPersediaan;
        this.hargaRataRata = hargaRataRata;
        this.hargaPersediaan = hargaPersediaan;
        this.totalHargaPersediaan = totalHargaPersediaan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getPersediaanID() {
        return persediaanID;
    }

    public void setPersediaanID(String persediaanID) {
        this.persediaanID = persediaanID;
    }

    public String getNamaPersediaan() {
        return namaPersediaan;
    }

    public void setNamaPersediaan(String namaPersediaan) {
        this.namaPersediaan = namaPersediaan;
    }

    public int getJumlahPersediaan() {
        return jumlahPersediaan;
    }

    public void setJumlahPersediaan(int jumlahPersediaan) {
        this.jumlahPersediaan = jumlahPersediaan;
    }

    public double getHargaPersediaan() {
        return hargaPersediaan;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public double getHargaRataRata() {
        return hargaRataRata;
    }

    public void setHargaRataRata(double hargaRataRata) {
        this.hargaRataRata = hargaRataRata;
    }

    public void setHargaPersediaan(double hargaPersediaan) {
        this.hargaPersediaan = hargaPersediaan;
    }

    public double getTotalHargaPersediaan() {
        return totalHargaPersediaan;
    }

    public void setTotalHargaPersediaan(double totalHargaPersediaan) {
        this.totalHargaPersediaan = totalHargaPersediaan;
    }

    public String getJenisPersediaan() {
        return jenisPersediaan;
    }

    public void setJenisPersediaan(String jenisPersediaan) {
        this.jenisPersediaan = jenisPersediaan;
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

    public String getTipePersediaan() {
        return tipePersediaan;
    }

    public void setTipePersediaan(String tipePersediaan) {
        this.tipePersediaan = tipePersediaan;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.userID);
        hash = 37 * hash + Objects.hashCode(this.persediaanID);
        hash = 37 * hash + Objects.hashCode(this.tipePersediaan);
        hash = 37 * hash + Objects.hashCode(this.namaPersediaan);
        hash = 37 * hash + Objects.hashCode(this.jenisPersediaan);
        hash = 37 * hash + Objects.hashCode(this.satuan);
        hash = 37 * hash + this.jumlahPersediaan;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.hargaPersediaan) ^ (Double.doubleToLongBits(this.hargaPersediaan) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalHargaPersediaan) ^ (Double.doubleToLongBits(this.totalHargaPersediaan) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.hargaRataRata) ^ (Double.doubleToLongBits(this.hargaRataRata) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.createdBy);
        hash = 37 * hash + Objects.hashCode(this.createdDate);
        hash = 37 * hash + Objects.hashCode(this.modifiedBy);
        hash = 37 * hash + Objects.hashCode(this.modifiedDate);
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
        final Persediaan other = (Persediaan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewPersediaan(Persediaan persediaan) {
        this.userID = persediaan.userID;
        this.persediaanID = persediaan.persediaanID;
        this.tipePersediaan = persediaan.tipePersediaan;
        this.namaPersediaan = persediaan.namaPersediaan;
        this.jenisPersediaan = persediaan.jenisPersediaan;
        this.satuan = persediaan.satuan;
        this.jumlahPersediaan = persediaan.jumlahPersediaan;
        this.hargaPersediaan = persediaan.hargaPersediaan;
        this.hargaRataRata = persediaan.hargaRataRata;
        this.totalHargaPersediaan = persediaan.totalHargaPersediaan;
        this.modifiedBy = persediaan.modifiedBy;
        this.modifiedDate = persediaan.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Persediaan other) {
        return this.equals(other);
    }

}
