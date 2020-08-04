package com.leinuo.guava.string;

import com.google.common.collect.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Create by leinuo on 2020/3/31 上午10:38
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class MapApp {

    public static void main(String[] args) {
        testMap2();

    }

    public static void testMap(){
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        SetMultimap<String, Integer> multimap = Multimaps.forMap(map);
        System.out.println(multimap.get("a"));
        Multimap<Integer, String> inverse = Multimaps.invertFrom(multimap,HashMultimap.create());
        System.out.println(inverse.get(1));

        Map<String, String> map1 = ImmutableMap.of("a", "1", "b", "1", "c", "2");
        SetMultimap<String, String> multimap1 = Multimaps.forMap(map1);
        System.out.println(multimap1.get("a"));
        Multimap<String, String> inverse1 = Multimaps.invertFrom(multimap1,HashMultimap.create());
        System.out.println(inverse1.get("1"));
    }

    public static void testMap2(){
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3,"d",4);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 2, "c", 3,"e",5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        System.out.println( diff.entriesInCommon()); // {a=1, b=2, c=3}
        System.out.println( diff.entriesOnlyOnLeft());// {d=4}
        System.out.println( diff.entriesOnlyOnRight());// {e=5}

        Map<String, String> map1 = ImmutableMap.of("a", "1", "b", "1", "c", "2");
        System.out.println(map1.get("a"));

    }

    public static void testMap1(){
        Map<String,String> map = new LinkedHashMap<String,String>();
        map.put("11","1");
        map.put("22","2");
        map.put("33","3");
        map.put("44","4");
        map.put("11","3");
        Set<Map.Entry<String, String>> entrySet=map.entrySet();
        Iterator<Map.Entry<String, String>> iterator=entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("Maps.newLinkedHashMap()");
        map = Maps.newLinkedHashMap();
        map.put("11","1");
        map.put("22","2");
        map.put("33","3");
        map.put("44","4");
        map.put("11","3");
        entrySet=map.entrySet();
        iterator=entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

}
