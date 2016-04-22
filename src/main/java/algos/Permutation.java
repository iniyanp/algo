package algos;

/**
 * Created by paramasivami on 4/10/16.
 */
public class Permutation {

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
        permute("123", new String());
        System.out.println(reverse("Iniyan"));
    }


}
