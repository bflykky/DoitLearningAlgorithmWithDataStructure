package chap05;

import java.util.ArrayList;

public class Q2 {
	public static void main(String[] args) {
		System.out.println("gcd(22, 8): " + gcd(22, 8));
		System.out.println("gcd(12345, 1234): " + gcd(12345, 1234));
		System.out.println("gcd(12, 18): " + gcd(12, 18));
		System.out.println("gcd(60, 48): " + gcd(60, 48));
	}

	static int gcd(int x, int y) {
//		재귀 메소드 이용.
//		int r = x % y;
//		if (r == 0)
//			return y;
//		else return gcd(y, r);

		if (x < y) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		ArrayList<Integer> divisorX = new ArrayList<>();
		ArrayList<Integer> divisorY = new ArrayList<>();

		for (int i = 1; i <= x; i++) {
			if (x % i == 0)
				divisorX.add(i);
		}

		for (int i = 1; i <= y; i++) {
			if (y % i == 0)
				divisorY.add(i);
		}

		int gcd = 0;
		for (int i= 0; i < divisorY.size(); i++) {
			for (int j = 0; j < divisorX.size(); j++) {
				if (divisorY.get(i) == divisorX.get(j)) {
					gcd = divisorY.get(i);
					break;
				}
			}
		}

		return gcd;
	}

}
