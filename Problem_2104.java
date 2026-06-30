import java.util.*;

public class Problem_2104 {

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Arrays.fill(nse, n);

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Arrays.fill(pse, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }

    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Arrays.fill(nge, n);

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }

    private int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Arrays.fill(pge, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                pge[i] = st.peek();
            }
            st.push(i);
        }
        return pge;
    }

    private long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total += left * right * (long) arr[i];
        }
        return total;
    }

    private long sumSubarrayMax(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);

        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            total += left * right * (long) arr[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Problem_2104 obj = new Problem_2104();
        long ans = obj.subArrayRanges(nums);

        System.out.println("Sum of Subarray Ranges = " + ans);

        sc.close();
    }
}