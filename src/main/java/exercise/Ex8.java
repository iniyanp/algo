package exercise;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * Created by iniyan.paramasivam on 10/17/18.
 *
 * Given nos, (1,2,3) , generate all the possible nos with the same length.
 * (Repetition allowed)
 *
 */
public class Ex8 {


    public static Set<String> resultSet = new HashSet<>();

    public static void generateNo(String no, String result, int totalLength, int appendNo){

        if(result.length() > totalLength) return;

        if(result.length() == totalLength && !resultSet.contains(result)){
            resultSet.add(result);
            return;
        }
        result = result + appendNo;
        generateNo(no,result, totalLength, 1);
        generateNo(no,result, totalLength, 2);
        generateNo(no,result, totalLength, 3);
    }




    public static void main(String[] args) {
        String no = "123";
        for(int i=0; i < no.length(); i++)
            generateNo("123","", 3, Integer.parseInt(no.charAt(i)+""));
        System.out.println(resultSet);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(1);
        System.out.println(queue.size());
        Random r = new Random();
        int max = 2;
        int min = 1;

        System.out.println(r.nextInt(max - min + 1)+ min);

    }
}
