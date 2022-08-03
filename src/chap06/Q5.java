package chap06;

public class Q5 {
	public static void main(String[] args) {
		int[] test = {20 , 8 , 19, 4, 5, 55, 32, 10};
		cocktailSort(test, 8);
		String output = "[ ";
		for (int num: test)
			output += num + " ";
		output += "]";

		System.out.println(output);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	public static void cocktailSort(int[] a, int n) {
		int oddK = 0;
		int evenK = n - 1;
		int count = 1;

		while (oddK < n - 1 && evenK > 0) {
			if (count % 2 != 0) { //count가 홀수면
				int last = n - 1;
				for (int j = evenK; j > oddK; j--)
					if (a[j - 1] > a[j]) {
						swap(a, j - 1, j);
						last = j;
					}

				oddK = last;
			} else {
				int last = 0;
				for (int j = oddK; j < evenK; j++)
					if (a[j] > a[j + 1]) {
						swap(a, j, j + 1);
						last = j;
					}

				evenK = last;
			}

			count++;
		}
	}

}
