/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.user.management.domain.user;

import com.ledger.shared.type.StatusData;
import com.ledger.user.management.domain.role.Role;
import java.util.Date;


public class UserBuilder {

    private long id;
    private String userID;
    private String nip;
    private String userName;
    private String password;
    private Role role;
    private StatusData userStatus;
    private UserSpecification userSpecification;
    private Date creationalDate;
    private String creationalBy;

    public UserBuilder() {
    }

    public UserBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public UserBuilder setNip(String nip) {
        this.nip = nip;
        return this;
    }

    public UserBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public UserBuilder setUserStatus(StatusData userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public UserBuilder setUserSpecification(UserSpecification userSpecification) {
        this.userSpecification = userSpecification;
        return this;
    }

    public UserBuilder setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
        return this;
    }

    public UserBuilder setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
        return this;
    }

    public User createUser() {
        return new User(id, userID, nip, userName, password, role, userStatus, userSpecification, creationalDate, creationalBy);
    }
    
}
