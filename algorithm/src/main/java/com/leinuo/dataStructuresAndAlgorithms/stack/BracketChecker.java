package com.leinuo.dataStructuresAndAlgorithms.stack;

/**
 * Create by leinuo on 2020/2/7 下午7:59
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class BracketChecker {

    private String input;

    private String output;

    public BracketChecker(String in){
        this.input = in;
    }

    public void check(){
        if(input.isEmpty()){
            return;
        }
        StackChar stackChar = new StackChar(input.length());
        char ch;
        for (int i = 0; i <input.length() ; i++) {
            ch = input.charAt(i);
            switch (ch){
                case '{':
                case '(':
                case '[':
                case '<':
                    stackChar.push(ch);
                    break;
                case '}':
                case ')':
                case ']':
                case '>':
                    if(!stackChar.isEmpty()) {
                        char ch1 = stackChar.pop();
                        if (ch1 == '{' && ch != '}' || ch1 == '(' && ch != ')' || ch1 == '[' && ch != ']' || ch1 == '<' && ch != '>') {
                            System.out.println(String.format("第%s个字符匹配错误!", i));
                        }
                    }else {
                        System.out.println(String.format("第%s个字符匹配错误!", i));
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
