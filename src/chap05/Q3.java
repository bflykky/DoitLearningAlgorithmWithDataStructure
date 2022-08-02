package chap05;

public class Q3 {
	public static void main(String[] args) {

	}

	static int gcd(int x, int y) {
//		재귀 메소드 이용.
		int r = x % y;
		if (r == 0)
			return y;
		else
			return gcd(y, r);
	}

	static int gcd(int[] a) {
		int result = gcd(a[0], a[1]);
		for (int i = 2; i < a.length; i++)
			result = gcd(result, a[i]);

		return result;
	}
}
