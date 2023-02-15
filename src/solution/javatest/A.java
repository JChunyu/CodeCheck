package solution.javatest;

public class A {

    int a = 100;
    int b = 100;

    String java1 = "java";
    String java2 = "java";
    String java3 = new String("java");
    String java4 = new String("java");


    void print() {
        String java5 = new String("java");
        System.out.println(java1 == java2);
        System.out.println(java1 == java5);
        System.out.println(java2 == java3);
        System.out.println(java3 == java4);
        System.out.println(java1.equals(java4));
    }

    void compare() {
        int c = 100;
        System.out.println(a == b);
        System.out.println(a == c);

        System.out.println(java1 == java2);
        System.out.println(java1.equals(java1));

    }

    void log(int no, String content) {
        System.out.println(no + content);
    }



    public static void main(String[] args) {
        new A().print();
    }
}

