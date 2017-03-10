package algos;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by paramin on 1/25/17.
 */
public class MedianFinder {

        private Queue<Long> small = new PriorityQueue(),
                large = new PriorityQueue();

        public void addNum(int num) {
            large.add((long) num);
            small.add(-large.poll());
            if (large.size() < small.size())
                large.add(-small.poll());
        }

        public double findMedian() {
            return large.size() > small.size()
                    ? large.peek()
                    : (large.peek() - small.peek()) / 2.0;
        }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-5);
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }


}
