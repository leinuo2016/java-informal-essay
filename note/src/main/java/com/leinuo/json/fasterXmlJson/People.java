package com.leinuo.json.fasterXmlJson;

import java.io.Serializable;

/**
 * Create by leinuo on 2020/2/19 下午3:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class People implements Serializable {
    private String name;
    private String job;
    private String code;
    private String address;

    public People(){

    }
    public People(String name, String job, String code, String address) {
        this.name = name;
        this.job = job;
        this.code = code;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
