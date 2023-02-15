package solution.sync;

/*
* class 锁和对象锁不互斥。
* 但 static 方法持有的就是 class 对象。
* */
public class SynchronizedCheck {
    public static void main(String[] args) {
        SynchronizedCheck check = new SynchronizedCheck();
        Thread a = new Thread() {
            @Override
            public void run() {
                SynchronizedCheck.syncStatic();
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                synchronized (SynchronizedCheck.class) {
                    check.sync();
                }
            }
        };
        a.start();
        b.start();
    }

    static synchronized void syncStatic() {
        int a = 10;
        try {
            while (a > 0) {
                Thread.sleep(1000);
                a--;
                System.out.println("in syncStatic");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sync() {
        int a = 10;
        try {
            while (a > 0) {
                Thread.sleep(1000);
                a--;
                System.out.println("in solution.sync");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

