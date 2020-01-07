package com.hjc.cms.bean;

import java.io.Serializable;

/**
 * @program: cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2019-08-16 15:36
 **/

public class ParkModel implements Serializable {

    private String parkId;
    private String parkName;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public ParkModel(String parkId, String parkName) {
        this.parkId = parkId;
        this.parkName = parkName;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public ParkModel() {
    }
}
