package com.company;

public class Stack {

    private Node head;

    public Stack() {
        this.head = null;
    }

    public void push(int x) {
        if (isEmpty()) {
            head = new Node();
            head.data = x;
        } else {
            Node node = new Node();
            node.data = x;
            node.link = head;
            head = node;
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("нет элементов!");
            return null;
        } else {
            int x = head.data;
            head = head.link;
            return x;
        }
    }

    public void printme() {
        if (isEmpty()) System.out.println("EMPTY");
        else {
            Node currentElement = head;
            while (currentElement != null) {
                System.out.print(currentElement.data);
                if (currentElement.link != null) {
                    System.out.print(" -> ");
                }
                currentElement = currentElement.link;
            }
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Stack reverse(Stack stack) {
        if (head == null) return stack;

        Stack reversedStack = new Stack();
        ReversHeadResult newReversResult = reversedHead(this.head);
        reversedStack.head = newReversResult.newHead;
        return reversedStack;
    }

    public ReversHeadResult reversedHead(Node node) {
        Node newNode = new Node();
        newNode.data = node.data;
        if (node.link == null) {
            ReversHeadResult reversHeadResult = new ReversHeadResult();
            reversHeadResult.newHead = newNode;
            reversHeadResult.newTail = newNode;
            return reversHeadResult;
        } else {
            ReversHeadResult reversHeadResult = reversedHead(node.link);
            head = reversHeadResult.newHead;
            Node tail = reversHeadResult.newTail;
            tail.link = newNode;
            reversHeadResult.newHead = head;
            reversHeadResult.newTail = newNode;
            return reversHeadResult;
        }
    }

    public class Node {
        private Node link;
        private int data;
    }

    public class ReversHeadResult {
        private Node newHead;
        private Node newTail;
    }
}


