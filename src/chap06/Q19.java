package chap06;

public class Q19 {
	public static void main(String[] args) {
		int[] testArr = {-8, 77, 23, 1, 52, 16, -90, 4, 2, -7, 6, 211, -3, 5, 13, -28, 15, -103, -11, 85, 50, -52, 42, 0, 10};
		int[] testArr1 = {-8, 15, -3, 6, 7, -2, 0, -6, -7, 11, 13, 4, 7, 0, 10};

		String output = "[ ";
		for (int num : testArr1)
			output += num + " ";
		output += "]";

		System.out.println("정렬 전: " + output);
		System.out.println();

		fSort(testArr1, testArr1.length, -8, 15);

		String newOutput = "[ ";
		for (int num : testArr1)
			newOutput += num + " ";
		newOutput += "]";

		System.out.println("정렬 후: " + newOutput);
	}

	static void fSort(int[] a, int n, int min, int max) {
		int[] negf = new int[-(min) + 1];
		int[] posf = new int[max + 1];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) { //1단계
			int point = a[i];
			if (point < 0)
				negf[-point]++;
			else
				posf[point]++;
		}

		for (int i = min + 1; i <= max; i++) { //2단계
			if (i < 0)
				negf[-i] += negf[-i + 1];
			else if (i == 0)
				posf[i] += negf[1];
			else
				posf[i] += posf[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			int point = a[i];
			if (point < 0)
				b[--negf[-point]] = a[i];
			else
				b[--posf[point]] = a[i];
		}

		for (int i = 0; i < n; i++)
			a[i] = b[i];

	}
}
