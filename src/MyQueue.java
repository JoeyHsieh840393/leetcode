package com.example;

public class MyQueue {
    private int[] data;
    private int size;
    private int f;

    public MyQueue() {
        this(16);
    }

    public MyQueue(int capacity) {
        data = new int[capacity];
        size = 0;
        f = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int x) {
        int avali = (f + size) % data.length;
        data[avali] = x;
        size++;
    }

    public int remove() {
        int answer = data[f];
        data[f] = -1;
        f = (f + 1) % data.length;
        size--;
        return answer;
    }

}
