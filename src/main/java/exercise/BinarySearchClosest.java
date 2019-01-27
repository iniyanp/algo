package exercise;

/**
 * Created by iniyan.paramasivam on 10/21/18.
 */
public class BinarySearchClosest {

    public int findClosest(int[] arr, int k) {


        int start = 0, end = arr.length - 1, mid = 0, target = 0, diff = Integer.MAX_VALUE, result=-1;
        while( start <= end) {
            if(start > end) break;
            mid = start + (end-start)/2;
            target = arr[mid];
            if(target == k){
                diff = 0;
                result = target;
                break;
            }
            if(diff > Math.abs(target - k)){
                diff = Math.min(diff, Math.abs(target - k));
                result = target;

            }
            if(k < target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return result;

    }
    public static void main(String[] args) {
        BinarySearchClosest b = new BinarySearchClosest();
        int arr[] = new int[]{1,3,15,16,18,19};
        System.out.println(b.findClosest(arr, 21));
    }
}
