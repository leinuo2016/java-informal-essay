package com.leinuo.json.completableFuture;

import java.util.PrimitiveIterator;
import java.util.function.Supplier;

/**
 * Create by leinuo on 2020/2/27 上午9:18
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class UserQuerySupplier implements Supplier<String> {
    private int id;
    private String type;
    private UserQueryUtils userQueryUtils;

    public UserQuerySupplier(int id, String type, UserQueryUtils userQueryUtils) {
        this.id = id;
        this.type = type;
        this.userQueryUtils = userQueryUtils;
    }

    @Override
    public String get() {
        if("hemo".equals(type)){
            return userQueryUtils.queryHome(id);
        }else if("jop".equals(type)){
            return userQueryUtils.queryJop(id);
        }else if("car".equals(type)){
            return userQueryUtils.queryCar(id);
        }
        return null;
    }
}
