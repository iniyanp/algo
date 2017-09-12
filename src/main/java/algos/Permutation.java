package algos;

/**
 * Created by paramasivami on 4/10/16.
 */
public class Permutation {

    public static void combine(String instr, StringBuffer outstr, int index)
    {

        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            System.out.println(outstr);

            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }
    public static void permute(String input, String output){

        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        for(int i=0; i<input.length(); i++){
            permute(input.substring(0,i) + input.substring(i+1), output.concat(String.valueOf(input.charAt(i))));
        }
    }

    public static String reverse(String s){
        if(s.length() == 0)
            return "";

        return String.valueOf(s.charAt(s.length() - 1)) + reverse(s.substring(0,s.length() - 1));

    }

    public static void main(String[] args) {
//        permute("123", new String());
//        System.out.println("#######");
//        combine("123",new StringBuffer(),0);
//        System.out.println(reverse("Iniyan"));

        printNonOverlapping("123");
    }

    public static void printNonOverlapping (String number) {
        printNonOverlapping (number, "");
    }

    public static void printNonOverlapping (String number, String prefix) {
        System.out.println (prefix + "(" + number + ")");
        for (int i=1; i<number.length(); i++) {
            String newPrefix = prefix + "(" + number.substring(0,i) + ")";
           // System.out.println(number.substring(0,i) + "\t" + number.substring (i));
            printNonOverlapping (number.substring (i), newPrefix);
        }
    }


}
