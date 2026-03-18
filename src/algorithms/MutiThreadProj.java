package algorithms;

import java.util.function.IntConsumer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

/*
 * 1115. 交替打印 FooBar
 * */
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!flag) {
                    wait();
                }
                printFoo.run();
                flag = false;
                notify();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (flag) {
                    wait();
                }
                printBar.run();
                flag = true;
                notify();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }
}

/*
* 1116. 打印零与奇偶数
* */
class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }


    volatile int index = 1;
    volatile boolean isZero = true;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (isZero) {
                    printNumber.accept(0);
                    isZero = false;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (index % 2 == 0 & !isZero) {
                    printNumber.accept(index);
                    isZero = true;
                    index++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (index % 2 == 1 & !isZero) {
                    printNumber.accept(index);
                    isZero = true;
                    index++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }
}

/*
* 1117. H2O 生成
*
* 氢线程先执行，并每次执行都会增加一个氧信号量。
* 氧线程必须等待两个氢线程执行完毕，才能获取到足够的氧信号量，然后执行自己的操作。
* 氧线程执行完毕后，一次性释放两个氢信号量，使得新的氢线程可以开始执行。
* 这样就保证了两个氢线程和一个氧线程组合在一起才会被执行。
* */
class H2O {

    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygenSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogenSemaphore.release(2);
    }
}

class H2O2 {

    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;
    private CyclicBarrier barrier;

    public H2O2() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(1);
        barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                // 水分子生成后，重置信号量，允许下一轮生成
                hydrogenSemaphore.release(2);
                oxygenSemaphore.release(1);
            }
        });
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        try {
            releaseHydrogen.run();
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        try {
            releaseOxygen.run();
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
* 1195. 交替打印字符串
* */
class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    volatile int index = 1;

    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private Semaphore numberSemaphore = new Semaphore(1);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (index <= n) {
            fizzSemaphore.acquire(1);
            if (index > n) break;
            printFizz.run();
            index++;
            releaseNext();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (index <= n) {
            buzzSemaphore.acquire(1);
            if (index > n) break;
            printBuzz.run();
            index++;
            releaseNext();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (index <= n) {
            fizzBuzzSemaphore.acquire(1);
            if (index > n) break;
            printFizzBuzz.run();
            index++;
            releaseNext();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            numberSemaphore.acquire(1);
            numberSemaphore.acquire(1);

            if (index > n) break;
            printNumber.accept(index);
            index++;
            releaseNext();
        }
    }

    private void releaseNext() {
        if (index > n) {
            fizzSemaphore.release(1);
            buzzSemaphore.release(1);
            fizzBuzzSemaphore.release(1);
            numberSemaphore.release(1);
            return;
        }
        if (index % 15 == 0) {
            fizzBuzzSemaphore.release(1);
        } else if (index % 5 == 0) {
            buzzSemaphore.release(1);
        } else if (index % 3 == 0) {
            fizzSemaphore.release(1);
        } else {
            numberSemaphore.release(1);
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        IntConsumer print = System.out::println;

        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number(print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizz");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("buzz");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizzbuzz");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        numberThread.start();
        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        try {
            numberThread.join();
            fizzBuzzThread.join();
            buzzThread.join();
            fizzThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
* 1226. 哲学家进餐
* */
class DiningPhilosophers {

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork
    ) throws InterruptedException {
        
    }
}