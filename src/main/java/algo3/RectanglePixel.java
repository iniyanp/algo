package algo3;

/**
 * Created by paramin on 9/24/17.
 */
public class RectanglePixel {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int colMin = binarySearch(image, true, 0, y, 0, m, true);
        int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
        int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
        int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
        return (rowMax - rowMin) * (colMax - colMin);
    }

    public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while(lower < upper) {
            int mid = lower + (upper - lower) / 2;
            boolean inside = false;
            for(int i = min; i < max; i++) {
                if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    inside = true;
                    break;
                }
            }
            if(inside == goLower) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    public static void main(String[] args) {
        RectanglePixel r = new RectanglePixel();
        char[][] m = new char[][]{
                {'0','0','1','0'},
                {'0','1','1','0'},
                {'0','1','0','0'}
        };
        System.out.println(r.minArea(m,0,2));
    }
}
