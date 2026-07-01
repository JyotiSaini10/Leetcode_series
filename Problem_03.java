import java.util.Arrays;
import java.util.Scanner;

public class Problem_03 {

    public int lengthOfLongestSubstring(String s) {

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, right = 0, maxLen = 0, currLen = 0;

        while (right < s.length()) {

            if (hash[s.charAt(right)] != -1) {
                // Character already exists in the current window
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }

            currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);

            hash[s.charAt(right)] = right;
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        String s = sc.nextLine();

        Problem_03 obj = new Problem_03();
        
        int result = obj.lengthOfLongestSubstring(s);

        System.out.println(result);

        sc.close();
    }
}