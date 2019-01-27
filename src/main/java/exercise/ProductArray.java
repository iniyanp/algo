package exercise;

public class ProductArray {


    public static void product(int[] arr1) {

        int res[] = new int[arr1.length + 1];

        res[0] = 1;
        int mul = 1;
        for(int i=0;i<arr1.length;i++){
            res[i + 1] = arr1[i] * mul;
            mul = mul * arr1[i];
        }

        int mul1 = 1;
        for(int i=arr1.length-1; i >= 0; i--){
            res[i] = res[i] * mul1;
            System.out.println(res[i]);
            mul1 = mul1 * arr1[i];

        }

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4};
        product(arr);

    }

}
