package com.example;

public class Q705 {
    private static class MyHashSet {
        private static final int BUCKET_COUNT = 997;
        private Node[] buckets = new Node[BUCKET_COUNT];

        public MyHashSet() {
        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }

            int index = hash(key);
            buckets[index] = new Node(key, buckets[index]);
        }

        public void remove(int key) {
            int index = hash(key);

            if (buckets[index] == null) {
                return;
            }

            if (buckets[index].element == key) {
                buckets[index] = buckets[index].getNext();
            } else {
                Node current = buckets[index];
                while (current.next != null) {
                    if (current.getNext().getElement() == key) {
                        current.setNext(current.getNext().getNext());
                        return;
                    }
                    current = current.getNext();
                }
            }
        }

        public boolean contains(int key) {
            int index = hash(key);
            Node current = buckets[index];
            while (current != null) {
                if (current.getElement() == key) {
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }

        private int hash(int key) {
            return key % BUCKET_COUNT;
        }

        private static class Node {
            private int element;
            private Node next;

            public Node(int element, Node next) {
                this.element = element;
                this.next = next;
            }

            public Node(int element) {
                this(element, null);
            }

            public int getElement() {
                return element;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
        System.out.println(myHashSet.contains(1));
        myHashSet.add(2);
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
    }
}
