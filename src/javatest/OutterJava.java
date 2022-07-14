package javatest;

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

<<<<<<< HEAD:src/java/OutterJava.java
    public synchronized void testMethod() {

    }

    public void atomic() {
        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet();
    }
=======
    private int max =  Integer.MAX_VALUE;
>>>>>>> 104a8ff3bd810634a3565e75521348260b9dfbb2:src/javatest/OutterJava.java
}

