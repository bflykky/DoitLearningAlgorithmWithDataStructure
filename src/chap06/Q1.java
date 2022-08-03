package chap06;

public class Q1 {
	public static void main(String[] args) {
		int[] test = {20 , 8 , 19, 4, 5, 55, 32, 10};
		BubbleSort.bubbleSort(test, 8);

		String output = "[ ";
		for (int a : test)
			output += a + " ";
		output += "]";

		System.out.println(output);
	}
}

class BubbleSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void bubbleSort(int[] a, int n) {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++)
				if (a[j] > a[j + 1])
					swap(a, j, j+1);
		}
	}
}
