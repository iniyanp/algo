package algo4;

public class MaxNo{
    public static void main(String[] args) {
        int a[] = new int[]{2,3,10,6,4,8,1,100};
        int smallNo = a[0];
        int bigNo = a[0];

        int resultSmallNo = Integer.MIN_VALUE;
        int resultBigNo = Integer.MIN_VALUE;

        int si = -1;
        int bi = -1;

        int diff = Integer.MIN_VALUE;

        for (int i=1;i<a.length;i++){

            if(a[i] < smallNo){
                smallNo = a[i];
                //Whenever
                bigNo = Integer.MIN_VALUE;
            }

            if(a[i] > bigNo){
                bigNo = a[i];
            }

            if(bigNo - smallNo > diff){
                diff = bigNo - smallNo;
                resultBigNo = bigNo;
                resultSmallNo = smallNo;
            }


        }
        System.out.println(resultSmallNo + "\t" + resultBigNo);
        System.out.println("Iniyan");
    }
}
