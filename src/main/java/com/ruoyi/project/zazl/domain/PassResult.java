package com.ruoyi.project.zazl.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PassResult implements Serializable {
    private String resultId;

    private String personId;

    private String personName;

    private Object departId;

    private String departName;

    private String groupCode;

    private String shiftCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onDutyDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date clockOnTime;

    private BigDecimal onStatus;

    private String acReaderNameOn;

    private String doorNameOn;

    private String controllerNameOn;

    private BigDecimal minuteLate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date offTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date clockOffTime;

    private BigDecimal offStatus;

    private String acReaderNameOff;

    private String doorNameOff;

    private String controllerNameOff;

    private String cardNoOff;

    private BigDecimal minlEave;

    private BigDecimal minCompLeave;

    private BigDecimal minOverTime;

    private BigDecimal minAttend;

    private BigDecimal timeAll;

    private BigDecimal lessTime;

    private BigDecimal minuteEarly;

    private String regionId;

    private String resultType;

    private String status;

    private String remark;

    private BigDecimal onStatusBak;

    private BigDecimal offStatusBak;

    public BigDecimal getOnStatusBak() {
        return onStatusBak;
    }

    public void setOnStatusBak(BigDecimal onStatusBak) {
        this.onStatusBak = onStatusBak;
    }

    public BigDecimal getOffStatusBak() {
        return offStatusBak;
    }

    public void setOffStatusBak(BigDecimal offStatusBak) {
        this.offStatusBak = offStatusBak;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    private static final long serialVersionUID = 1L;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
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

    public Object getDepartId() {
        return departId;
    }

    public void setDepartId(Object departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getShiftCode() {
        return shiftCode;
    }

    public void setShiftCode(String shiftCode) {
        this.shiftCode = shiftCode;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public Date getClockOnTime() {
        return clockOnTime;
    }

    public void setClockOnTime(Date clockOnTime) {
        this.clockOnTime = clockOnTime;
    }

    public BigDecimal getOnStatus() {
        return onStatus;
    }

    public void setOnStatus(BigDecimal onStatus) {
        this.onStatus = onStatus;
    }

    public String getAcReaderNameOn() {
        return acReaderNameOn;
    }

    public void setAcReaderNameOn(String acReaderNameOn) {
        this.acReaderNameOn = acReaderNameOn;
    }

    public String getDoorNameOn() {
        return doorNameOn;
    }

    public void setDoorNameOn(String doorNameOn) {
        this.doorNameOn = doorNameOn;
    }

    public String getControllerNameOn() {
        return controllerNameOn;
    }

    public void setControllerNameOn(String controllerNameOn) {
        this.controllerNameOn = controllerNameOn;
    }

    public BigDecimal getMinuteLate() {
        return minuteLate;
    }

    public void setMinuteLate(BigDecimal minuteLate) {
        this.minuteLate = minuteLate;
    }

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }

    public Date getClockOffTime() {
        return clockOffTime;
    }

    public void setClockOffTime(Date clockOffTime) {
        this.clockOffTime = clockOffTime;
    }

    public BigDecimal getOffStatus() {
        return offStatus;
    }

    public void setOffStatus(BigDecimal offStatus) {
        this.offStatus = offStatus;
    }

    public String getAcReaderNameOff() {
        return acReaderNameOff;
    }

    public void setAcReaderNameOff(String acReaderNameOff) {
        this.acReaderNameOff = acReaderNameOff;
    }

    public String getDoorNameOff() {
        return doorNameOff;
    }

    public void setDoorNameOff(String doorNameOff) {
        this.doorNameOff = doorNameOff;
    }

    public String getControllerNameOff() {
        return controllerNameOff;
    }

    public void setControllerNameOff(String controllerNameOff) {
        this.controllerNameOff = controllerNameOff;
    }

    public String getCardNoOff() {
        return cardNoOff;
    }

    public void setCardNoOff(String cardNoOff) {
        this.cardNoOff = cardNoOff;
    }

    public BigDecimal getMinlEave() {
        return minlEave;
    }

    public void setMinlEave(BigDecimal minlEave) {
        this.minlEave = minlEave;
    }

    public BigDecimal getMinCompLeave() {
        return minCompLeave;
    }

    public void setMinCompLeave(BigDecimal minCompLeave) {
        this.minCompLeave = minCompLeave;
    }

    public BigDecimal getMinOverTime() {
        return minOverTime;
    }

    public void setMinOverTime(BigDecimal minOverTime) {
        this.minOverTime = minOverTime;
    }

    public BigDecimal getMinAttend() {
        return minAttend;
    }

    public void setMinAttend(BigDecimal minAttend) {
        this.minAttend = minAttend;
    }

    public BigDecimal getTimeAll() {
        return timeAll;
    }

    public void setTimeAll(BigDecimal timeAll) {
        this.timeAll = timeAll;
    }

    public BigDecimal getLessTime() {
        return lessTime;
    }

    public void setLessTime(BigDecimal lessTime) {
        this.lessTime = lessTime;
    }

    public BigDecimal getMinuteEarly() {
        return minuteEarly;
    }

    public void setMinuteEarly(BigDecimal minuteEarly) {
        this.minuteEarly = minuteEarly;
    }
}
