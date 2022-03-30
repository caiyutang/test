package com.ruoyi.project.zazl.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class PersonInfo implements Serializable {
    private String id;

    private String gender;

    private String personId;

    private String personName;

    private String orgName;

    private String srcParentIndex;

    private String job;

    private String companyName;

    private String tempAddress;

    private String tempAddressName;

    private String phoneNo;

    private String address;

    private String county;

    private String dormId;

    private String status;

    private String facePicLocal;

    private String certificateType;

    private String certificateNo;

    private String orgPath;

    private String orgIndexCode;

    private String updateTime;

    private String birthday;

    private String picUrl;

    private String picUri;

    private String serverIndexCode;

    private String email;

    private String education;

    private String nation;

    private String jobNo;


    private String srcIndex;

    private Date startJobDate;

    private String entranceId;

    private String idcardPicUrl;


    private String idcardPicLocal;

    private String province;

    private String city;

    private String county_String;

    private String town;

    private String village;

    private String landlordName;

    private String landlordPhoneno;

    private String stayStatus;

    private String entryType;

    private String outlookType;

    private String marryType;

    private String resideReason;

    private String resideType;

    private String filesId;

    private String leaveReason;

    private String leaveRemark;

    private String identificationStatus;

    private String deleteReason;

    private String deleteRemark;

    private String isCheck;

    private Date contractDateStart;

    private Date contractDateEnd;

    private String limitPerson1Relation;

    private String limitPerson1Name;

    private String limitPerson1Phone;

    private String limitPerson2Relation;

    private String limitPerson2Name;

    private String limitPerson2Phone;

    private String introducerId;

    private String introducerName;

    private String skill;

    private String isInsured;

    private String insuredContent;

    private String insuredOther;

    private Date insuredDateStart;

    private Date insuredDateEnd;

    private String sfhcys;

    private String idcardForSystem;

    private Date importSystemDate;

    private String bodyMaxTemperatureValue;

    private String personCode;

    private String personType;

    private String visitorType;

    private String familyRelation;

    private String pcs;

    private Date tryUseDateStart;

    private Date tryUseDateEnd;

    private String whereabouts;

    private String leaveAimPlace;

    private Date leaveDateStart;

    private Date leaveDateEnd;

    private String parttimeOrgCode;

    private String parttimeOrgName;

    private String companyPersonnel;

    private String companyPersonnelPhone;

    private String companyAddress;

    private String zzzh;

    /** 请求参数 */
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getOrgIndexCode() {
        return orgIndexCode;
    }

    public void setOrgIndexCode(String orgIndexCode) {
        this.orgIndexCode = orgIndexCode;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }

    public String getServerIndexCode() {
        return serverIndexCode;
    }

    public void setServerIndexCode(String serverIndexCode) {
        this.serverIndexCode = serverIndexCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getSrcIndex() {
        return srcIndex;
    }

    public void setSrcIndex(String srcIndex) {
        this.srcIndex = srcIndex;
    }

    public Date getStartJobDate() {
        return startJobDate;
    }

    public void setStartJobDate(Date startJobDate) {
        this.startJobDate = startJobDate;
    }

    public String getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(String entranceId) {
        this.entranceId = entranceId;
    }

    public String getIdcardPicUrl() {
        return idcardPicUrl;
    }

    public void setIdcardPicUrl(String idcardPicUrl) {
        this.idcardPicUrl = idcardPicUrl;
    }

    public String getIdcardPicLocal() {
        return idcardPicLocal;
    }

    public void setIdcardPicLocal(String idcardPicLocal) {
        this.idcardPicLocal = idcardPicLocal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty_String() {
        return county_String;
    }

    public void setCounty_String(String county_String) {
        this.county_String = county_String;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordPhoneno() {
        return landlordPhoneno;
    }

    public void setLandlordPhoneno(String landlordPhoneno) {
        this.landlordPhoneno = landlordPhoneno;
    }

    public String getStayStatus() {
        return stayStatus;
    }

    public void setStayStatus(String stayStatus) {
        this.stayStatus = stayStatus;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getOutlookType() {
        return outlookType;
    }

    public void setOutlookType(String outlookType) {
        this.outlookType = outlookType;
    }

    public String getMarryType() {
        return marryType;
    }

    public void setMarryType(String marryType) {
        this.marryType = marryType;
    }

    public String getResideReason() {
        return resideReason;
    }

    public void setResideReason(String resideReason) {
        this.resideReason = resideReason;
    }

    public String getResideType() {
        return resideType;
    }

    public void setResideType(String resideType) {
        this.resideType = resideType;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveRemark() {
        return leaveRemark;
    }

    public void setLeaveRemark(String leaveRemark) {
        this.leaveRemark = leaveRemark;
    }

    public String getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationStatus(String identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public String getDeleteRemark() {
        return deleteRemark;
    }

    public void setDeleteRemark(String deleteRemark) {
        this.deleteRemark = deleteRemark;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public Date getContractDateStart() {
        return contractDateStart;
    }

    public void setContractDateStart(Date contractDateStart) {
        this.contractDateStart = contractDateStart;
    }

    public Date getContractDateEnd() {
        return contractDateEnd;
    }

    public void setContractDateEnd(Date contractDateEnd) {
        this.contractDateEnd = contractDateEnd;
    }

    public String getLimitPerson1Relation() {
        return limitPerson1Relation;
    }

    public void setLimitPerson1Relation(String limitPerson1Relation) {
        this.limitPerson1Relation = limitPerson1Relation;
    }

    public String getLimitPerson1Name() {
        return limitPerson1Name;
    }

    public void setLimitPerson1Name(String limitPerson1Name) {
        this.limitPerson1Name = limitPerson1Name;
    }

    public String getLimitPerson1Phone() {
        return limitPerson1Phone;
    }

    public void setLimitPerson1Phone(String limitPerson1Phone) {
        this.limitPerson1Phone = limitPerson1Phone;
    }

    public String getLimitPerson2Relation() {
        return limitPerson2Relation;
    }

    public void setLimitPerson2Relation(String limitPerson2Relation) {
        this.limitPerson2Relation = limitPerson2Relation;
    }

    public String getLimitPerson2Name() {
        return limitPerson2Name;
    }

    public void setLimitPerson2Name(String limitPerson2Name) {
        this.limitPerson2Name = limitPerson2Name;
    }

    public String getLimitPerson2Phone() {
        return limitPerson2Phone;
    }

    public void setLimitPerson2Phone(String limitPerson2Phone) {
        this.limitPerson2Phone = limitPerson2Phone;
    }

    public String getIntroducerId() {
        return introducerId;
    }

    public void setIntroducerId(String introducerId) {
        this.introducerId = introducerId;
    }

    public String getIntroducerName() {
        return introducerName;
    }

    public void setIntroducerName(String introducerName) {
        this.introducerName = introducerName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getIsInsured() {
        return isInsured;
    }

    public void setIsInsured(String isInsured) {
        this.isInsured = isInsured;
    }

    public String getInsuredContent() {
        return insuredContent;
    }

    public void setInsuredContent(String insuredContent) {
        this.insuredContent = insuredContent;
    }

    public String getInsuredOther() {
        return insuredOther;
    }

    public void setInsuredOther(String insuredOther) {
        this.insuredOther = insuredOther;
    }

    public Date getInsuredDateStart() {
        return insuredDateStart;
    }

    public void setInsuredDateStart(Date insuredDateStart) {
        this.insuredDateStart = insuredDateStart;
    }

    public Date getInsuredDateEnd() {
        return insuredDateEnd;
    }

    public void setInsuredDateEnd(Date insuredDateEnd) {
        this.insuredDateEnd = insuredDateEnd;
    }

    public String getSfhcys() {
        return sfhcys;
    }

    public void setSfhcys(String sfhcys) {
        this.sfhcys = sfhcys;
    }

    public String getIdcardForSystem() {
        return idcardForSystem;
    }

    public void setIdcardForSystem(String idcardForSystem) {
        this.idcardForSystem = idcardForSystem;
    }

    public Date getImportSystemDate() {
        return importSystemDate;
    }

    public void setImportSystemDate(Date importSystemDate) {
        this.importSystemDate = importSystemDate;
    }

    public String getBodyMaxTemperatureValue() {
        return bodyMaxTemperatureValue;
    }

    public void setBodyMaxTemperatureValue(String bodyMaxTemperatureValue) {
        this.bodyMaxTemperatureValue = bodyMaxTemperatureValue;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getPcs() {
        return pcs;
    }

    public void setPcs(String pcs) {
        this.pcs = pcs;
    }

    public Date getTryUseDateStart() {
        return tryUseDateStart;
    }

    public void setTryUseDateStart(Date tryUseDateStart) {
        this.tryUseDateStart = tryUseDateStart;
    }

    public Date getTryUseDateEnd() {
        return tryUseDateEnd;
    }

    public void setTryUseDateEnd(Date tryUseDateEnd) {
        this.tryUseDateEnd = tryUseDateEnd;
    }

    public String getWhereabouts() {
        return whereabouts;
    }

    public void setWhereabouts(String whereabouts) {
        this.whereabouts = whereabouts;
    }

    public String getLeaveAimPlace() {
        return leaveAimPlace;
    }

    public void setLeaveAimPlace(String leaveAimPlace) {
        this.leaveAimPlace = leaveAimPlace;
    }

    public Date getLeaveDateStart() {
        return leaveDateStart;
    }

    public void setLeaveDateStart(Date leaveDateStart) {
        this.leaveDateStart = leaveDateStart;
    }

    public Date getLeaveDateEnd() {
        return leaveDateEnd;
    }

    public void setLeaveDateEnd(Date leaveDateEnd) {
        this.leaveDateEnd = leaveDateEnd;
    }

    public String getParttimeOrgCode() {
        return parttimeOrgCode;
    }

    public void setParttimeOrgCode(String parttimeOrgCode) {
        this.parttimeOrgCode = parttimeOrgCode;
    }

    public String getParttimeOrgName() {
        return parttimeOrgName;
    }

    public void setParttimeOrgName(String parttimeOrgName) {
        this.parttimeOrgName = parttimeOrgName;
    }

    public String getCompanyPersonnel() {
        return companyPersonnel;
    }

    public void setCompanyPersonnel(String companyPersonnel) {
        this.companyPersonnel = companyPersonnel;
    }

    public String getCompanyPersonnelPhone() {
        return companyPersonnelPhone;
    }

    public void setCompanyPersonnelPhone(String companyPersonnelPhone) {
        this.companyPersonnelPhone = companyPersonnelPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getZzzh() {
        return zzzh;
    }

    public void setZzzh(String zzzh) {
        this.zzzh = zzzh;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFacePicLocal() {
        return facePicLocal;
    }

    public void setFacePicLocal(String facePicLocal) {
        this.facePicLocal = facePicLocal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTempAddressName() {
        return tempAddressName;
    }

    public void setTempAddressName(String tempAddressName) {
        this.tempAddressName = tempAddressName;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSrcParentIndex() {
        return srcParentIndex;
    }

    public void setSrcParentIndex(String srcParentIndex) {
        this.srcParentIndex = srcParentIndex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
