package HW6;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class threesum {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

                if (seen.contains(complement)) {
                    
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(complement);
                    triplet.add(nums[j]);
                    
                    set.add(triplet);
                
                }
                seen.add(nums[j]);
            }
        }

        result.addAll(set);

        return result;
    }

    public static void main(String[] args) {

        threesum test = new threesum();
        //int[] num = {0,1,1};
        int[] num2 = {-5, 0 , 0, 5, -10, 10};
        //int[] num2 = {-1, 0, 1, 2, -1, -4};
        //int[] num2 = {0, 0, 0};


        System.out.println(test.threeSum(num2));
    }

    
}
