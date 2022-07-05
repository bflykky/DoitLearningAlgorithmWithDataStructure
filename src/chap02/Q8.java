package chap02;

import java.util.Scanner;

public class Q8 {
	static int[][] mdays = { {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} };

	static int isLeap(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0)
				return 0;

			return 1;
		}
		else
			return 0;
	}

	static int dayOfYear(int y, int m, int d) {
//		int days = d;
//		for (int i = 1; i < m; i++) {
//			days += mdays[isLeap(y)][i - 1];
//		}
//		return days;

		while (--m - 1 >= 0) {
			System.out.println(m);
			d += mdays[isLeap(y)][m - 1];
		}

		return d;
	}

	static int leftDayOfYear(int y, int m, int d) {
		return 365 + isLeap(y) - dayOfYear(y, m, d);
	}

	public static void main(String[] args) {
//		int a = dayOfYear(2019, 3, 15);
//		System.out.println("a: " + a);
		System.out.println(leftDayOfYear(2016, 2, 15));
	}
}
