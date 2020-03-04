package com.leinuo.dataStructuresAndAlgorithms.advancedSort.quickSort;

/**
 * Create by leinuo on 2020/2/27 上午11:58
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class QuickSortApp {

    public static void main(String[] args) {
        int maxSize = 9;
        ArrayPar arrayPar = new ArrayPar(maxSize);
        int i;
        for (int j = 0; j < maxSize; j++) {
            i = (int)(Math.random()*999999);
            arrayPar.insert(i);
        }
        //arrayPar.display();
        int piovt = 99;
        int size = arrayPar.size();
        int partDex = arrayPar.partitionIt(0,size-1,piovt);
        System.out.printf("partDex=%d,value=%s%n", partDex, arrayPar.get(partDex));
        //arrayPar.display();
        Long times = System.currentTimeMillis();
        arrayPar.quickSort();
        System.out.println("times="+ (System.currentTimeMillis()-times));
        //arrayPar.display();

        System.out.println("-------medianOf3-------");
        ArrayPar2 arrayPar2 = new ArrayPar2(maxSize);
        for (int j = 0; j < maxSize; j++) {
            i = (int)(Math.random()*999999);
            arrayPar2.insert(i);
        }
        //arrayPar2.display();
        times = System.currentTimeMillis();
        arrayPar2.quickSort();
        System.out.println("times="+ (System.currentTimeMillis()-times));
       // arrayPar2.display();


        ArrayPar3 arrayPar3= new ArrayPar3(maxSize);
        for (int j = 0; j < maxSize; j++) {
            i = (int)(Math.random()*999999);
            arrayPar3.insert(i);
        }
        arrayPar3.quickSort();
        arrayPar3.display();
    }
}
