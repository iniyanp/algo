package algos;

/**
 * Created by paramasivami on 4/17/16.
 */
public class PrintPostOrder {

    private static int index = 0;

    public static void main(String[] args) {
        int[] preOrder = new int[]{5, 8, 9, 10, 12, 15};
        int[] inOrder = new int[]{10, 8, 5, 9, 12, 15};

        findPostOrder(0, preOrder.length - 1, preOrder, inOrder);
    }

    private static int findPos(int[] inOrder, int elem) {
        int pos = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == elem) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private static void findPostOrder(int start, int end, int[] preOrder, int[] inOrder) {

        if (start > end) return;
//        if(start == end) {
//            System.out.println(preOrder[index++]);
//            return;
//        }
        int pos = findPos(inOrder, preOrder[index++]);
        if(pos != 0)
        findPostOrder(start, pos - 1, preOrder, inOrder);
        if(pos != preOrder.length - 1)
        findPostOrder(pos + 1, end, preOrder, inOrder);
        System.out.println(inOrder[pos]);
    }
}
