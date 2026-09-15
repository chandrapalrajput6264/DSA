class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        // Keep s2 as the shorter string to minimize memory
        if (n > m) {
            String temp = s1;
            s1 = s2;
            s2 = temp;

            m = s1.length();
            n = s2.length();
        }

        boolean[] dp = new boolean[n + 1];

        // Using only s2
        dp[0] = true;

        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            // Take current character from s1
            dp[0] = dp[0] &&
                    s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                char target = s3.charAt(i + j - 1);

                boolean fromS1 = dp[j] &&
                        s1.charAt(i - 1) == target;

                boolean fromS2 = dp[j - 1] &&
                        s2.charAt(j - 1) == target;

                dp[j] = fromS1 || fromS2;
            }
        }

        return dp[n];
    }
}