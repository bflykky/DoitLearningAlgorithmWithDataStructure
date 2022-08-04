package chap06;

public class Q9 {
	public static void main(String[] args) {
		int[] testArr1 = { 8, 777, 23, 1, 5002, 16, 90, 4, 2, 7, 6, 2101, 3, 5 , 13, 28, 15, 1003, 11, 85, 50, 52, 42, 10, 998, 80, 231, 101, 160, 902, 402, 22, 74, 65, 36, 58 , 139, 283, 154, 112, 852, 502, 532, 432, 192 };
		int[] testArr2 = { 8, 777, 23, 1, 5002, 16, 90, 4, 2, 7, 6, 2101, 3, 5 , 13, 28, 15, 1003, 11, 85, 50, 52, 42, 10, 998, 80, 231, 101, 160, 902, 402, 22, 74, 65, 36, 58 , 139, 283, 154, 112, 852, 502, 532, 432, 192 };
			System.out.println("버전 1 이동 횟수: " + shellSortVer1(testArr1, testArr1.length));
		System.out.println("버전 2 이동 횟수: " + shellSortVer2(testArr2, testArr2.length));

		String output1 = "[ ";
		for (int num : testArr1)
			output1 += num + " ";
		output1 += "]";

		System.out.println(output1);

		String output2 = "[ ";
		for (int num : testArr2)
			output2 += num + " ";
		output2 += "]";

		System.out.println(output2);
	}

	static int shellSortVer1(int[] a, int n) {
		int count = 0;
		for (int h = n / 2; h > 0; h /= 2) {
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					count++;
				}

				a[j + h] = tmp;
				count++;
			}
		}
		return count;
	}

	static int shellSortVer2(int[] a, int n) {
		int h;
		int count = 0;
		for (h = 1; h < n / 9; h = h * 3 + 1) ;

		System.out.println("길이: " + n);
		System.out.println("h: " + h);

		if (h > n / 9)
			h /= 3;

		for (; h > 0; h /= 3) {
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					count++;
				}
				a[j + h] = tmp;
				count++;
			}
		}
		return count;
	}
}
