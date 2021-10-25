package chap01;

import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구한다.");
        System.out.print("n의 값: ");
        int n = s.nextInt();

        int sum;

        if (n % 2 == 0)
            sum = (1 + n) * (n / 2);
        else
            sum = (1 + n) * (n / 2) + (n / 2 + 1);

        System.out.printf("1부터 n까지의 합: %d\n", sum);
    }
}

