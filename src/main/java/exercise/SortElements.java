package exercise;

/*
In this problem, we have streams from multiple files and we want to get the latest message from each file and do some processing on it.
The streams are represented as a list of lists where each sublist is a sorted list of timestamps. Write a class with a function next() that returns the next smallest timestamp from all the sublists. Your code should compile and include test cases.


Example:
data = [[3, 5], [1, 5, 12], [6, 6, 6, 11]]

# n sublists:
# O(n)
# h
# log(h)
# each sublist is sorted
x = Solution(data)
x.next() -> 1
x.next() -> 3
x.next() -> 5
x.next() -> ...


Limitations:
1. input data cannot be modified
2. each sublist can be arbitrary length (n is # of sublists, k is avg # of elements in one sublist)
3. another copy of the input data will not fit in memory
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SortElements {


    PriorityQueue<MyIterator> queue = null;

    class MyIterator {

        Iterator<Integer> i = null;
        int data;

        MyIterator(Iterator<Integer> i){
            this.i = i;
            if(this.i.hasNext())
                data = this.i.next();
        }

        public int next() {

            if(this.i.hasNext()){
                data = this.i.next();
                return data;
            }

            return -1;
        }

        public boolean hasNext() {

            return this.i.hasNext();

        }

    }

    class MyComparator implements Comparator<MyIterator> {

        public int compare(MyIterator i1, MyIterator i2) {

            int elem1 = i1.data;
            int elem2 = i2.data;
            if(elem1 < elem2) return -1;
            else if(elem1 == elem2) return 0;
            else  return 1;

        }

    }

    public SortElements(List<List<Integer>> data) {

        queue = new PriorityQueue<MyIterator>(new MyComparator());

        for(int i=0;i<data.size();i++){

            Iterator it = data.get(i).iterator();
            MyIterator mi = new MyIterator(it);

            if(mi.hasNext())
                queue.add(mi);

        }
    }

    public int next(){

        if(queue == null) return -1; //default value.

        MyIterator it = queue.remove();
        int element =  it.data;

        if(it.hasNext()) {
            it.next();
            queue.add(it);
        }
        return element;

    }

    public static void main(String[] args) {

        //Within the list, it has to be sorted.
        List<Integer> l1 = new LinkedList<Integer>();
        l1.add(3);
        l1.add(15);

        List<Integer> l2 = new LinkedList<Integer>();
        l2.add(1);
        l2.add(2);

        List<Integer> l3 = new LinkedList<Integer>();
        l3.add(4);
        l3.add(6);

        List<List<Integer>> finalList = new LinkedList<>();
        finalList.add(l1);
        finalList.add(l2);
        finalList.add(l3);

        SortElements s = new SortElements(finalList);

        for(int i=0;i<6;i++){

            System.out.println(s.next());

        }



    }
}

