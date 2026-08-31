package com.example;

public class Q706 {
    private static class MyHashMap {
        private static final int BUCKET_COUNT = 3571;
        private Node[] buckets = new Node[BUCKET_COUNT];

        public MyHashMap() {

        }

        public void put(int key, int value) {
            int index = hash(key);

            Node current = buckets[index];
            while (current != null) {
                Pair pair = current.getPair();
                if (pair.key == key) {
                    pair.value = value;
                    return;
                }
                current = current.getNext();
            }
            buckets[index] = new Node(new Pair(key, value), buckets[index]);
        }

        public int get(int key) {
            int index = hash(key);

            Node current = buckets[index];

            while (current != null) {
                Pair pair = current.getPair();
                if (pair.key == key) {
                    return pair.value;
                }
                current = current.getNext();
            }

            return -1;
        }

        public void remove(int key) {
            int index = hash(key);

            if (buckets[index] == null) {
                return;
            }

            if (buckets[index].pair.key == key) {
                buckets[index] = buckets[index].getNext();
            } else {
                Node current = buckets[index];
                while (current.getNext() != null) {
                    if (current.getNext().pair.key == key) {
                        current.setNext(current.getNext().getNext());
                        break;
                    }
                    current = current.getNext();
                }
            }

        }

        private int hash(int key) {
            return key % BUCKET_COUNT;
        }

        private static class Pair {
            private int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private static class Node {
            private Pair pair;
            private Node next;

            public Node(Pair pair, Node next) {
                this.pair = pair;
                this.next = next;
            }

            public Node(Pair pair) {
                this(pair, null);
            }

            public Pair getPair() {
                return pair;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return next;
            }
        }
    }
}
