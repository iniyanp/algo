package exercise;
import java.lang.annotation.ElementType;
import java.util.*;

/**
 * Created by iniyan.paramasivam on 10/14/18.
 */
public class Ex7 {


    /**
     * Created by iniyan.paramasivam on 10/14/18.
     */

    class Element{
        String a;
        public Element(String a){
            this.a = a;
        }

        public String toString(){
            return a;
        }
    }

    class LengthComparator implements Comparator<Ex7.Element> {

        @Override
        public int compare(Ex7.Element o1, Ex7.Element o2) {
            if(o1.a.length() == o2.a.length()) return 0;
            else if(o1.a.length() > o2.a.length()) return 1;
            else return -1;
        }
    }

    public void iterateMap() {
        Map<Integer,String> map = new TreeMap<>();
        map.put(2,"Hello");
        map.put(3,"Hi");
        map.put(1,"How are you?");
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        Ex7 ex = new Ex7();
        ex.iterateMap();
        Element e1 = ex.new Element("hello");
        Element e2 = ex.new Element("hi");
        Element e3 = ex.new Element("Iniyan");

        List<Element> list = new ArrayList<Element>();
        list.add(e3);
        list.add(e1);
        list.add(e2);

        Collections.sort(list,ex.new LengthComparator());
        System.out.println(list);

    }

}
