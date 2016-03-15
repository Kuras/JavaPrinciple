/**
 * Created by pkura on 2016-03-15.
 */
public class DeadLock {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Total is: " + b.c.total);
        }
    }
    static class ThreadB extends Thread{
        int total;
        public ThreadC c;
        public ThreadB(){
            c = new ThreadC(this);
        }
        @Override
        public void run(){
            c.start();
            synchronized(c){
                try {
                    System.out.println("Waiting for c to complete...");
                    c.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }
    }
    static class ThreadC extends Thread{
        int total;
        public ThreadB b;
        public ThreadC (ThreadB b1){
            b = b1;
        }
        @Override
        public void run(){
            System.out.println("Completing c...");
            synchronized(b){
                try {
                    System.out.println("Waiting for b to complete...");
                    this.b.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0; i<100 ; i++){
                    total += i;
                }
                System.out.println("Complete c...");
                notifyAll();
            }
        }
    }
}
