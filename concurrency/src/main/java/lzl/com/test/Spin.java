package lzl.com.test;

public class Spin {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程结束");
        });
        thread.setDaemon(true);
        thread.start();
    }

}
