package chap05;

public class Q1 {
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial(4));
		System.out.println(factorial(3));
		System.out.println(factorial(2));
		System.out.println(factorial(1));
		System.out.println(factorial(6));

	}

	static int factorial(int n) {
//		재귀 메소드 이용
//		if ( n> 0)
//			return n * factorial(n - 1);
//		else
//			return 1;

//		재귀 메소드 대신 for문 이용
		int result = 1;
		for (int i = n; i > 0; i--)
			result *= i;

		return result;
	}


}
