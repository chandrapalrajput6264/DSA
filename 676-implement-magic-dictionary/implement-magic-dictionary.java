class MagicDictionary {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private final TrieNode root = new TrieNode();

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return search(root, searchWord, 0, false);
    }

    private boolean search(TrieNode node, String word, int index,
                           boolean changed) {
        if (index == word.length()) {
            return changed && node.isWord;
        }

        int target = word.charAt(index) - 'a';

        for (int c = 0; c < 26; c++) {
            TrieNode next = node.children[c];

            if (next == null) {
                continue;
            }

            if (c == target) {
                if (search(next, word, index + 1, changed)) {
                    return true;
                }
            } else if (!changed) {
                if (search(next, word, index + 1, true)) {
                    return true;
                }
            }
        }

        return false;
    }
}