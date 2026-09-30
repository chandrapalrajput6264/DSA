class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find length
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        // Bottom-up merge sort
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int size = 1; size < length; size <<= 1) {
            ListNode prev = dummy;
            current = dummy.next;

            while (current != null) {
                // First half
                ListNode left = current;

                // Second half
                ListNode right = split(left, size);

                // Remaining list
                current = split(right, size);

                // Merge
                ListNode[] merged = merge(left, right);

                prev.next = merged[0];
                prev = merged[1];
            }
        }

        return dummy.next;
    }

    // Split list after 'size' nodes
    private ListNode split(ListNode head, int size) {
        if (head == null) {
            return null;
        }

        for (int i = 1; i < size && head.next != null; i++) {
            head = head.next;
        }

        ListNode next = head.next;
        head.next = null;

        return next;
    }

    // Merge two sorted lists
    // Returns {head, tail}
    private ListNode[] merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;

        while (tail.next != null) {
            tail = tail.next;
        }

        return new ListNode[]{dummy.next, tail};
    }
}