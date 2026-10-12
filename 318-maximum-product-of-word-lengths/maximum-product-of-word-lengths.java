class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lengths = new int[n];

        for (int i = 0; i < n; i++) {
            int mask = 0;
            String word = words[i];

            for (int j = 0; j < word.length(); j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }

            masks[i] = mask;
            lengths[i] = word.length();
        }

        int maxProduct = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProduct = Math.max(
                        maxProduct,
                        lengths[i] * lengths[j]
                    );
                }
            }
        }

        return maxProduct;
    }
}