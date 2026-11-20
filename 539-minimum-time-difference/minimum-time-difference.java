
import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[1440];

        // Convert time into minutes
        for (String time : timePoints) {
            int minutes =
                Integer.parseInt(time.substring(0, 2)) * 60 +
                Integer.parseInt(time.substring(3, 5));

            // Duplicate time means zero difference
            if (seen[minutes]) {
                return 0;
            }

            seen[minutes] = true;
        }

        int first = -1;
        int previous = -1;
        int ans = 1440;

        // Traverse all possible minutes in sorted order
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == -1) {
                    first = i;
                }

                if (previous != -1) {
                    ans = Math.min(ans, i - previous);
                }

                previous = i;
            }
        }

        // Check circular difference
        ans = Math.min(ans, 1440 - previous + first);

        return ans;
    }
}
