package HW7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class server {
    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (start >= minHeap.peek()) {
                minHeap.poll();
            }
            
            minHeap.add(end);
        }
        
        return minHeap.size();
    }


    
    public static void main(String[] args) {
        server server = new server();
        int[][] intervals = {{17, 90}, {16, 20}, {21, 25}};
        System.out.println(server.minMeetingRooms(intervals)); 
        
    }
}
