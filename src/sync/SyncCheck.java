package sync;

public class SyncCheck {

    static int a = 0;

    public synchronized static void increaseA() {
        System.out.println("static-" + Thread.currentThread() + "->" + a);
        a++;
    }


    public synchronized void increseNormalA() {
        // 这里不是对象
        System.out.println("in method :" + this.getClass());
        a--;
        System.out.println("normal-" + Thread.currentThread() + "->" + a);
    }


    public static void main(String[] args) {
        SyncCheck ax = new SyncCheck();
        ax.test();
        // 这里的是 ax 对象
        System.out.println("in main :" + ax);
    }


    void test() {
        Thread thread1 = new Thread(() -> {
            new SyncCheck().increseNormalA();
        });
        Thread thread2 = new Thread(() -> {
            // 这里的是 ax 对象
            synchronized (this) {
                SyncCheck.increaseA();
                System.out.println("in synchronized :" + this.toString());
            }
        });
        thread1.start();
        thread2.start();
    }
}
