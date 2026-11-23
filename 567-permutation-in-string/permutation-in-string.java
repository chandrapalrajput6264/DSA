
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] count = new int[26];

        // Store frequency of characters in s1
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < m; i++) {
            count[s2.charAt(i) - 'a']--;

            if (i >= n) {
                count[s2.charAt(i - n) - 'a']++;
            }

            // Check whether all frequencies match
            if (i >= n - 1) {
                boolean match = true;

                for (int j = 0; j < 26; j++) {
                    if (count[j] != 0) {
                        match = false;
                        break;
                    }
                }

                if (match) return true;
            }
        }

        return false;
    }
}
