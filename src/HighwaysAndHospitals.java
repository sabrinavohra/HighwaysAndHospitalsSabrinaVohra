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
        if (hospitalCost < highwayCost) {
            return (long) hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        for(int i  = 1; i < cities.length; i++) {
            for(int j = 1; j < cities[0].length; j++) {
                int a = roots[i];
                int b = roots[j];
                // If both are roots
                if(a == 0 && b == 0) {
                    roots[j] = i;
                }
                // If both already have the same root
                if(a == b) {
                    break;
                }
                // Get to the root of a to set b to the right value
                while (a != 0) {
                    a = roots[a];

                }
            }
        }
        int i = 0;
        int groups = 0;
        while(i != n) {
            if(roots[i] == 0) {
                groups++;
            }
            i++;
        }
    return ((long) groups * hospitalCost) + ((long) highwayCost * (n - groups));
    }
}