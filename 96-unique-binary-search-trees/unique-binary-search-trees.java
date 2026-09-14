class Solution {
    public int numTrees(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * (2L * n - i + 1) / i;
        }

        return (int) (result / (n + 1));
    }
}