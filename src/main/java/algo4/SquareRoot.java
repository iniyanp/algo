package algo4;

public class SquareRoot {
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                //nearest integer.
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        SquareRoot s = new SquareRoot();
        int ans = s.sqrt(6);
        System.out.println(ans);
    }
}
