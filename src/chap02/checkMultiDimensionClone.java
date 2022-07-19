package chap02;

public class checkMultiDimensionClone {
	public static void main(String[] args) {
		int[][] a= { {1,2,3}, {4,5,6}};
		int[][] b;
		b = a.clone();
		b[0] = a[0].clone();
		b[1] = a[1].clone();

		b[0][1] = 100;
		b[1][2] = 600;

		System.out.println("배열 a의 요소");
		for (int[] arr: a) {
			for (int num: arr) {
				System.out.printf("%d ", num);
			}
		}
		System.out.println("\n--------------------");
		System.out.println("배열 b의 요소");
		for (int[] arr: b) {
			for (int num: arr) {
				System.out.printf("%d ", num);
			}
		}
	}
}
