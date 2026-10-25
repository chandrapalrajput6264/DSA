
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                nums1[a[0]] + nums2[a[1]],
                nums1[b[0]] + nums2[b[1]]
            )
        );

        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[0];
            int j = pair[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < m) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}
