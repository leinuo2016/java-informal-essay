package com.leinuo.json.regex;

import com.google.common.base.Strings;
import com.sun.deploy.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by leinuo on 2020/2/28 下午4:45
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class RegexApp {
    public static void main(String[] args) {
        String phone = "19169373230";
        System.out.println(phoneRegex1(phone));
        phone = "18661925010";
        System.out.println(phoneRegex1(phone));
    }

    /**
     * 手机号码正则验证
     *
     * @param phone 　手机号码
     * @return true 匹配成功，false 匹配失败
     */
    public static boolean phoneRegex(String phone) {
        if (Strings.isNullOrEmpty(phone)) {
            return false;
        }
        //
        //
        String regex = "^(1)[0-9]{9}$";
        //String regex = "^(16|13|17|14|15|18|19)[0-9]{9}$";
      //  String regex = "^(13|14|15|17|18|19|16)\\d{9}$";
        //String regex = "^(166|13[0-9]|17[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|4|3|5|6|7|8|9]|19[0|1|2|3|5|6|7|8|9])\\d{8}$";
       // String regex = "^(16|13|17|14|15|18|19[0|1|2|3|5|6|7|8|9])\\d{9}$";
        return regexResult(phone, regex);
    }

    /**
     * 手机号码正则验证
     *
     * @param phone 　手机号码
     * @return true 匹配成功，false 匹配失败
     */
    public static boolean phoneRegex1(String phone) {
        if (Strings.isNullOrEmpty(phone)) {
            return false;
        }
        String regex = "^(166|13[0-9]|17[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|4|3|5|6|7|8|9]|19[0|1|2|3|5|6|7|8|9])\\d{8}$";
        return regexResult(phone, regex);
    }

    private static boolean regexResult(String parameter, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(parameter);
        return match.matches();
    }
}
