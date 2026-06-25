// 496. Next Greater Element I

import java.util.Arrays;
import java.util.Stack;

public class Problem_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[10001];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }

    public static void main(String[] args) {
        Problem_496 solution = new Problem_496();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = solution.nextGreaterElement(nums1, nums2);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}