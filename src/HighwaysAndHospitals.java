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
        long minimalCost = hospitalCost;
        int maxCity = 0;
        int max = 0;
        if (hospitalCost < highwayCost) {
            return (long) hospitalCost * n;
        }

        // Find minimum number of hospitals that can be built that will connect to the maximum amount of cities and then
        // build highways where necessary to connect the cities to their hospitals
            // How to find minimum number of highways?
            // How to keep track of each city and whether there's a hospital inside of it or a highway reaching it?
            // How to draw out the map / keep track?

// Stack trial
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(cities[0][0]);
//        int current = stack.pop();
//        while(!stack.isEmpty()) {
//            for(int i: cities[i])
//        }

// For loop trial
//        else {
//            for (int i = 0; i < cities.length; i++) {
//                int[] currentCity = cities[i];
//                if(currentCity.length > max) {
//                    max = currentCity.length;
//                    maxCity = i;
//                }
//            }
//            if(max == n) {
//                return minimalCost + ((long) highwayCost * n);
//            }
//            return 0;
//        }
//    }
   return 0;
    }
}

// Pseudocode
// Create map of all the highways and hospitals possible and slowly decrease (??)
    // Or? Run breadth-first search and find quickest way to get the lowest cost
    // Or depth first search in order to find all the possible costs and choose the lowest one?
// Create map to keep track of the minimal cost in all the different realms
// Run through all combinations (of yes/no highway and yes/no hospital) and keep track of which one costs the least
// Return the minimal cost possible


// Questions:
    // How to draw out map with code?