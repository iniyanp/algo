package algos;

/**
 * Created by paramin on 8/30/17.
 *
 * You have unlimited supply of coins.How many ways you can make a change for a given value and set of coins.
 *
 */
public class Changes {


    static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 1, then no solution exist
        if (m <=0 && n >= 1)
            return 0;

        //dont consider mth coin. , consider mth coin
        return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
    }

    public static void main(String[] args) {
       System.out.println(count(new int[]{1,5,10}, 3,5));
    }
}
