package com.leinuo.sort.hash;

/**
 * Create by leinuo on 2020/3/3 上午9:52
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class DataItem {
    private int iData;

    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey(){
        return iData;
    }
}
