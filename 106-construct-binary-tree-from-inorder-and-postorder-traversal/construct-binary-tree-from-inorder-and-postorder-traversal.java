import java.util.*;

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        inorderMap = new HashMap<>(inorder.length * 2);

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);

        int mid = inorderMap.get(value);

        // Postorder is processed from right to left,
        // so build right subtree first.
        root.right = build(postorder, mid + 1, right);
        root.left = build(postorder, left, mid - 1);

        return root;
    }
}