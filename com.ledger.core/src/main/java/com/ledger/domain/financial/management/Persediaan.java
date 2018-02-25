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
    private String namaPersediaan;
    private String jenisPersediaan;
    private int jumlahPersediaan;
    private double hargaPersediaan;
    private double totalHargaPersediaan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Persediaan() {
    }

    public Persediaan(String userID, String persediaanID, String namaPersediaan, String jenisPersediaan, int jumlahPersediaan, double hargaPersediaan, double totalHargaPersediaan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.userID = userID;
        this.persediaanID = persediaanID;
        this.namaPersediaan = namaPersediaan;
        this.jenisPersediaan = jenisPersediaan;
        this.jumlahPersediaan = jumlahPersediaan;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.userID);
        hash = 37 * hash + Objects.hashCode(this.persediaanID);
        hash = 37 * hash + Objects.hashCode(this.namaPersediaan);
        hash = 37 * hash + Objects.hashCode(this.jenisPersediaan);
        hash = 37 * hash + this.jumlahPersediaan;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.hargaPersediaan) ^ (Double.doubleToLongBits(this.hargaPersediaan) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalHargaPersediaan) ^ (Double.doubleToLongBits(this.totalHargaPersediaan) >>> 32));
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
        this.namaPersediaan = persediaan.namaPersediaan;
        this.jenisPersediaan = persediaan.jenisPersediaan;
        this.jumlahPersediaan = persediaan.jumlahPersediaan;
        this.hargaPersediaan = persediaan.hargaPersediaan;
        this.totalHargaPersediaan = persediaan.totalHargaPersediaan;
        this.modifiedBy = persediaan.modifiedBy;
        this.modifiedDate = persediaan.modifiedDate;

    }

    @Override
    public boolean sameIdentityAs(Persediaan other) {
        return this.equals(other);
    }

}
