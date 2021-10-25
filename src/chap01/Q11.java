package chap01;
import java.util.Scanner;
public class Q11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a;
        System.out.print("양의 정수를 입력하세요: ");
        a = s.nextInt();

        int digit = 0;
        int num = 1;
        while (true) {
            if (a / num > 0)
                digit++;
            else
                break;
            num *= 10;
        }
        System.out.println(a + "의 자릿수: " + digit);


    }
}
