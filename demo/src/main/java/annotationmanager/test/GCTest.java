package annotationmanager.test;

public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        allocation1 = new byte[15 * 1000 * 1024];
        allocation2 = new byte[60 * 1000 * 1024];
        allocation3 = new byte[60 * 1000 * 1024];
        allocation4 = new byte[760 * 1000 * 1024];//大对象容易被移到老年代，在新生代存活达到阈值的也会被移到老年代
    }
}
