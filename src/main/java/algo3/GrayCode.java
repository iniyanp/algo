package algo3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by paramin on 9/30/17.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            int elem = i ^ i>>1;
            result.add(elem);
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode g = new GrayCode();
        System.out.println(g.grayCode(3));
    }
}
