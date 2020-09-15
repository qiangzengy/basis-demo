package com.qiangzengy.strategy;

import java.util.Comparator;

public class Sorter <T>{

    public void sort(T [] a, Comparator <T> c){
        for (int i=0;i<a.length;i++){
            int min=i;

            for (int j=i+1;j<a.length;j++){
                //min=a[j]<a[min]?j:min;
                //min=a[j].compareTo(a[min])==-1?j:min;
                min=c.compare(a[j],a[min])==-1?j:min;
            }
            swap(a,i,min);
        }
    }

     void swap(T [] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}
