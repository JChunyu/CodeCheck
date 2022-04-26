public class Outer {
    private int getA() {
        return 12;
    }
    class Inner {
        void print() {
            Runnable a  = new Runnable() {
                @Override
                public void run() {
                    int a = getA();
                }
            };
        }
    }
}


