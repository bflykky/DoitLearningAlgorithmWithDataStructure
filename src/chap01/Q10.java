package chap01;
import java.util.Scanner;
public class Q10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b;

        System.out.print("a의 값: ");
        a = s.nextInt();
        do {
            System.out.print("b의 값: ");
            b = s.nextInt();
            if (b <= a)
                System.out.println("type the number which is bigger than a");
        } while (b <= a);

        System.out.println("b - a = " + (b - a));

    }
}
