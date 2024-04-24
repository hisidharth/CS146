package HW.HW12;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        main solution = new main();

        int n = 5;
        int[] wells3 = {5, 8, 2, 1, 9};
        int[][] pipes3 = {{1, 2, 3}, {2, 3, 2}, {3, 4, 1}, {4, 5, 5}, {5, 1, 2}};
        System.out.println(solution.minCostToSupplyWater(n, wells3, pipes3));
    }

    public static ArrayList<Integer> findMinPipe(int[][] pipes, ArrayList<Integer> done) {
        int lowpipe = Integer.MAX_VALUE;
        ArrayList<Integer>  result = new ArrayList<Integer>();
        int lowHousePipe = -10;
    
        for (int[] edge : pipes) {
            if (done.contains(edge[0]) && !done.contains(edge[1]) && edge[2] < lowpipe) {
                lowpipe = edge[2];
                lowHousePipe = edge[1];
            } else if (done.contains(edge[1]) && !done.contains(edge[0]) && edge[2] < lowpipe) {
                lowpipe = edge[2];
                lowHousePipe = edge[0];
            }
        }
    
        result.add(lowpipe);
        result.add(lowHousePipe);

        return result;
    }
    
    public static ArrayList<Integer> findMinWell(int[] wells, ArrayList<Integer> done){
        int lowwell = Integer.MAX_VALUE;
        ArrayList<Integer>  result = new ArrayList<Integer>();
        int bestHouseWell = -10;
        for (int i = 0; i < wells.length; i++) {

            if (!done.contains(i + 1) && wells[i] < lowwell) {
                lowwell = wells[i];
                bestHouseWell = i + 1;
            }
        }

        result.add(lowwell);
        result.add(bestHouseWell);
        
        return result;

    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int totalCost = 0;
        ArrayList<Integer> done = new ArrayList<>();
        
        while (n > done.size()) {
            int lowwell = findMinWell(wells, done).get(0);
            int bestHouseWell = findMinWell(wells, done).get(1);

            int lowpipe = findMinPipe(pipes, done).get(0);
            int lowHousePipe = findMinPipe(pipes, done).get(1);

            if (lowwell < lowpipe) {
                done.add(bestHouseWell);

                totalCost += lowwell;

            } else if(lowpipe < lowwell){
                done.add(lowHousePipe);
                totalCost += lowpipe;

            }
            else if(lowpipe == lowwell){
                done.add(lowHousePipe);
                totalCost += lowpipe;
            }
        }
        
        return totalCost;
    }
}
