package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class Q225 {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }

    private static class MyStack {
        private Queue<Integer> queue;
        private Queue<Integer> backup;

        public MyStack() {
            queue = new LinkedList<Integer>();
            backup = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();

            for (int i = 1; i <= size - 1; i++) {
                backup.offer(queue.poll());
            }

            Queue<Integer> temp = queue;
            queue = backup;
            backup = temp;

            return backup.poll();
        }

        public int top() {
            int answer = pop();
            push(answer);
            return answer;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
