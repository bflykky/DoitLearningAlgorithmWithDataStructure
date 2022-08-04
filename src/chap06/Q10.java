package chap06;

public class Q10 {
	public static void main(String[] args) {
		int[] testArr1 = { 5, 8, 4, 2, 6, 1, 3, 9, 7 };
		quickSort(testArr1, testArr1.length);

		String output = "[ ";
		for (int num : testArr1)
			output += num + " ";
		output += "]";

		System.out.println(output);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void quickSort(int[] a, int n) {
		int pl = 0;
		int pr = n - 1;
		int x = a[ (pl + pr) / 2 ];

		do {
			while (a[pl] < x)
				pl++;

			while (a[pr] > x)
				pr--;

			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);

		int[] leftArr = new int[pr + 1];
		int[] rightArr = new int[n - pl];

		for (int i = 0; i < leftArr.length; i++)
			leftArr[i] = a[i];
		for (int i = 0; i < rightArr.length; i++)
			rightArr[i] = a[pl + i];

		if (0 < pr)
			quickSort(leftArr, pr + 1);
		for (int i = 0; i < leftArr.length; i++)
			a[i] = leftArr[i];

		if (pl < n - 1)
			quickSort(rightArr, n - pl);
		for (int i = 0; i < rightArr.length; i++)
			a[pl + i] = rightArr[i];
	}
}
