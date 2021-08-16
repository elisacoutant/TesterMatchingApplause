package com.bbtutorials.users.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "devices")
public class Device {

    @Id
    @Column(name = "deviceId")
    private int deviceId;

    @Column(name = "description")
    private String description;



    public Device(int deviceId, String description) {
        this.deviceId = deviceId;
        this.description = description;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Device [id=" + deviceId + ", deviceId=" + deviceId + ", description=" + description +"]";
    }
}
