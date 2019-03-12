package exercise;

import java.util.LinkedList;
import java.util.List;

public class Poison {
    class MyList{
        List<Integer> list;
        boolean isDelete;
        MyList(List<Integer> list){
            this.list = list;
            isDelete = false;
        }
    }

    public void traverseList(List<MyList> finalResult) {
        for(int i=0;i<finalResult.size();i++){
            for(int k = 0;k < finalResult.get(i).list.size(); k++){
                System.out.print(finalResult.get(i).list.get(k) + "\t");
            }
            System.out.println();
        }
    }

    public List<MyList> populateList(int[] arr) {
        List<MyList> finalResult = new LinkedList<>();

        //List formation.
        int j = 0;

        List<Integer> temp = new LinkedList<>();
        temp.add(arr[0]);
        MyList m = new MyList(temp);
        finalResult.add(m);

        for(int i=1;i<arr.length;i++){

            MyList lastList = finalResult.get(finalResult.size() - 1);
            int lastElement = lastList.list.get(lastList.list.size() - 1);
            if(arr[i] <= lastElement){
                lastList.list.add(arr[i]);
            }else{
                List<Integer> temp1 = new LinkedList<>();
                temp1.add(arr[i]);
                finalResult.add(new MyList(temp1));
            }
        }
        return finalResult;
    }

    public void findAnswer(List<MyList> finalResult) {
        //Let's use addAll. and see
        int count = 0;
        boolean reached = false;

        while(finalResult.size() != 1){
            for(int i=0; i <finalResult.size() - 1; i++){

                MyList firstMyList = finalResult.get(i);
                MyList secondMyList = finalResult.get(i+1);
                int firstElement = firstMyList.list.get(firstMyList.list.size() - 1);
                int secondElement = secondMyList.list.get(0);

                    if(firstElement < secondElement){
                        //delete the secondElement.
                        //If the size is one. just set the flag.
                        if(secondMyList.list.size() == 1){
                            secondMyList.isDelete = true;
                        }else{
                            secondMyList.list.remove(0);
                        }
                        reached = true;
                    }else{
                        //merge the lists.

                        if(firstMyList.list.size() == 1 && firstMyList.isDelete){
                            finalResult.remove(firstMyList);
                            i = i - 1;
                            if(reached){
                                count++;
                                reached = false;
                            }
                        }else{
                            firstMyList.list.addAll(secondMyList.list);
                            //for the safer side.
                            firstMyList.isDelete = false;
                            finalResult.remove(secondMyList);
                            i = i -1;
                        }

                    }


                if(firstMyList.list.size() == 1 && firstMyList.isDelete){
                    finalResult.remove(firstMyList);
                    i = i - 1;
                }
            }


                //delete it if flag is set. //because for the last element, you won't go in the loop to delete it.
                MyList tempList = finalResult.get(finalResult.size() - 1);
                if(tempList.isDelete)
                    finalResult.remove(tempList);


            if(reached){
                count++;
                reached = false;
            }
        }

        System.out.println(count);

    }


    public static void main(String[] args) {
        Poison p = new Poison();
//        p.findAnswer(p.populateList(new int[]{4,7,8,1,3,5,2}));
//        p.findAnswer(p.populateList(new int[]{4,1,2}));
        //[6, 5, 8, 4, 7, 10, 9]
        p.findAnswer(p.populateList(new int[]{6,5,8,4,7,10,9,2}));

//        p.findAnswer(p.populateList(new int[]{4,3,7,5,6,4,2}));




    }
}
