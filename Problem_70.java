// 70. Climbing Stairs(DP Problem)

public class Problem_70 {

    // Recursive function
    public static int climbStairs(int n) {

        if (n == 0)
            return 1;

        if (n == 1)
            return 1;

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);

        return left + right;
    }

    public static void main(String[] args) {

        int n = 5;

        int ways = climbStairs(n);

        System.out.println("Number of ways to climb " + n + " stairs = " + ways);
    }
}