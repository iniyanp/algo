package algo3;

/**
 * Created by paramin on 10/10/17.
 */
public class Sqrt {

    public int sqrt(int x) {
        if (x == 0)
            return 0;
        //To find a square root using binary search approach,
        //the range is from start to Integer max value.

        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.sqrt(9));
    }
}
