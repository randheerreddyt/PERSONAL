public class CircularLinkedList {

    private DoubleNode head;


    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(String val) {
        DoubleNode newNode = new DoubleNode(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            DoubleNode current = head;
            while (current != head) {
                current = current.next;
            }
            newNode.next = head;
        }
        newNode.next = newNode;
    }

    public void removeLast() {
        DoubleNode current = head;
        if (isEmpty()) {
            System.out.println("List is empty hence cannot remove anything");
        } else {
            if (isEmpty()) {
                return;
            }
            while (current.next.next != head) {
                current = current.next;
            }
            current.next.previous = null;
            current.next = head.previous;
        }
    }

    public DoubleNode removeByMatch(String remVal) {
        DoubleNode current = head;
        boolean matchFound = false;
        if (isEmpty()) {
            System.out.println("List is empty hence cannot remove anything");
        } else {
            if (head.val == remVal) {
                return head = head.next;
            }
            while (current.next != head) {
                if (current.next.val == remVal) {
                    matchFound = true;
                    current.next = current.next.next;
                    current.next.previous = current.previous;
                    return head;
                }
                current = current.next;
            }
            if (!matchFound) {
                System.out.println("No match found in the List");
            }
        }
        return head;
    }

    public void show() {
        DoubleNode current = head;
        if (current == head) {
            System.out.println(current.val);
        } else {
            while (current != head) {
                System.out.println(current.val);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast("manu");
        list.show();
        list.addLast("sahu");
        list.addLast("rana");
        list.addLast("raji");
        list.addLast("moni");

        System.out.println("print Circular LinkedList");
        list.show();
        list.removeLast();
        System.out.println("print Circular List after last element removal removal");
        list.show();
        list.removeByMatch("rana");
        System.out.println("print Circular list after removal by value match");
        list.show();
    }
}
