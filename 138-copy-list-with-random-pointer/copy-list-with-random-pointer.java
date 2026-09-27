class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 1. Insert cloned nodes after every original node
        Node current = head;

        while (current != null) {
            Node copy = new Node(current.val);

            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        // 2. Set random pointers of cloned nodes
        current = head;

        while (current != null) {
            Node copy = current.next;

            if (current.random != null) {
                copy.random = current.random.next;
            }

            current = copy.next;
        }

        // 3. Separate original and cloned lists
        Node dummy = new Node(0);
        Node copyTail = dummy;

        current = head;

        while (current != null) {
            Node copy = current.next;

            current.next = copy.next;
            copyTail.next = copy;
            copyTail = copy;

            current = current.next;
        }

        return dummy.next;
    }
}