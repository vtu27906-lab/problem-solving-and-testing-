import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();

        int n = text.length();
        int m = pattern.length();

        // Create LPS array
        int[] lps = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        // KMP pattern matching
        int i = 0;
        j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    System.out.print((i - j) + " ");
                    j = lps[j - 1];
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        sc.close();
    }
}