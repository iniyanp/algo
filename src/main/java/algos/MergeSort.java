package algos;

/**
 * Created by paramasivami on 4/4/16.
 */
public class MergeSort {


    private static int[] merge(int[] leftArr, int[] rightArr){
        int leftStart = 0;
        int leftEnd = leftArr.length;
        int rightStart = 0;
        int rightEnd = rightArr.length;

        int size = leftEnd - leftStart + rightEnd - rightStart;
        int[] result = new int[size];
        int temp = 0;

        while(leftStart < leftEnd && rightStart < rightEnd){
            if(leftArr[leftStart] < rightArr[rightStart]){
                result[temp++] = leftArr[leftStart];
                leftStart++;
            }
            else{
                result[temp++] = rightArr[rightStart];
                rightStart++;
            }
        }

        while(leftStart < leftEnd) result[temp++] = leftArr[leftStart++];
        while(rightStart < rightEnd) result[temp++] = rightArr[rightStart++];
        return result;

    }

    private static int[] mergeSort(int[] arr){
        int size = arr.length;
        int leftSize = size/2;
        int rightSize = size - leftSize;
        if(leftSize <= 0 || rightSize <= 0) return arr;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for(int start = 0 ; start < leftSize; start++){
            leftArr[start] = arr[start];
        }

        for(int start = 0 ; start < rightSize; start++){
            rightArr[start] = arr[leftSize++];
        }

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return merge(leftArr, rightArr);

    }

    public static void main(String[] args) {

        int arr[] = {6, 5, 4, 3, 1,100};
        int[] result = mergeSort(arr);
        for(int i =0 ; i < result.length; i++)
        System.out.println(result[i]);
    }
}
