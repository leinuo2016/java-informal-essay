package com.leinuo.json.fasterXmlJson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.base.Strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by leinuo on 2020/2/19 下午2:23
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class FasterxmlJsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json字符串转对象
     * 对象必须要有无参构造，否则转换失败
     */
    public static <T> T jsonToBean(String jsonStr,Class<T> bean) {
        try {
            return objectMapper.readValue(jsonStr,bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串转对象
     */
    public static Object jsonToBean(String jsonStr) {
        try {
            return Strings.isNullOrEmpty(jsonStr)?null:objectMapper.readValue(jsonStr,Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json集合转对象集合
     * @param jsonStr
     * @param c
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public static <T> List<T> jsonToObjectList(String jsonStr, Class<T> c){
        if (Strings.isNullOrEmpty(jsonStr)) {
            return null;
        } else {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, c);
            try {
                return  (List<T>) objectMapper.readValue(jsonStr, javaType);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * Json字符串转List<String>集合
     * @param jsonStr
     * @return
     * @throws JsonParseException
     */
    public static List<String> jsonToList(String jsonStr){
        return jsonToObjectList(jsonStr, String.class);
    }

    /**
     * 对象转json
     */
    public static JSONPObject objectToJson(Object object){
        try {
            JSONPObject jsonpObject = new JSONPObject(objectMapper.writeValueAsString(object),object);
            return jsonpObject;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
