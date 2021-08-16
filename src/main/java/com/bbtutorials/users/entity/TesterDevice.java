package com.bbtutorials.users.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class TesterDevice {

    @Id
    @Column
    private int testerID;

    @Column
    @NotNull(message="{NotNull.TesterDevice.deviceID}")
    private int deviceID;

    public TesterDevice(int testerId, int deviceId){
        this.testerID = testerId;
        this.deviceID = deviceId;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public void setTesterID(int testerID) {
        this.testerID = testerID;
    }

    public int getTesterID() {
        return testerID;
    }
}
