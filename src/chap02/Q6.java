package chap02;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		char[] cno = new char[32];

		System.out.println("10진수를 기수 변환합니다.");
		do {
			System.out.print("변환하는 음이 아닌 정수: ");
			no = s.nextInt();
		} while (no < 0);

		do {
			System.out.print("어떤 진수로 변환할까요? (2 ~ 36): ");
			cd = s.nextInt();
		} while (cd < 2 || cd > 36);

		dno = CardConvRev.cardConv(no, cd, cno);

		System.out.printf("%d진수로는 ", cd);
		for (int i = 0; i <= dno; i++)
			System.out.print(cno[i]);

		System.out.println("입니다.");

	}
}

class CardConvRev {
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);

		return digits;
	}

	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);



		reverse(d, 0, --digits);

		return digits;
	}

	static void swap(char[] a, int idx1, int idx2) {
		char tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
		return;
	}

	static void reverse(char[] a, int idx1, int idx2) {
		for (int i = idx1; i < (idx2 + 1) / 2; i++) {
			swap(a, i, idx2 - i);
		}
	}
}
