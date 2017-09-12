package algo3;

/**
 * Created by paramin on 9/11/17.
 */
public class Test {

    public static void main(String[] args) {
        String s = new String("123");
        String s1 = new String("123");
        System.out.println(s == s1); //false
        System.out.println(s.intern() == s1.intern()); //true

    }
}
