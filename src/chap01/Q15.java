package chap01;

public class Q15 {
    static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    static void triangleLU(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (i > j)
                    System.out.print(" ");
                else
                    System.out.print("*");

            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++)
                if (j < i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("왼쪽 아래 직각삼각형");
        triangleLB(5);
        System.out.println();
        System.out.println("왼쪽 위 직각삼각형");
        triangleLU(5);
        System.out.println();
        System.out.println("오른쪽 위 직각삼각형");
        triangleRU(5);
        System.out.println();
        System.out.println("오른쪽 아래 직각삼각형");
        triangleRB(5);
    }
}
