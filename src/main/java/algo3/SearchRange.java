package algo3;

/**
 * Created by paramin on 10/12/17.
 */
public class SearchRange {


    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr[arr.length - 1];

        while(start <= end){

            int mid = (start + end) / 2;

            if(arr[mid] == target) return mid;

            if(target > arr[mid]) start = mid + 1;
            else end = mid-1;

        }
        return -1;

    }

    public static int findStart(int[] arr, int pos) {

        int start = 0, end = pos;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == arr[pos]) {
                pos = mid;
                end = mid;
            }

            if(arr[mid] < arr[pos]) start = mid + 1;
            else end = mid - 1;
        }
        if(arr[start] == arr[pos]) return start;
        return pos;
    }

//    public static int[] find(int[] arr, int target) {
//
//        if(arr == null || arr.length == 0) return new int[]{-1,-1};
//
//        //Find atleast one position of that target element.
//
//
//
//
//    }

    public static void main(String[] args) {

        System.out.println(binarySearch(new int[]{1,2,3,4,5},3));
        int[] arr = new int[]{8,8,8,8,10};
        System.out.println(findStart(arr,3));

    }
}
