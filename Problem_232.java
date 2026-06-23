// 232. Implement Queue using Stacks

import java.util.Stack;

public class Problem_232 {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public Problem_232() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (!empty()) {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }

            int removed = s2.pop();

            while (s2.size() != 0) {
                s1.push(s2.pop());
            }

            return removed;
        }
        return -1; // Queue is empty
    }

    public int peek() {
        if (!empty()) {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }

            int front = s2.peek();

            while (s2.size() != 0) {
                s1.push(s2.pop());
            }

            return front;
        }
        return -1; // Queue is empty
    }

    public boolean empty() {
        return s1.size() == 0;
    }

    public static void main(String[] args) {

        Problem_232 queue = new Problem_232();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front element: " + queue.peek()); // 10

        System.out.println("Removed: " + queue.pop()); // 10
        System.out.println("Front element: " + queue.peek()); // 20

        queue.push(40);

        System.out.println("Removed: " + queue.pop()); // 20
        System.out.println("Removed: " + queue.pop()); // 30
        System.out.println("Removed: " + queue.pop()); // 40

        System.out.println("Is queue empty? " + queue.empty()); // true
    }
}