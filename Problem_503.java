// 503. Next Greater Element II(Ckeck Circularly)

import java.util.Arrays;
import java.util.Stack;

public class Problem_503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();


        // Traverse from right to left twice for circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[i % n]);
        }

        return nge;
    }

    public static void main(String[] args) {
        Problem_503 solution = new Problem_503();

        int[] nums = {1, 2, 1};

        int[] result = solution.nextGreaterElements(nums);

        System.out.println("Next Greater Elements: "
                + Arrays.toString(result));
    }
}
