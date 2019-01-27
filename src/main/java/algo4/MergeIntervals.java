package algo4;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {

    //Definition for an interval.

        public class Interval {
            int start;
            int end;
            Interval() { start = 0; end = 0; }
            Interval(int s, int e) { start = s; end = e; }
            public int getStart() {
                return start;
            }
            public int getEnd() {
                return end;
            }


        }

//    public class IntervalComparator implements Comparator<Interval> {
//
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            return o1.
//        }
//    }


    public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null || intervals.size() == 0) return new LinkedList<>();

            PriorityQueue<Interval> queue = new PriorityQueue<>();

            for (int i = 0; i < intervals.size(); i++) {
                queue.add(intervals.get(i));
            }

            List<Interval> result = new LinkedList<>();


            while (!queue.isEmpty()) {
                Interval first = queue.remove();
                Interval second = queue.remove();

                if (first.end <= second.start) {
                    Interval temp = new Interval(first.start, second.end);
                    queue.add(temp);
                } else {
                    result.add(first);
                }
            }

            return result;

        }
}
