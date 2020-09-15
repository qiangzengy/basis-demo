package com.qiangzengy.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cat [] arr={new Cat(3,3),new Cat(5,5),new Cat(1,1)};
        // Dog [] arr={new Dog(3),new Dog(7),new Dog(9)};
        Sorter <Cat>sorter=new Sorter<>();
        // sorter.sort(arr,new CatCompareTo());
        // 下面是用lambda表达式实现
        sorter.sort(arr,(o1,o2) -> {
            if (o1.getHeight()<o2.getHeight())return -1;
            if (o1.getHeight()<o2.getHeight())return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(arr));

    }

}
