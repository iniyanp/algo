import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by paramasivami on 3/4/16.
 */
public class Job implements Callable<Character> {

    private Character c;
    Job(Character c){
        this.c = c;
    }
    @Override
    public Character call() throws Exception {
        Thread.sleep(499);
        System.out.println("Called... by " + Thread.currentThread().getName() + "Got.. " + c);
        return c;
    }
}
