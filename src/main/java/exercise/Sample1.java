package exercise;

import java.util.*;

/**
 * Created by paramin on 9/16/17.
 */
public class Sample1 {

    public static void main(String[] args) {
        System.out.println("Iniyan");

        Sample1 s = new Sample1();

        List<List<Integer>> p = new ArrayList<>();

        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        inner.add(-3);
        p.add(0,inner);

        List<Integer> inner1 = new ArrayList<>();
        inner1.add(1);
        inner1.add(2);
        p.add(1,inner1);

        List<Integer> inner2 = new ArrayList<>();
        inner2.add(3);
        inner2.add(4);
        p.add(2,inner2);


        s.closestLocations(3,p,1);
    }


    class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            if(p1.distance < p2.distance) return -1;
            else if(p1.distance > p2.distance) return  1;
            else return 0;
        }
    }

     class Point{

        List<Integer> location;
        double distance;

        Point(List<Integer> location, double distance){
            this.location = location;
            this.distance = distance;
        }
    }

    public  double calcDistance(Integer x, Integer y) {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public  List<List<Integer>> closestLocations(int totalCrates,
                                         List<List<Integer>> allLocations,
                                         int truckCapacity)
    {
        Queue<Point> queue = new PriorityQueue<Point>(new PointComparator());
        List<List<Integer>> result = new ArrayList<>();

        if(totalCrates <= 0) return new ArrayList<>();

        else {

            for(int i=0;i<allLocations.size();i++) {

                List<Integer> location = allLocations.get(i);
                Point p = new Point(allLocations.get(i),calcDistance(location.get(0),location.get(1)));
                queue.add(p);
            }

            for(int i=0;i<truckCapacity;i++){
                List<Integer> innerList = new ArrayList<>();
                Point p = queue.remove();
                result.add(p.location);
            }
        }

        return result;



    }
}
