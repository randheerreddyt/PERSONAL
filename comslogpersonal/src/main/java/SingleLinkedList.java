public class SingleLinkedList {

    private Node head;

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(String val) {
        Node current = head;
        Node newNode = new Node(val);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeLast() {
        Node current = head;
        if (isEmpty()) {
            System.out.println("List is empty hence cannot remove anything");
        } else {
            if (head.next == null) {
                head = null;
                return;
            }
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    public Node removeByMatch(String remVal) {
        Node current = head;
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
        Node current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast("laddoo");
        list.addLast("manu");
        list.addLast("rana");
        list.addLast("sahu");
        list.addLast("sahu");

        System.out.println("print LinkedList");
        list.show();
        list.removeLast();
        System.out.println("print List after last element removal removal");
        list.show();
        list.removeByMatch("rana");
        System.out.println("print list after removal by value match");
        list.show();
    }
}
