package exercise;

import java.util.*;

/**
 * Created by iniyan.paramasivam on 10/20/18.
 */
public class MergeSort {

    public class ListNode {
       int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }

  public class MyIterator implements Iterator<ListNode>{

      ListNode l = null;
      public MyIterator(ListNode l){
          this.l = l ;
      }

      @Override
      public boolean hasNext() {
          return l.next != null;
      }

      @Override
      public ListNode next() {
          return l.next;
      }
  }

  public class MyComparator implements Comparator<MyIterator>{

      @Override
      public int compare(MyIterator o1, MyIterator o2) {

          if(o1.l.val == o2.l.val) return 0;
          else if (o1.l.val < o2.l.val) return -1;
          else return 1;
      }
  }

  public ListNode doMerge(ListNode[] lists){

      ListNode result = null;
      ListNode head = null;
      ListNode prev = null;

      if(lists == null || lists.length == 0) return null;

      Queue<MyIterator> queue = new PriorityQueue<>(new MyComparator());

      for(ListNode l : lists){
          if(l != null)
            queue.add(new MyIterator(l));
      }
      int count = 0;
      while(!queue.isEmpty()){
          MyIterator m = queue.remove();

          result = new ListNode(m.l.val);
          if(count == 0)
              head = result;
          else
              prev.next = result;

          count++;

          if(m.hasNext())
              queue.add(new MyIterator(m.next()));
          prev = result;
      }

      return head;

  }

    public static void main(String[] args) {

        MergeSort m = new MergeSort();
        MergeSort.ListNode l1 = m.new ListNode(1);
        MergeSort.ListNode l2 = m.new ListNode(4);
        MergeSort.ListNode l3 = m.new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        MergeSort.ListNode l4 = m.new ListNode(2);
        MergeSort.ListNode l5 = m.new ListNode(6);
        l4.next = l5;
        l5.next = null;

        ListNode[] list = new ListNode[]{l1,l4};
        ListNode result = m.doMerge(list);
        while(result != null){

            System.out.println(result.val);
            result = result.next;
        }

    }

}

