package javatest;

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

    private int max =  Integer.MAX_VALUE;
}

