package chap01;

import java.util.Scanner;

public class Q17 {
    static void npira(int n) {
        int lastLine = (n-1) * 2 + 1;
        int space;
        for (int i = 1; i <= n; i++) {
            space = lastLine - ((i-1)*2 + 1);
            for (int j = 1; j <= lastLine; j++)
                if (j <= space/2 || j > (space/2 + ((i-1)*2 + 1)) )
                    System.out.print(" ");
                else
                    System.out.printf("%d", i % 10);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        npira(10);
    }
}
