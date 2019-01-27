/**
 * Created by iniyan.paramasivam on 10/18/18.
 */
public class MinWindow {
    static int[] map = new int[128];

    public static  void minWindow(String s, String t){
        for(char c:t.toCharArray()){
            int cInt = c - 97;
            map[cInt]++;
        }
        int counter=t.length(), begin=0, end=0, d=Integer.MAX_VALUE, head=0;

        while(end < s.length()){
            char c1 = s.charAt(end++);
            int pos = c1  - 97;
            if(map[pos]-- >0) counter--;
            while(counter==0){ //valid
                if(end-begin<d){
                    d = end-begin;
                    head = begin;
                }
                char c = s.charAt(begin++);
                int pos1 = c - 97;
                int res = map[pos1]++;
                if(res == 0) counter++;  //make it invalid
            }
        }
        System.out.println( d==Integer.MAX_VALUE? "":s.substring(head, head+d));

    }

    public static void main(String[] args) {
        System.out.println("Iniyan");
        minWindow("ABHJGCDGBANC".toLowerCase(),"ABC".toLowerCase());
    }
}
