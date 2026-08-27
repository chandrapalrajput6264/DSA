import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums, int target, int start,
                           List<Integer> list,
                           List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate combinations
            if (i > start && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > target)
                break;

            list.add(nums[i]);

            // i + 1 → each number can be used only once
            backtrack(nums, target - nums[i], i + 1, list, res);

            list.remove(list.size() - 1);
        }
    }
}