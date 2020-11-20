package algo3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {


    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int count = 1;
        queue.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                count++;

            } else {
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }

    public static void main(String[] args) {
        MeetingRoom m = new MeetingRoom();
        System.out.println("In main");
        Interval i[] = new Interval[3];
        i[0] = m.new Interval(1, 100);
        i[1] = m.new Interval(2, 8);
        i[2] = m.new Interval(6, 7);
        System.out.println(m.minMeetingRooms(i));
    }
}
