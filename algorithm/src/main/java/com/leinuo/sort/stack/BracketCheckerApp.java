package com.leinuo.sort.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create by leinuo on 2020/2/7 下午6:00
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class BracketCheckerApp {

    public static void main(String[] args) throws IOException {
        String input;
        while (true){
            System.out.println("请输入字符串：");
            System.out.flush();
            input = getString();
            BracketChecker bracketChecker = new BracketChecker(input);
            bracketChecker.check();
        }
    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
