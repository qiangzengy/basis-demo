package com.qiangzengy.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class T_AtomicInteger extends Thread {


    /**
     * CAS（乐观锁）：取值，设置新的值，比较开始取的值与内存里的值是否一样，一样，修改
     * ABA问题：解决方案，加version字段，即加版本号
     * CAS怎么保证原子性的？汇编语言，LOCK_IF_MP(%4)此指令，判断是否是多核cpu，多核cpu需要加lock,锁住总线，
     * （为什么锁住总线？，不允许当前cpu在操作数据时，被其他cpu打断）
     * <p>
     * 最终实现：cmpxchg =cas 修改变量的值，lock cmpxchg 指令
     * (lock 指令在执行后面指令时锁定的是一个北桥信号，不采用锁住总线的方式)
     * <p>
     * 在Pentium及之前的处理器中，带有lock前缀的指令在执行期间会锁住总线，
     * 使得其它处理器暂时无法通过总线访问内存，很显然，这个开销很大。
     * 在新的处理器中，Intel使用缓存锁定来保证指令执行的原子性，
     * 缓存锁定将大大降低lock前缀指令的执行开销。
     * <p>
     * AtomicInteger是如何实现线程安全的？
     * 它采用了CAS操作。
     * <p>
     * 偏向锁（贴标签） ：只有一个线程的时候，就不需要抢锁
     * 偏向锁为什么有延时？
     * JVM启动是一个多线程竞争，开偏向锁没有意义，偏向锁有一个升级过程，
     * 需要进行锁撤销，消耗资源，所以这里设置4s延迟T_AtomicInteger
*/
    AtomicInteger count = new AtomicInteger(0);

    //此处加synchronized 相当与synchronized(this)
    //此处加static synchronized 相当与synchronized(T_AtomicInteger.class)

    /**
     * synchronized jdk1.0-1.2 重量级锁(经过操作系统os的协调和帮助)
     */

    /* synchronized */ void count() {
        for (int i = 0; i < 10000; i++) {

            count.incrementAndGet();//count++
            System.out.println(count);
        }
        System.out.println("name_id" + Thread.currentThread().getId());

    }

    public static void main(String[] args) {

        T_AtomicInteger t = new T_AtomicInteger();

        List<Thread> list = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            list.add(new Thread(
                    t::count, "thread-" + j
            ));

        }
        list.forEach(o -> o.start());

    }

}
