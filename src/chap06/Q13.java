package chap06;

public class Q13 {
	public static void main(String[] args) {
		int[] testArr1 = { 8, 777, 23, 1, 5002, 16, 90, 4, 2, 7, 6, 2101, 3, 5 , 13, 28, 15, 1003, 11, 85, 50, 52, 42, 10, 998, 80, 231, 101, 160, 902, 402, 22, 74, 65, 36, 58 , 139, 283, 154, 112, 852, 502, 532, 432, 192 };

		mixedSortVer1(testArr1, 0, testArr1.length - 1);
		
		String output1 = "[ ";
		for (int num : testArr1)
			output1 += num + " ";
		output1 += "]";

		System.out.println(output1);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	public static void insertionSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > left && a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public static void mixedSortVer1(int[] a, int left, int right) {
		if (right - left + 1 <= 9)
			insertionSort(a, left, right);
		else {
			int pl = left;
			int pr = right;
			int pivot = a[(pl + pr) / 2];

			do {
				while (a[pl] < pivot)
					pl++;
				while (a[pr] > pivot)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);


			if (pr - left <= right - pl) {
				if (pr > left)
					mixedSortVer1(a, left, pr);
				if (pl < right)
					mixedSortVer1(a, pl, right);
			}
			else {
				if (pl < right)
					mixedSortVer1(a, pl, right);
				if (pr > left)
					mixedSortVer1(a, left, pr);
			}
		}
	}

	public static void mixedSortVer2(int[] a, int left, int right) {

	}
}
