import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by paramasivami on 3/4/16.
 */
public class URLProcess {

    private static int calcNoOfThreads(int qps, long elapsedTime) {
        if (qps <= 1) return qps;
        if (elapsedTime >= 1000) return qps;
        long remainingTime = 1000 - elapsedTime;
        int remainingQps = qps - 1;
        double oneThreadQps = Math.floor(remainingTime / elapsedTime);
        if (oneThreadQps <= 0) return qps;
        double threads = remainingQps / oneThreadQps;
        int noOfThreads = (int) Math.ceil(threads);
        if (noOfThreads >= qps) return qps;
        return noOfThreads;
    }

    private static String patterMatching() {
        String text = "http://msolrdev007iad.io.askjeeves.info:8983/V1/Contents/Questions/?gcid=92376a2d78545921&site=aqmvp";

        //positive lookbehind regex. http://www.regular-expressions.info/lookaround.html
        String patternString = "(?<=gcid=)[0-9a-fA-F]{16}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
            return matcher.group();

        return null;

    }

    private static String joinString(List<String> lists){
        Joiner joiner = Joiner.on("|").skipNulls();
        return joiner.join(lists);
    }

    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls.add("http://websearch.about.com/od/bestsitesimagegalleries/ig/July-2008-Best-Sites/USPS-Zip-Code-Lookup.htm");
        urls.add("http://banking.about.com/od/savings/a/3onlinebankacct.htm");
        urls.add("http://studenttravel.about.com/od/mattersofmoney/f/exchange_rate.htm");
        urls.add("http://forestry.about.com/od/forestfire/tp/wildfire_maps.htm");
        urls.add("http://cancer.about.com/od/pancreaticcancer/a/pancreaticsympt.htm");
        urls.add("http://usgovinfo.about.com/od/consumerawareness/a/passporthowto.htm");
        urls.add("http://childparenting.about.com/od/schoollearning/tp/math_games_online.htm");
        urls.add("http://usgovinfo.about.com/cs/healthmedical/a/womensami.htm");
        urls.add("http://cancer.about.com/od/pancreaticcancer/a/pancreaticsympt.htm");
        urls.add("http://gps.about.com/od/mobilephonegps/a/cell_phone_gps.htm");
        urls.add("http://recycling.about.com/od/Recycling/fl/Current-Scrap-Metal-Prices-2015-US.htm");
        urls.add("http://skincancer.about.com/od/symptoms/ss/mole.htm");
        urls.add("http://phoenix.about.com/od/educprim/qt/schoolstart.htm");
        urls.add("http://tires.about.com/od/buyers_guide/a/Where-To-Buy-Wheels-And-Tires-Online.htm");
        urls.add("http://cancer.about.com/od/skincancermelanoma/f/skincancersympt.htm");
        urls.add("http://usgovinfo.about.com/cs/healthmedical/a/womensami.htm");
        urls.add("http://celiacdisease.about.com/od/glutenfreefoodshopping/a/GFshoppinglist.htm");

        //System.out.println( calcNoOfThreads(1,1678));
        System.out.println(joinString(Arrays.asList("Ini", "Kumar", "Thamarai")));
        System.out.println(patterMatching());

//        int qps = 10;
//        long elapsedTime = 100;
//        int noOfThreads = 0;
//        long remainingTime = 1000 - elapsedTime;
//
//        if(elapsedTime >= 1000) noOfThreads = qps;
//        else{
//
//            noOfThreads = (int) (qps / Math.ceil(1000 / elapsedTime));
//        }
//        System.out.println(noOfThreads);
//        noOfThreads = 1;
        RateLimiter rateLimiter = RateLimiter.create(1, 10, TimeUnit.SECONDS);

        System.out.println("Calling 1");

//        for(int i = 0 ; i < 10; i++){
//            Stopwatch stopwatch = Stopwatch.createStarted();
//            System.out.println("Time spent sleeping to enforce the rate. " + rateLimiter.acquire(3));
//            processJob(noOfThreads);
//            stopwatch.stop();
//            System.out.println("Completed in " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
//
//        }

//        processJob1(noOfThreads);

    }

    private static void processJob1(int noOfThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

//        BlockingQueue<Character> queue = new ArrayBlockingQueue<Character>(10);

        Queue<Character> queue1 = new LinkedList<>();
        List<Character> clist = new ArrayList<>();
        for (Character c = 'a'; c <= 'j'; c++) {
            //queue.put(c);
            clist.add(c);
        }
        //System.out.println(queue);

        Collection<Job> collection = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            collection.add(new Job(clist.get(i)));
        }

        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            List<Future<Character>> futures = listeningExecutorService.invokeAll(collection);
            futures.forEach(
                    future -> System.out.println(future.isDone())
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            listeningExecutorService.shutdown();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void processJob(int noOfThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

//        BlockingQueue<Character> queue = new ArrayBlockingQueue<Character>(10);

        Queue<Character> queue1 = new LinkedList<>();
        List<Character> clist = new ArrayList<>();
        for (Character c = 'a'; c <= 'j'; c++) {
            //queue.put(c);
            clist.add(c);
        }
        //System.out.println(queue);

        Collection<Job> collection = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            collection.add(new Job(clist.get(i)));
        }

        for (int i = 0; i < 10; i++) {
            ListenableFuture<Character> future = null;
            future = listeningExecutorService.submit(new Job(clist.get(i)));
            Futures.addCallback(
                    future, new FutureCallback<Object>() {
                        @Override
                        public void onSuccess(Object o) {
                            if ((Character) o == 'j') {
//                                System.out.println("Process is completed. ");
//                                System.out.println(stopwatch.elapsedMillis());
                            }
                        }

                        @Override
                        public void onFailure(Throwable throwable) {

                        }
                    }
            );
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            listeningExecutorService.shutdown();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
