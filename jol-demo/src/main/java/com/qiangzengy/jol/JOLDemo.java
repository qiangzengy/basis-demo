package com.qiangzengy.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 一个Object占多少个字节？
 * 包括：（markword+class pointer构成了一个对象头)
 * 标记字(markword) 8个字节
 * 类指针(class pointer)，这个对象是属于哪个类的，比如new Object(),这个对象就是属于Object，指针就指向Object。 4个字节
 * 实例数据(instance data)，指的是成员变量，没有就是0个字节，如果是int就是4个字节
 * 对齐(padding)（64位操作系统，8字节对齐，就是需要被8整除，不被8整除，例如12（markword+class pointer+instance data）需要加4(对齐)才能被8整除）
 */


public class JOLDemo {

    /**
     * Object 布局
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {


        /** 偏向锁（贴标签） ：只有一个线程的时候，就不需要抢锁
         偏向锁为什么有延时？
         JVM启动是一个多线程竞争，开偏向锁没有意义，偏向锁有一个升级过程，需要进行锁撤销，消耗资源，所以这里设置4s延迟T_AtomicInteger
         */
        //Thread.sleep(5000); // 此处睡5s，可以看到偏向锁,偏向锁有一个时延，默认是4s


        Object o = new Object();
        // parseInstance(o)解析一个对象
        // toPrintable() 转成可打印的字符串
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);


        /**
         * 运行可以看到VALUE这部分发生了变化，就第一列和第二列发生了变化，也就是(第一列+第二列=maskword)maskword发生了变化
         *
         * VALUE
         * 01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         * 00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         * e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
         * VALUE
         * c8 f8 4b 09 (11001000 11111000 01001011 00001001) (155973832)
         * 00 70 00 00 (00000000 01110000 00000000 00000000) (28672)
         * e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
         */


        /**
         * 在Hotspot里面，synchronized锁的实现的过程和锁升级的过程，
         * 可以通过观察maskword的变化体现出来，
         * 001 是无锁态
         * 101 是偏向锁
         *  00 是轻量级锁
         *  10 是重量级锁
         *  11 gc标记信息
         *  详细见语雀)
         *
         *
         *  java -XX:+PrintFlagsFinal | wc -l
         */

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());

        }

    }
}
