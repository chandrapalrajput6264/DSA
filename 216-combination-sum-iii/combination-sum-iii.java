
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int target,
                           List<Integer> path,
                           List<List<Integer>> result) {
        if (path.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        int remaining = k - path.size();

        // Prune if not enough numbers remain
        if (10 - start < remaining) {
            return;
        }

        for (int num = start; num <= 9; num++) {
            if (num > target) {
                break;
            }

            path.add(num);
            backtrack(num + 1, k, target - num, path, result);
            path.remove(path.size() - 1);
        }
    }
}
