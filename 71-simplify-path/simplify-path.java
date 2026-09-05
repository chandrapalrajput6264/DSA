import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {

            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append('/').append(stack.removeLast());
        }

        return result.toString();
    }
}