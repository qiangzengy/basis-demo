package com.qiangzengy.strategy;

import java.util.Comparator;

public class CatCompareTo implements Comparator<Cat> {

    public int compare(Cat o1, Cat o2) {
        if (o1.getHeight()<o2.getHeight())return -1;
        if (o1.getHeight()<o2.getHeight())return 1;
        else return 0;
    }
}
