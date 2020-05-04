package com.fantastic4.desktop.dto;

public class AdminDTO implements SuperDTO{
    private String adminID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String adminID, String name, String address, String email, String contactNo, String password) {
        this.adminID = adminID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


