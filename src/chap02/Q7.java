package chap02;

import java.util.Scanner;

public class Q7 {
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

		dno = ShowCardConvRev.showCardConv(no, cd, cno);

		System.out.printf("%d진수로는 ", cd);
		for (int i = 0; i <= dno; i++)
			System.out.print(cno[i]);

		System.out.println("입니다.");

	}
}

class ShowCardConvRev {
	static int showCardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char middleDot = '\u00B7';
		String middleDots = "" + middleDot + middleDot + middleDot;

		final int DIVIDEND = (int)Math.log10((double)x) + 1;
		final int DIVISOR = (int)Math.log10((double)r) + 1;

		String divisorStr = "%" + DIVISOR + "d |";
		String dividendStr = "%" + (DIVIDEND + 6) +"d";
		String remainderStr = " " + middleDots + "%2c";
		String hr = "  + -----";

		for (int i = 0; i < DIVIDEND + DIVISOR - 1; i++) {
			hr += "-";
		}

		String firstStr = divisorStr + dividendStr;
		System.out.println(String.format(firstStr, r, x));
		System.out.println(hr);

		int remainder;
		while (x != 0) {
			remainder = x % r;
			x /= r;
			if (x == 0) {
				String lastStr = "%" + DIVISOR + "s |" + dividendStr + remainderStr;
				d[digits++] = dchar.charAt(remainder);
				System.out.println(String.format(lastStr, "", x, d[digits - 1]));
				break;
			}
			System.out.print(String.format(divisorStr, r));
			System.out.print(String.format(dividendStr, x));
			d[digits++] = dchar.charAt(remainder);

			System.out.print(String.format(remainderStr, d[digits - 1]));
			System.out.println();
			System.out.println(hr);
		}



//		while (x < 0) {
//			System.out.println(String.format(str, r, x, x % r));
//			System.out.println(hr);
//			d[digits++] = dchar.charAt(x % r);
//			x /= r;
//			System.out.println(String.format(str, r, x, x % r));
//		}
//		System.out.println(hr);
//		String lastStr = "%" + DIVISOR + "s  %" + (DIVIDEND + 8) +"d" + "  " + middleDot + middleDot + middleDot + "%2d";
//		System.out.println(String.format(lastStr, "", x, x % r));


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
