import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(2 * n);

        backtrack(ans, sb, 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb,
                           int open, int close, int n) {

        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        // Add opening bracket
        if (open < n) {
            sb.append('(');
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        // Add closing bracket
        if (close < open) {
            sb.append(')');
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}