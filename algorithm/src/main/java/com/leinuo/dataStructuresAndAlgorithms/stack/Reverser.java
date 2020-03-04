package com.leinuo.dataStructuresAndAlgorithms.stack;

/**
 * Create by leinuo on 2020/2/7 下午5:42
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Reverser {

    private String input;

    private String output;

    public Reverser(String in){
        this.input = in;
    }

    public String doRev(){
        if(input.isEmpty()){
            return "";
        }
        StackChar stackChar = new StackChar(input.length());
        char ch;
        for (int i = 0; i <input.length() ; i++) {
            ch = input.charAt(i);
            stackChar.push(ch);
        }
        StringBuilder builder= new StringBuilder("");
        while (!stackChar.isEmpty()){
            ch =  stackChar.pop();
            builder.append(ch);
        }
        output=builder.toString();
        return output;
    }

}
