
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger result = null;
        int num = 0;
        int sign = 1;
        boolean readingNumber = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                NestedInteger list = new NestedInteger();

                if (!stack.isEmpty()) {
                    stack.peek().add(list);
                }

                stack.push(list);
            } else if (c == '-') {
                sign = -1;
                readingNumber = true;
                num = 0;
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                readingNumber = true;
            } else if (c == ',' || c == ']') {
                if (readingNumber) {
                    stack.peek().add(new NestedInteger(sign * num));
                    num = 0;
                    sign = 1;
                    readingNumber = false;
                }

                if (c == ']') {
                    result = stack.pop();

                    if (stack.isEmpty()) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
