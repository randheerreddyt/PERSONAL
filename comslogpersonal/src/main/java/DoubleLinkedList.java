public class DoubleLinkedList {

    private DoubleNode head;

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(String val) {
        DoubleNode current = head;
        DoubleNode newNode = new DoubleNode(val);
        newNode.next = null;
        if (head == null) {
            newNode.previous = null;
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
    }

    public void removeLast() {
        DoubleNode current = head;
        if (isEmpty()) {
            System.out.println("List is empty hence cannot remove anything");
        } else {
            if (head.next == null && head.previous == null) {
                head = null;
                return;
            }
            while (current.next.next != null) {
                current = current.next;
            }
            current.next.previous = null;
            current.next = null;
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
            while (current.next != null) {
                if (current.next.val == remVal) {
                    matchFound = true;
                    current.next = current.next.next;
                    current.next.previous = current.previous;
                    return head;
                }
                current = current.next;
            }
            if(!matchFound){
                 System.out.println("No match found in the List");
            }
        }
        return head;
    }

    public void show() {
        DoubleNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addLast("manu");
        list.addLast("sahu");
        list.addLast("rana");
        list.addLast("raji");
        list.addLast("moni");

        System.out.println("print Double LinkedList");
        list.show();
        list.removeLast();
        System.out.println("print Double List after last element removal removal");
        list.show();
        list.removeByMatch("jj");
        System.out.println("print Double list after removal by value match");
        list.show();
    }
}
