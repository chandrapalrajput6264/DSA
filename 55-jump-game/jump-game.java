class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index cannot be reached
            if (i > farthest) {
                return false;
            }

            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // Already reached the last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}