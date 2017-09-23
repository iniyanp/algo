package algo3;

import java.util.*;

/**
 * Created by paramin on 9/20/17.
 */
public class Intersection {


    public int[] intersection(int[] a,int[] b) {

        if(a == null || b == null) return null;

        Map<Integer,Integer> map = new HashMap<>();

        //populate first array in map with count. O(M)
        for(int no:a){
            if(map.containsKey(no)){
                map.put(no, map.get(no) + 1);
            }else{
                map.put(no,1);
            }
        }


        //O(N). So total running time would be O(M) + O(N)
        int resultSize = Math.min(a.length, b.length);
        List<Integer> result = new ArrayList<>();
        //Find intersection with second array.
        int i = 0;
        for(int no:b){

            if(map.containsKey(no)){
                i++;
                result.add(no);
                if(map.get(no) == 1) {
                    map.remove(no);
                }else{
                    map.put(no, map.get(no) - 1);
                }
            }

        }

        int resArray[] = new int[i];
        int count = 0;
        for(int elem:result){
            resArray[count++] = elem;
        }
        return resArray;



    }

    public static void main(String[] args) {

        Intersection i = new Intersection();
        //Example
        int[] first =  new int[]{1,2,3};
        int[] second =  new int[]{1,2,3,4,5};
        int[] res = i.intersection(first,second);
        for(int a:res){
            System.out.print(a);
        }

    }
}
