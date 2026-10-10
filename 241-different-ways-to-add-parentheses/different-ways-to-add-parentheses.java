import java.util.*;

class Solution {
    private final Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);

            if (op == '+' || op == '-' || op == '*') {
                List<Integer> left =
                    diffWaysToCompute(expression.substring(0, i));

                List<Integer> right =
                    diffWaysToCompute(expression.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (op == '+') {
                            result.add(a + b);
                        } else if (op == '-') {
                            result.add(a - b);
                        } else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}