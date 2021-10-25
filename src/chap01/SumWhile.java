package chap01;

import java.util.Scanner;

public class SumWhile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구한다.");
        System.out.print("n의 값: ");
        int n = s.nextInt();

        int sum = 0;
        int i= 1;

//        while (i <= n) {
//            sum += i;
//            i++;
//        }
        for (i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("1부터 " + n + "까지의 합은 " + sum + "이다.");
        System.out.println("while문(for문)이 끝난 후 i의 값: " + i);
    }
}
