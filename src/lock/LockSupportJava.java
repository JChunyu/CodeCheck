package lock;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class LockSupportJava {

    Object obj = new Object();

    public static void main(String[] args) {
        LockSupportJava lock = new LockSupportJava();
        lock.parkAndUnpark();
    }

    void waitAndNotify() {
        Thread thread1 = new Thread(() -> {
            synchronized(obj) {
                try {
                    System.out.println("thread1 start + " + new Date(System.currentTimeMillis()));
                    Thread.sleep(1000);
                    obj.notify();
                    System.out.println("thread1 end + " + new Date(System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized(obj) {
                try {
                    thread1.start();
                    Thread.sleep(3000);
                    System.out.println("thread2 start + " + new Date(System.currentTimeMillis()));
                    obj.wait();
                    System.out.println("thread2 end + " + new Date(System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }

    Thread thread;

    void parkAndUnpark() {
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 start + " + new Date(System.currentTimeMillis()));
            thread.start();
            System.out.println("thread2 current thread before" + Thread.currentThread());
            LockSupport.park(obj);
            System.out.println("thread2 current thread after" + Thread.currentThread());
            System.out.println("Blocker info " + LockSupport.getBlocker(Thread.currentThread()));
            System.out.println("thread2 end + " + new Date(System.currentTimeMillis()));
        });
        // 唤起 thread2
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("thread1 start + " + new Date(System.currentTimeMillis()));
                Thread.sleep(3000);
                System.out.println("Blocker info " + LockSupport.getBlocker(thread2));
                LockSupport.unpark(thread2);
                System.out.println("thread1 end + " + new Date(System.currentTimeMillis()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread = thread1;
        thread2.start();
    }
}
