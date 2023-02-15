package solution.javatest;

import java.util.concurrent.atomic.AtomicInteger;

public class OutterJava {
    private void printOut() {
        System.out.println("AAA");
    }

    class InnJava {
        private void setListener(Runnable l) {
            l.run();
        }

        public void printInn() {
            setListener(new Runnable() {
                @Override
                public void run() {
                    printOut();
                }
            });
        }
    }

    public synchronized void testMethod() {

    }

    public void atomic() {
        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet();
    }
    private int max =  Integer.MAX_VALUE;
}

