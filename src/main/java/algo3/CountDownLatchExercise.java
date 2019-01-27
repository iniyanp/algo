package algo3;

/**
 * Created by paramin on 9/11/17.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch latch;
    private int time;

    public Processor(CountDownLatch latch, int time) {
        this.latch = latch;
        this.time = time;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();
    }
}


public class CountDownLatchExercise {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3); // coundown from 3 to 0

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 Threads in pool

        for(int i=0; i < 3; i++) {
            executor.submit(new Processor(latch, i * 1000)); // ref to latch. each time call new Processes latch will count down by 1
        }

        while(latch.getCount() != 0){
            System.out.println(latch.getCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            latch.await();  // wait until latch counted down to 0
            System.out.println(latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }

}
