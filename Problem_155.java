// 155. Min Stack

import java.util.Stack;

public class Problem_155 {
    int min;
    Stack<Integer> st;

    public Problem_155() {
        st = new Stack<>();
    }

    public void push(int value) {
        if (st.empty()) {
            min = value;
            st.push(value);
        } else {
            if (value > min) {
                st.push(value);
            } else {
                st.push(2 * value - min);
                min = value;
            }
        }
    }

    public void pop() {
        if (st.empty()) {
            System.out.println("Stack is empty.");
            return;
        }

        int x = st.peek();
        st.pop();

        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        if (st.empty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        int x = st.peek();

        if (x > min) {
            return x;
        }

        return min;
    }

    public int getMin() {
        if (st.empty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        return min;
    }

    public static void main(String[] args) {
        Problem_155 obj = new Problem_155();

        obj.push(5);
        obj.push(3);
        obj.push(7);
        obj.push(2);

        System.out.println("Top element: " + obj.top());
        System.out.println("Minimum element: " + obj.getMin());

        obj.pop();
        System.out.println("After pop:");
        System.out.println("Top element: " + obj.top());
        System.out.println("Minimum element: " + obj.getMin());

        obj.pop();
        System.out.println("After another pop:");
        System.out.println("Top element: " + obj.top());
        System.out.println("Minimum element: " + obj.getMin());
    }
}