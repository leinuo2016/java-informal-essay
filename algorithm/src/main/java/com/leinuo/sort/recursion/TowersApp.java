package com.leinuo.sort.recursion;

/**
 * Create by leinuo on 2020/2/24 下午5:30
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 汗诺塔问题
 */
public class TowersApp {
    static int nDisks=3;

    public static void main(String[] args) {
        doTowers(6,'A','B','C');
    }

    public static void doTowers(int topN,char from,char inter,char to){
        if(topN==1){
            System.out.println("Disk 1 from "+from + " to "+to);
        }else {
            doTowers(topN-1,from,to,inter);
            System.out.println("Disk "+topN+" from "+from + " to "+to);
            doTowers(topN-1,inter,from,to);
        }
    };
}
