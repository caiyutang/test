package com.ruoyi.project.zazl.domain;

import java.io.Serializable;
import java.util.Date;

public class Dorm implements Serializable {
    private String id;

    private String block;

    private String storey;

    private String room;

    private String roomName;

    private String createUserId;

    private String regionId;

    private String roomNameUpdate;

    private String bedNum;

    private String publicStatus;

    private Date updateTime;

    private String deleteStatus;

    private String name;

    private int count;

    private String resideType;

    private int inout;

    private int fkcount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getResideType() {
        return resideType;
    }

    public void setResideType(String resideType) {
        this.resideType = resideType;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getInout() {
        return inout;
    }

    public void setInout(int inout) {
        this.inout = inout;
    }

    public int getFkcount() {
        return fkcount;
    }

    public void setFkcount(int fkcount) {
        this.fkcount = fkcount;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(String publicStatus) {
        this.publicStatus = publicStatus;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getRoomNameUpdate() {
        return roomNameUpdate;
    }

    public void setRoomNameUpdate(String roomNameUpdate) {
        this.roomNameUpdate = roomNameUpdate;
    }

    private static final long serialVersionUID = 1L;

    public Dorm(String block, String storey, String room, String roomName, String createUserId, String regionId) {
        this.block = block;
        this.storey = storey;
        this.room = room;
        this.roomName = roomName;
        this.createUserId = createUserId;
        this.regionId = regionId;
    }

    public Dorm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStorey() {
        return storey;
    }

    public void setStorey(String storey) {
        this.storey = storey;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}
