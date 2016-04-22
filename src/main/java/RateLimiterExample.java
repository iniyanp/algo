import com.google.common.util.concurrent.RateLimiter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by paramasivami on 3/10/16.
 */
public class RateLimiterExample {
    static long start;
    static AtomicInteger doneCounter = new AtomicInteger(0);
    static int joblimit = 30;
    static int TPS = 10;

    static class Sample implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            System.out.println("doing by " + Thread.currentThread().getName() + sdf.format(new Date()));
            int index = doneCounter.incrementAndGet();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index == joblimit) {
                System.out.println(joblimit + " job is completed in " +
                        (System.currentTimeMillis() - start) + " msec with " + TPS + " tps");
            }
            return null;
    }

}

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(TPS);

        ExecutorService executorService = Executors.newCachedThreadPool();//newFixedThreadPool(10);
        start = System.currentTimeMillis();

        for (int i = 0; i < joblimit; i++) {
            rateLimiter.acquire(); // may wait

//            executorService.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//                    System.out.println("doing by " + Thread.currentThread().getName() + sdf.format(new Date()));
//                    int index = doneCounter.incrementAndGet();
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if (index == joblimit){
//                        System.out.println(joblimit + " job is completed in " +
//                                (System.currentTimeMillis() - start) + " msec with " + TPS + " tps");
//                    }
//                }
//            });
            Collection<Sample> collection = new LinkedList<>();
            collection.add(new Sample());
            try {
                executorService.invokeAll(
                        collection
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
