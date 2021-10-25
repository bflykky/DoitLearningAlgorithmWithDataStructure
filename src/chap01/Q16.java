package chap01;
import java.util.Scanner;
public class Q16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("피라미드 출력 프로그램");
        System.out.print("단을 입력하세요: ");
        int n = s.nextInt();

        System.out.println();
        int lastLine = (n-1) * 2 + 1;
        int space;
        for (int i = 1; i <= n; i++) {
            space = lastLine - ((i-1)*2 + 1);
            for (int j = 1; j <= lastLine; j++) {
                if (j <= space/2 || j > (space/2 + ((i-1)*2 + 1)) )
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();

        }


    }
}
