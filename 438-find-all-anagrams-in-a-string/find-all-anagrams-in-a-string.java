
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) return result;

        int[] freq = new int[26];

        for (int i = 0; i < m; i++) {
            freq[p.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }

        int matches = 0;

        for (int count : freq) {
            if (count == 0) matches++;
        }

        if (matches == 26) {
            result.add(0);
        }

        for (int right = m; right < n; right++) {
            // Remove the character leaving the window
            int leftIndex = s.charAt(right - m) - 'a';

            if (freq[leftIndex] == 0) matches--;
            freq[leftIndex]++;
            if (freq[leftIndex] == 0) matches++;

            // Add the new character
            int rightIndex = s.charAt(right) - 'a';

            if (freq[rightIndex] == 0) matches--;
            freq[rightIndex]--;
            if (freq[rightIndex] == 0) matches++;

            if (matches == 26) {
                result.add(right - m + 1);
            }
        }

        return result;
    }
}
