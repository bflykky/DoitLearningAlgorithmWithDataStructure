package chap01;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr;

        System.out.println("1부터 n까지의 합을 구한다.");
        System.out.print("n의 값: ");
        int n = s.nextInt();
        arr = new int[n];

        int sum = 0;
        int i= 1;

        for (i = 1; i <= n; i++) {
            sum += i;
            arr[i-1] = i;
        }

        for (int h = 0; h < n; h++) {
            if (h != n-1)
                System.out.printf("%d + ", arr[h]);
            else
                System.out.printf("%d = ", arr[h]);
        }
        System.out.println(sum);
    }
}
