package mzhang.testing;

/**
 * Created by zteam on 2/10/2017.
 */
public class test {
    public static void main(String[] args) {
        String a = "123";

//        System.out.println(a.equals("123"));

        Runnable r1 = () -> {
                                synchronized (a) {
                                    try {
                                        Thread.sleep(100000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    System.out.println("r1 ran!");
                                }
                            };
        new Thread(r1).start();

        r1 = () -> {
                        synchronized (a) {
                            try {
                                Thread.sleep(100000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println("r2 ran!");
                        }
        };

        new Thread(r1).start();
    }
}
