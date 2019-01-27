package algo3;

public class PaintHouse1 {


    //R - 0, G - 1., B - 2
    public int paintHouse(int[][] costs, int house, int lastColor, int[] resultArr) {

        if(house < 0) return 0;

        if(lastColor == 0){
            return costs[house][lastColor] +  Math.min(paintHouse(costs,house - 1, 1,resultArr),paintHouse(costs,house - 1, 2,resultArr));
        }

        else if(lastColor == 1){
            return costs[house][lastColor] +  Math.min(paintHouse(costs,house - 1, 2, resultArr),paintHouse(costs,house - 1, 0, resultArr));
        }
        else{
            return costs[house][lastColor] +  Math.min(paintHouse(costs,house - 1, 1, resultArr),paintHouse(costs,house - 1, 2,resultArr));
        }
    }

    public static void main(String[] args) {
        int costs[][] = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int resultArr[] = new int[]{-1,-1,-1};

        PaintHouse1 p = new PaintHouse1();
        int result1 = p.paintHouse(costs, 2, 2, resultArr);
        int result2 = p.paintHouse(costs, 2, 1, resultArr);
        int result3 = p.paintHouse(costs, 2, 0, resultArr);


        int result = Math.min(Math.min(result1, result2),result3);
        System.out.println(result);

        if (result == result1) resultArr[2] = 2;
        else if (result == result2) resultArr[2] = 1;
        else resultArr[2] = 0;

        for(int i=0;i<resultArr.length;i++){
            System.out.println(resultArr[i]);
        }

    }
}
