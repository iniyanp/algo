package algos;

/**
 * Created by paramin on 9/1/17.
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //Palindrome May be centered around 1 character.
            int len2 = expandAroundCenter(s, i, i + 1); //Palindrome may be centered around 2 characters.
            //System.out.println(len1 + "\t" + len2);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println(start + "\t" + end);
            }

        }
        return s.substring(start, end + 1);
    }

    private static  int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }
}
