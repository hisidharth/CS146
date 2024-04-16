package Lab6;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Lab6 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i< numCourses; i++){
            inDegree.put(i, 0);
        }
    
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
           
            inDegree.put(course, inDegree.getOrDefault(course, 0) + 1);
        }
 
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree.getOrDefault(i, 0) == 0) {
                queue.add(i);
            }
        }
    
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == node) {
                    int course = prerequisites[i][0];
                    inDegree.put(course, inDegree.get(course) - 1);
                    if (inDegree.get(course) == 0) {
                        queue.add(course);
                    }
                }
            }

            count++;

    
            
        }
        return count == numCourses;
    }
    

    public static void main(String[] args) {
        Lab6 courseSchedule = new Lab6();

        int numCourses1 = 5;
        int[][] prerequisites1 = {};
        System.out.println("Test Case 1 (Empty prerequisites): " + courseSchedule.canFinish(numCourses1, prerequisites1)); // Output: true

        int numCourses2 = 1;
        int[][] prerequisites2 = {};
        System.out.println("Test Case 2 (Single course): " + courseSchedule.canFinish(numCourses2, prerequisites2)); // Output: true

        int numCourses3 = 1;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Test Case 3 (Linear prerequisites): " + courseSchedule.canFinish(numCourses3, prerequisites3)); // Output: true

        int numCourses4 = 3;
        int[][] prerequisites4 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Test Case 4 (Circular prerequisites): " + courseSchedule.canFinish(numCourses4, prerequisites4)); // Output: false

        int numCourses5 = 3;
        int[][] prerequisites5 = {{1, 0}, {2, 0}, {2, 1}};
        System.out.println("Test Case 5 (All courses have prerequisites): " + courseSchedule.canFinish(numCourses5, prerequisites5)); // Output: true

        int numCourses6 = 3;
        int[][] prerequisites6 = {};
        System.out.println("Test Case 6 (No prerequisites): " + courseSchedule.canFinish(numCourses6, prerequisites6)); // Output: true
    }

}
