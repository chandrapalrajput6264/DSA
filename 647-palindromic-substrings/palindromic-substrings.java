class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int center = 0; center < n; center++) {
            // Odd-length palindromes: "aba"
            count += expand(s, center, center);

            // Even-length palindromes: "abba"
            count += expand(s, center, center + 1);
        }

        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}