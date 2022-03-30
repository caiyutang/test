package com.ruoyi.project.zazl.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.io.Serializable;

public class User  extends BaseEntity implements Serializable {
    private String id;
    private String address;
    private String userName;
    private String gaId;
    private String gaName;
    private String deptId;
    private String deptName;
    private String name;
    private String managementModel;
    private String belongType;
    private String hasStay;
    private String phoneNumber;
    private String personnelName;
    private String personnelPhoneNumber;
    private String pqName;
    private String mjName;
    private String galxrxm;
    private String county;

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getManagementModel() {
        return managementModel;
    }

    public void setManagementModel(String managementModel) {
        this.managementModel = managementModel;
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType;
    }

    public String getHasStay() {
        return hasStay;
    }

    public void setHasStay(String hasStay) {
        this.hasStay = hasStay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getPersonnelPhoneNumber() {
        return personnelPhoneNumber;
    }

    public void setPersonnelPhoneNumber(String personnelPhoneNumber) {
        this.personnelPhoneNumber = personnelPhoneNumber;
    }

    public String getPqName() {
        return pqName;
    }

    public void setPqName(String pqName) {
        this.pqName = pqName;
    }

    public String getMjName() {
        return mjName;
    }

    public void setMjName(String mjName) {
        this.mjName = mjName;
    }

    public String getGalxrxm() {
        return galxrxm;
    }

    public void setGalxrxm(String galxrxm) {
        this.galxrxm = galxrxm;
    }

    public String getGaId() {
        return gaId;
    }

    public void setGaId(String gaId) {
        this.gaId = gaId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGaName() {
        return gaName;
    }

    public void setGaName(String gaName) {
        this.gaName = gaName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
