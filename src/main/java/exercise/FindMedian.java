package exercise;

public class FindMedian {

    public static void findMedian(int[] arr1, int[] arr2) {

        int firstStart = 0;
        int firstEnd = arr1.length - 1;
        int secondStart = 0;
        int secondEnd = arr2.length - 1;

        while(firstEnd - firstStart >= 2){
            int firstMid = firstStart + (firstEnd -  firstStart)/2;
            int secondMid = secondStart + (secondEnd - secondStart)/2;

            //for now not handling == case.
            if(arr1[firstMid] < arr2[secondMid]){

                //odd count.
                if((firstEnd - firstStart) % 2 == 0){
                    firstStart = firstMid;
                }else{
                    firstStart = firstMid + 1;
                }

                secondEnd = secondMid;
            }
            else{
                if( (secondEnd - secondStart) % 2 == 0 ){
                    secondStart = secondMid;
                }else{
                    secondStart = secondMid + 1;
                }

                firstEnd = firstMid;
            }
        }
        System.out.println(arr1[firstStart] + "\t" + arr1[firstEnd] + "\t" + arr2[secondStart] + "\t" + arr2[secondEnd]);

        int min = 0;
        int max = 0;

        if(arr1[firstStart] < arr2[secondStart]){
            min = arr2[secondStart];
        }else{
            min = arr1[firstStart];
        }

        if(arr1[firstEnd] < arr2[secondEnd]){
            max = arr1[firstEnd];
        }else{
            max = arr2[secondEnd];
        }

        System.out.println(min + "\t" + max);

    }

    public static void main(String[] args) {
        int arr1[] = new int[]{1,5,8};
        int arr2[] = new int[]{2,3,4};
        findMedian(arr1, arr2);
    }
}
