package threads;

public class Main {

    public static void main(String[] args) {
        String s="";
        Object object=new Object();
        Counter counter=new Counter();
        Thread t1=new Thread(()->{
            for (int i = 0; i <1000000 ; i++) {
                synchronized (object) {
                    counter.incr();
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i <1000000 ; i++) {
                synchronized (object) {
                    counter.decr();
                }

            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getc());
    }
}
