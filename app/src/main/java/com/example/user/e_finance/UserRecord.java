package com.example.user.e_finance;

/**
 * Created by KD on 12/31/2017.
 */

import com.example.user.e_finance.UserContract.User;

public class UserRecord {
    private String username;
    private String name;
    private String email;
    private String password;
    private String contactno;
    private String address;

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public UserRecord() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRecord(String username, String name, String email, String password, String contactno, String address) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactno = contactno;
        this.address = address;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return User.COLUMN_NAME + ":" + this.name + "," + User.COLUMN_EMAIL + ":" + this.email+"," + User.COLUMN_PASSWORD+ ":" + this.password;
    }

}