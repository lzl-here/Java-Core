package lzl.com.synchronize;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        A a1 = new A();
        new Thread(()->{
            try {
                a.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                a1.b();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class A{
        public synchronized void  a() throws InterruptedException {
            System.out.println("a");
            Thread.sleep(1000);
            System.out.println("af");
        }
        public synchronized void  b() throws InterruptedException {
            System.out.println("b");
            Thread.sleep(1000);
            System.out.println("bf");
        }
    }
}
