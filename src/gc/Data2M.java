package gc;

/*
* 测试 JVM 的垃圾回收算法 是否能够处理循环引用。
* */
public class Data2M {
    public Object instance = null;
    private byte[] data = new byte[2 * 1024 * 1024]; // 2m 占用内存
}

class ReferenceGC {
    public static void main(String[] args) {
        Data2M d1 = new Data2M();
        Data2M d2 = new Data2M();
        d1.instance = d2;
        d2.instance = d1;
        d1 = null;
        d2 = null;
        System.gc();
    }
}
