package com.leinuo.json.fasterXmlJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.Objects;

/**
 * Create by leinuo on 2020/2/19 下午3:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class FasterxmlJsonUtilApp {

    public static void main(String[] args) throws JsonProcessingException {
        People people = new People("Tom","coder","007","xining");

        JSONPObject jsonpObject = FasterxmlJsonUtil.objectToJson(people);

        System.out.println(jsonpObject.toString());

        people = FasterxmlJsonUtil.jsonToBean("{\"name\":\"davenkin\",\"address\":\"\"}", People.class);

        System.out.println(people.getName());

        Object object = FasterxmlJsonUtil.jsonToBean("{\"name\":\"davenkin\",\"address\":\"\"}");

        System.out.println(object.toString());

        String jsonStr = "{\"name\":\"Tom\",\"job\":\"coder\",\"code\":\"007\",\"address\":\"xining\"}";
        //"{"name":"Tom","job":"coder","code":"007","address":"xining"}"

        people = FasterxmlJsonUtil.jsonToBean(jsonStr,People.class);

        System.out.println(people.getName());
    }
}
