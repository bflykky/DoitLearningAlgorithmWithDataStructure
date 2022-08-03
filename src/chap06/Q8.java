package chap06;

import java.util.Arrays;

public class Q8 {
	public static void main(String[] args) {
		int[][] arr = new int[3][];
		arr[0] = new int[] { 6, 4, 1, 7, 3, 9, 8 };
		arr[1] = new int[] { 3, 4, 2, 3, 1, 5 };
		arr[2] = new int[] { 22, 5, 11, 32, 120, 68, 70 };

		insertionSortBS(arr[0]);
		insertionSortBS(arr[1]);
		insertionSortBS(arr[2]);

		String[] str = new String[3];

		for (int i = 0; i < str.length; i++) {
			str[i] = "[ ";
			for (int num : arr[i])
				str[i] += num + " ";

			str[i] += "]";
		}
		for (int i = 0; i < str.length; i++)
			System.out.printf("str[%d]: %s\n", i, str[i]);

	}

	public static void insertionSortBS(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int point = Arrays.binarySearch(a, 0, i, tmp);

			if (point >= 0)
				point += 1;
			else
				point = -(point + 1);

			for (int j = i; j > point; j--)
				a[j] = a[j - 1];

			a[point] = tmp;
		}
	}
}
