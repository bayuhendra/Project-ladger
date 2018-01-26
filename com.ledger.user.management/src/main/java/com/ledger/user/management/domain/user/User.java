package com.ledger.user.management.domain.user;

import com.ledger.shared.object.EntityObject;
import com.ledger.shared.type.StatusData;
import com.ledger.user.management.domain.role.Role;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class User implements EntityObject<User> {

    /* id for attriute*/
    long id;

    private String userID;
    private String nip;

    private String userName;
    private String password;
    private Role role;

    private StatusData userStatus;
    private UserSpecification userSpecification;


    /* Creational */
    private Date creationalDate;
    private String creationalBy;

    public User() {
    }

    public User(long id, String userID, String nip, String userName, String password, Role role, StatusData userStatus, UserSpecification userSpecification, Date creationalDate, String creationalBy) {
        this.id = id;
        this.userID = userID;
        this.nip = nip;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.userStatus = userStatus;
        this.userSpecification = userSpecification;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
    }

    public String getUserID() {
        return userID;
    }

    public String getNip() {
        return nip;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public StatusData getUserStatus() {
        return userStatus;
    }

    public UserSpecification getUserSpecification() {
        return userSpecification;
    }

    public Date getCreationalDate() {
        return creationalDate;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.userID);
        hash = 71 * hash + Objects.hashCode(this.nip);
        hash = 71 * hash + Objects.hashCode(this.userName);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.role);
        hash = 71 * hash + Objects.hashCode(this.userStatus);
        hash = 71 * hash + Objects.hashCode(this.userSpecification);
        hash = 71 * hash + Objects.hashCode(this.creationalDate);
        hash = 71 * hash + Objects.hashCode(this.creationalBy);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(User other) {
        return this.equals(other);
    }

    /*user status which purposes update status of data*/
    public void assignNewSpecification(User user) {
        this.role = user.getRole();
        this.userStatus = user.getUserStatus();
        this.userSpecification = user.getUserSpecification();
    }

    public void assignNewStatus(StatusData status) {
        this.userStatus = status;
    }

    public void assignNewUserData(Role role, UserSpecification userSpecification) {
        this.role = role;
        this.userSpecification = userSpecification;
    }

    public void assignNewPassword(String password) {
        this.password = password;
    }

}
