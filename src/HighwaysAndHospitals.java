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
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Returns cost of hospitals in every city if the hospital cost is less than or equal to the highway cost
        if (hospitalCost <= highwayCost) {
            return (long) hospitalCost * n;
        }
        // Creates an array to store the roots of every city
        int[] roots = new int[n + 1];
        for (int[] city : cities) {
            // Declares cities for current pairs
            int a = city[0];
            int b = city[1];
            // Declares the top cities
            int topCityA = a;
            int topCityB = b;

            // Sets the top city to its value
            while (roots[topCityA] > 0) {
                topCityA = roots[topCityA];
            }
            // Uses path compression to connect the current city to its root
            while (roots[a] > 0) {
                int temp = roots[a];
                roots[a] = topCityA;
                a = temp;
            }
            // Repeats for the other city in the pair
            while (roots[topCityB] > 0) {
                topCityB = roots[topCityB];
            }
            while (roots[b] > 0) {
                int temp = roots[b];
                roots[b] = topCityB;
                b = temp;
            }
            // Uses weight balancing to choose which subtree to be the root and then adds other subtree to it
            if (topCityA != topCityB) {
                if (roots[topCityA] < roots[topCityB]) {
                    roots[topCityA] += (roots[topCityB] - 1);
                    roots[topCityB] = topCityA;
                } else {
                    roots[topCityB] += (roots[topCityA] - 1);
                    roots[topCityA] = topCityB;
                }
            }
        }
        // Runs through the array again to find the number of subtrees
        int groups = 0;
        for(int i = 1; i <= n; i++) {
            if(roots[i] <= 0) {
                groups++;
            }
        }
        // Returns total cost for the hospitals and highways needed for the lowest cost
        return ((long) groups * hospitalCost) + ((long) highwayCost * (n - groups));
    }
}