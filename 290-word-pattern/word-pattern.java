class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        int[] charMap = new int[26];
        java.util.HashMap<String, Integer> wordMap = new java.util.HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            int c = pattern.charAt(i) - 'a';
            int position = i + 1;

            if (charMap[c] != wordMap.getOrDefault(words[i], 0)) {
                return false;
            }

            charMap[c] = position;
            wordMap.put(words[i], position);
        }

        return true;
    }
}
