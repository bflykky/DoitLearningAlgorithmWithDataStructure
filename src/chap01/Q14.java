package chap01;
import java.util.Scanner;
public class Q14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("사각형을 출력합니다");
        System.out.print("단 수: ");
        int length = s.nextInt();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                System.out.print("*");
            System.out.println();
        }

    }
}