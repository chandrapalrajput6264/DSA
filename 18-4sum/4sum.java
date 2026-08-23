class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = n - 1; j > i + 2; j--) {

                if (j < n - 1 && nums[j] == nums[j + 1])
                    continue;

                long sum = (long) target - nums[i] - nums[j];

                int left = i + 1;
                int right = j - 1;

                while (left < right) {

                    long s = (long) nums[left] + nums[right];

                    if (s == sum) {
                        res.add(List.of(
                            nums[i], nums[left],
                            nums[right], nums[j]
                        ));

                        left++;
                        right--;

                        while (left < right &&
                               nums[left] == nums[left - 1])
                            left++;

                        while (left < right &&
                               nums[right] == nums[right + 1])
                            right--;

                    } else if (s < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}