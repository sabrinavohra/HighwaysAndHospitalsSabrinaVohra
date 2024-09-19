import java.util.ArrayList;
import java.util.Stack;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Sabrina Vohra
 *
 */

public class HighwaysAndHospitals {
    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Creates edge case because if the hospitalCost is less than the highwayCost, the cheapest option is always to
        // create hospitals in every town
        // Array to turn if city has hospital access, so I can check if all the cities have access
        if (hospitalCost <= highwayCost) {
            return (long) hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        for(int i  = 0; i < cities.length; i++) {
                int a = cities[i][0];
                int b = cities[i][1];
                int x = a;
                int y = b;

                while(roots[x] > 0) {
                    x = roots[x];
                }
                while(roots[a] > 0) {
                    int temp = roots[a];
                    roots[a] = x;
                    a = temp;
                }
                while(roots[y] > 0) {
                    y = roots[y];
                }
                while(roots[b] > 0) {
                    int temp = roots[b];
                    roots[b] = y;
                    b = temp;
                }
                if(x != y) {
                    if(roots[x] < roots[y]) {
                        roots[x] += (roots[y] - 1);
                        roots[y] = x;
                    }
                    else {
                        roots[y] += (roots[x] - 1);
                        roots[x] = y;
                    }
                }
            }
        int groups = 0;
        for(int i = 1; i <= n; i++) {
            if(roots[i] <= 0) {
                groups++;
            }
        }
    return ((long) groups * hospitalCost) + ((long) highwayCost * (n - groups));
    }
}