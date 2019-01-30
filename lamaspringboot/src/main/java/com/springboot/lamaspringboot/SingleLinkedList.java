package com.springboot.lamaspringboot;

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
            if (remVal.equalsIgnoreCase(head.val)) {
                return head = head.next;
            }
            while (current.next != null) {
                if (remVal.equalsIgnoreCase(current.next.val)) {
                    matchFound = true;
                    current.next = current.next.next;
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

    public void updateElement(String existVal, String updateVal) {
        Node current = head;
        boolean matchFound = false;
        if (isEmpty()) {
            System.out.println("List is empty hence cannot update anything");
        } else {
            if (existVal.equalsIgnoreCase(head.val)) {
                head.val = updateVal;
                return;
            }
            while (current.next != null) {
                if (existVal.equalsIgnoreCase(current.next.val)) {
                    matchFound = true;
                    current.next.val = updateVal;
                    return;
                }
                current = current.next;
            }
            if (!matchFound) {
                System.out.println("No match found in the List");
            }
        }
    }

    public StringBuilder show() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.val);
            sb.append(" , ");
            current = current.next;
        }
        return sb;
    }
}

