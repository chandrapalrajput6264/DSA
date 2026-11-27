import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> roots = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder(sentence.length());

        int start = 0;
        int n = sentence.length();

        while (start < n) {
            int end = start;

            while (end < n && sentence.charAt(end) != ' ') {
                end++;
            }

            String replacement = null;

            // Check prefixes from shortest to longest
            for (int i = start + 1; i <= end; i++) {
                String prefix = sentence.substring(start, i);

                if (roots.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }

            if (result.length() > 0) {
                result.append(' ');
            }

            if (replacement != null) {
                result.append(replacement);
            } else {
                result.append(sentence, start, end);
            }

            start = end + 1;
        }

        return result.toString();
    }
}