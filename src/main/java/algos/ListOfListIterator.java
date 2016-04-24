package algos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by paramasivami on 4/22/16.
 */
public class ListOfListIterator<T> implements Iterator<T> {



    private List<Iterator<T>> iterators;

    public ListOfListIterator(List<Iterator<T>> iterators){
        this.iterators = iterators;
    }
    @Override
    public boolean hasNext() {
        for(int i = 0; i < iterators.size(); i++){
            if(iterators.get(i).hasNext()) return true;
        }
        return false;
    }

    @Override
    public T next() {
        for(int i=0; i < iterators.size(); i++){
            Iterator<T> n = iterators.get(i);
            if(n.hasNext()) return n.next();
        }
        return null;
    }

    public static void main(String[] args) {
        List<List<Integer>> elements = new ArrayList<>();

        for(int i=0;i<3;i+=2){
            List<Integer> inner = new ArrayList<>();
            inner.add(i);
            inner.add(i+1);
            elements.add(inner);
        }

        List<Iterator<Integer>> iterators = new LinkedList<>();
        elements.forEach(
                element -> iterators.add(element.iterator())
        );


        ListOfListIterator l = new ListOfListIterator(iterators);
        while(l.hasNext()) System.out.println(l.next());
    }

}
