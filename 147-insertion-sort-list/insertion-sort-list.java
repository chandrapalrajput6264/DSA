class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node before the sorted list
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            // Find insertion position
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val <= current.val) {
                prev = prev.next;
            }

            // Insert current node
            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next;
    }
}