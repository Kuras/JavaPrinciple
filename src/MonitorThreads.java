/**
 * Created by pkura on 2016-03-11.
 */
// Czym jest monitor???
public class MonitorThreads {
//    The basic idea of synchronization
//    Synchronizacja wątków, czym jest monitor (czyli polecenie synchronize)?
//    monitor -> monitors the threads' access to the java block

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b){ // b is synchronized       // monitor
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
                        // b completes the calculation
            System.out.println("Total is: " + b.total);
        }                                           // monitor
    }
    static class ThreadB extends Thread{
        int total;
        @Override
        public void run(){
            synchronized(this){ // monitor
                for(int i=0; i<100 ; i++){
                    total += i;
                }
                notify();
            }                   // monitor
        }
    }
    // What is the difference betwen Process and Threads
    // A process runs independently and isolated of other processes

    // A thread can access shared data of other threads in the same process
//    deadlock
}
