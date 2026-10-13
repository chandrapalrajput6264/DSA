
class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        int n = preorder.length();
        int i = 0;

        while (i < n) {
            // No available slot for the next node
            if (slots == 0) {
                return false;
            }

            // Find the end of the current token
            int j = i;
            while (j < n && preorder.charAt(j) != ',') {
                j++;
            }

            // Consume one slot for the current node
            slots--;

            // A non-null node creates two child slots
            if (preorder.charAt(i) != '#') {
                slots += 2;
            }

            // Move to the next token
            i = j + 1;
        }

        return slots == 0;
    }
}
