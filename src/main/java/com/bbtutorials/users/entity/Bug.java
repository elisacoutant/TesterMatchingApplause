package com.bbtutorials.users.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "bugs")
public class Bug {

    @Id
    @Column(name = "bugId")
    private int bugId;

    @Column(name = "deviceId")
    private int deviceId;

    @Column(name = "testerId")
    private int testerId;

    public Bug(int bugId, int deviceId, int testerId) {
        this.bugId = bugId;
        this.deviceId = deviceId;
        this.testerId = testerId;


    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getTesterId() {
        return testerId;
    }

    public void setTesterId(int testerId) {
        this.testerId = testerId;
    }


    @Override
    public String toString() {
        return "Bug [id=" + bugId + ", deviceId=" + deviceId + ", testerId=" + testerId +"]";
    }
}
