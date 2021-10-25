package chap01;

import java.util.Scanner;

public class Q9 {
    static int sumof(int a, int b) {
        int tmp;
        int sum = 0;
        if (b < a) {
            tmp = b;
            b = a;
            a = tmp;
        }
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("a부터 b까지의 합을 구한다.");
        System.out.print("a의 값: ");
        int a = s.nextInt();
        System.out.print("b의 값: ");
        int b = s.nextInt();


        System.out.printf("%d부터 %d까지의 합: %d\n", a, b, sumof(a, b));
    }
}
