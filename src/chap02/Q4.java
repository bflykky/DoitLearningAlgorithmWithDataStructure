package chap02;

public class Q4 {
	public static void main(String[] args) {
		int[] arr1 = new int[5];
		int[] arr2 = {1, 2, 3, 4, 5};

		copy(arr1, arr2);
		for (int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d]: %d\n", i, arr1[i]);
		}
		System.out.println("--------------------------------");
		rcopy(arr1, arr2);
		for (int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d]: %d\n", i, arr1[i]);
		}
	}

	static void copy(int[] a, int[] b) { //b의 모든 요소를 a에게 복사하는 메소드.
		if (a.length != b.length) {
			System.out.println("두 배열의 길이가 다릅니다. 다시 확인해 주세요.");
			return;
		}
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
	}

	static void rcopy(int[] a, int[] b) {
		if (a.length != b.length) {
			System.out.println("두 배열의 길이가 다릅니다. 다시 확인해 주세요.");
			return;
		}
		for (int i = 0; i < b.length; i++) {
			a[(b.length - 1) - i] = b[i];
		}
	}
}
