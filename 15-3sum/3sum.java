import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // No possible answer after positive value
            if (nums[i] > 0)
                break;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } 
                else if (sum > 0) {
                    right--;
                } 
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    int leftVal = nums[left];
                    int rightVal = nums[right];

                    while (left < right && nums[left] == leftVal)
                        left++;

                    while (left < right && nums[right] == rightVal)
                        right--;
                }
            }
        }

        return ans;
    }
}