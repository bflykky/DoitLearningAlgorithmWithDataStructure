package chap06;

import java.util.Random;

public class Q14 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int[] testArr1 = new int[100 * 100 * 10]; //1억 개의 요소를 가진 배열.

		for (int i = 0; i < testArr1.length; i++)
			testArr1[i] = rnd.nextInt(200 );

		long startTime;
		long finishTime;
		long secDiffTime;

		startTime = System.currentTimeMillis();
		mixedSortVer1(testArr1, 0, testArr1.length - 1);
		finishTime = System.currentTimeMillis();

		secDiffTime = (finishTime - startTime);

		System.out.println("정렬 소요 시간: " + secDiffTime);

		startTime = System.currentTimeMillis();
		String output1 = "[ ";
		for (int num : testArr1)
			output1 += num + " ";

		output1 += "]";
		finishTime = System.currentTimeMillis();

		secDiffTime = (finishTime - startTime);

		System.out.println("정렬 합치는 시간: " + secDiffTime);
		
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
			int pivot;

			// 피벗 선택하기 방법 1을 사용함.
			int mid = (left + right) / 2;
			int[] tmpArr = { a[left], a[mid], a[right] };
			insertionSort(a, 0, 2);
			a[left] = tmpArr[0];
			a[mid] = tmpArr[1];
			a[right] = tmpArr[2];

			pivot = a[mid];

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
}
