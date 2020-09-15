package com.qiangzengy.strategy;

//public class Cat implements Comparable<Cat> {
public class Cat {

    private int weight;
    private int height;

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    /*public int compareTo(Cat c) {
        if (this.weight<c.weight)return -1;
        else if (this.weight>c.weight)return 1;
        else return 0;
    }*/

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
