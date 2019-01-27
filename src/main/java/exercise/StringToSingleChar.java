package exercise;

import java.util.ArrayList;
import java.util.List;

public class StringToSingleChar {


    public static void main(String[] args) {

        StringToSingleChar t = new StringToSingleChar("ABACB");
        System.out.println(t.pathLen());

    }

    List<Character> str;

    public StringToSingleChar(String s) {

        str = new ArrayList<>();

        for(char c: s.toCharArray()) {

            str.add(c);
        }

    }

    public int pathLen() {

        if(str.size() == 0) return -1;

        if(str.size() == 1) return 0;

        if(invalidToConvert()) return -1;

        for(int i = 0; i < str.size() - 1; i++) {

            char curr = str.get(i), next = str.get(i + 1);

            if(curr != next) {

                //backtracking, try to convert any two adjacent chars in str
                str.set(i, convert(curr, next));
                str.remove(i + 1);

                int steps = pathLen();

                if(steps >= 0) return steps + 1;

                //recover the str after the recursive calls
                str.set(i, curr);
                str.add(i + 1, next);

            }

        }

        return -1;

    }

    //check if given string is invalid like "AAAAA..." or "BBBBB..." or "CCCCC..."
    private boolean invalidToConvert() {

        for(int i = 0; i < str.size() - 1; i++) {

            if(str.get(i) != str.get(i + 1)) return false;

        }

        return true;

    }

    private char convert(char a, char b) {

        if(a != 'C' && b != 'C') return 'C';

        if(a != 'B' && b != 'B') return 'B';

        return 'A';

    }

}
