class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        // Empty string vs pattern
        for (int j = 2; j <= m; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean diagonal = dp[0];
            dp[0] = false;

            for (int j = 1; j <= m; j++) {
                boolean previous = dp[j];

                char pc = p.charAt(j - 1);

                if (pc == '*' && j >= 2) {
                    // '*' matches zero occurrences
                    dp[j] = dp[j - 2];

                    // '*' matches one or more occurrences
                    char prev = p.charAt(j - 2);

                    if (prev == '.' || prev == s.charAt(i - 1)) {
                        dp[j] |= previous;
                    }
                } else if (pc == '.' || pc == s.charAt(i - 1)) {
                    dp[j] = diagonal;
                } else {
                    dp[j] = false;
                }

                diagonal = previous;
            }
        }

        return dp[m];
    }
}