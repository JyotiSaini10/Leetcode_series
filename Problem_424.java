import java.util.Scanner;

public class Problem_424 {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            int maxfeq = 0;

            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'A']++;
                maxfeq = Math.max(maxfeq, hash[s.charAt(j) - 'A']);

                int changes = (j - i + 1) - maxfeq;

                if (changes <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string (uppercase letters only): ");
        String s = sc.next();

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        Problem_424 obj = new Problem_424();
        int result = obj.characterReplacement(s, k);

        System.out.println("Longest length after replacement: " + result);

        sc.close();
    }
}