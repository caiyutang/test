package com.ruoyi.project.zazl.domain;

import java.io.Serializable;
import java.util.Date;

public class Recruit implements Serializable {
    private String id;

    private String positionName;

    private String recruitCount;

    private String minSalary;

    private String maxSalary;

    private String faceDiscussStatus;

    private String welfare;

    private String education;

    private String freshStudent;

    private String workYears;

    private String remark;

    private String concatName;

    private String concatPhone;

    private String phonePublic;

    private String email;

    private String createUserName;

    private String createId;

    private Date createDate;

    private String regionId;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getRecruitCount() {
        return recruitCount;
    }

    public void setRecruitCount(String recruitCount) {
        this.recruitCount = recruitCount;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getFaceDiscussStatus() {
        return faceDiscussStatus;
    }

    public void setFaceDiscussStatus(String faceDiscussStatus) {
        this.faceDiscussStatus = faceDiscussStatus;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFreshStudent() {
        return freshStudent;
    }

    public void setFreshStudent(String freshStudent) {
        this.freshStudent = freshStudent;
    }

    public String getWorkYears() {
        return workYears;
    }

    public void setWorkYears(String workYears) {
        this.workYears = workYears;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getConcatName() {
        return concatName;
    }

    public void setConcatName(String concatName) {
        this.concatName = concatName;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    public String getPhonePublic() {
        return phonePublic;
    }

    public void setPhonePublic(String phonePublic) {
        this.phonePublic = phonePublic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
