package other;

import java.util.Arrays;
import java.util.Scanner;

public class H001_整数分解 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            Arrays.fill(a, 0);

            for (int i = 1; i <= n; i++) {
                a[0] = i;
                process(a, 1, n - a[0], n);
            }
        }

        scanner.close();
    }

    private static void process(int[] a, int curr, int remain, int n) {
        if (remain == 0) {
            System.out.print(String.format("%s=%s", n, a[0]));
            for (int i = 1; i < curr; i++) {
                System.out.print(String.format("+%s", a[i]));
            }
            System.out.println();
            return;
        }
        for (a[curr] = a[curr - 1]; a[curr] <= remain; a[curr]++) {
            process(a, curr + 1, remain - a[curr], n);
        }
    }

}
