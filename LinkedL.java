package com.company;

public class LinkedL<T> {
    private Node<T> head;
    private Node<T> last;

    public void addElement(T value) {
        if (head == null) {
            head = new Node<>(null, value);
            last = head;
            return;
        }
        Node<T> newElement = new Node<>(last, value);
        last.setNext(newElement);
        last = newElement;

    }

    public void removeElement(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                if (current.previous != null) {
                    current.previous.next = current.next;
                }
                if (current.next != null) {
                    current.next.previous = current.previous;
                }
                if (current == head) {
                    head = current.next;
                }
                if (current == last) {
                    last = current.previous;
                }
            }
            current = current.next;
        }
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedL<Integer> integerLinkedL = new LinkedL<>();
        integerLinkedL.addElement(1);
        integerLinkedL.addElement(2);
        integerLinkedL.addElement(3);
        integerLinkedL.addElement(4);
        integerLinkedL.addElement(5);
        integerLinkedL.addElement(6);
        integerLinkedL.removeElement(4);
        integerLinkedL.removeElement(1);
        integerLinkedL.removeElement(6);
        integerLinkedL.removeElement(5);
        integerLinkedL.print();
    }
}

class Node<T> {
    Node<T> next;
    Node<T> previous;
    T value;

    public Node(Node<T> previous, T value) {
        this.previous = previous;
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

