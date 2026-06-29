// 735. Asteroid Collision

import java.util.*;

public class Problem_735 {

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0 || s.isEmpty()) {
                s.push(asteroids[i]);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroids[i])) {
                    s.pop();
                }

                if (!s.isEmpty() && s.peek() == Math.abs(asteroids[i])) {
                    s.pop();
                } else {
                    if (s.isEmpty() || s.peek() < 0) {
                        s.push(asteroids[i]);
                    }
                }
            }
        }

        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = { 7, 3, -5 };
        // You can change the input to test different cases.

        int[] result = asteroidCollision(asteroids);

        System.out.println("Remaining Asteroids: " + Arrays.toString(result));
    }
}