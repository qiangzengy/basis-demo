package com.qiangzengy.conllection;

import java.util.Map;

public class Test {

    public static void main(String[] args) {


        Map <Integer,String> map=new HashMap<>();
        //向指定的数据中，放元素
        /*map.put(1,"A");
        map.put(1,"B");
        map.put(17,"E");*/
        for (int i=1;i<20;i++){
            map.put(i,i+"A");
        }
        System.out.println("Map: "+map);
        String s = map.get(5);
        System.out.println("map.get(5)="+s);
    }

}
