package com.leinuo.json.completableFuture;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Create by leinuo on 2020/2/27 上午9:17
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class User {
    private int id;
    private int age;
    private String ICcode;
    private String name;
    private Sex sex;
    private String address;
    private int jopId;
    private String jopDesc;
    private int carId;
    private String carDesc;
    private int homeId;
    private String homeDesc;

    public User(int id, String name, int jopId, int carId, int homeId) {
        this.id = id;
        this.name = name;
        this.jopId = jopId;
        this.carId = carId;
        this.homeId = homeId;
    }

    //女人
    public enum Sex{
        MAN,
        WOMAN,
        UNKNOW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getICcode() {
        return ICcode;
    }

    public void setICcode(String ICcode) {
        this.ICcode = ICcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getJopId() {
        return jopId;
    }

    public void setJopId(int jopId) {
        this.jopId = jopId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getJopDesc() {
        return jopDesc;
    }

    public void setJopDesc(String jopDesc) {
        this.jopDesc = jopDesc;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }

    public String getHomeDesc() {
        return homeDesc;
    }

    public void setHomeDesc(String homeDesc) {
        this.homeDesc = homeDesc;
    }
}
