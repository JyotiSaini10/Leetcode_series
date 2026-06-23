// 225. Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

public class Problem_225 {

    Queue<Integer> q;

    public Problem_225() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        Problem_225 stack = new Problem_225();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); // 30

        System.out.println("Popped: " + stack.pop());      // 30
        System.out.println("Top element: " + stack.top()); // 20

        stack.push(40);

        System.out.println("Popped: " + stack.pop());      // 40
        System.out.println("Popped: " + stack.pop());      // 20
        System.out.println("Popped: " + stack.pop());      // 10

        System.out.println("Is stack empty? " + stack.empty()); // true
    }
}
