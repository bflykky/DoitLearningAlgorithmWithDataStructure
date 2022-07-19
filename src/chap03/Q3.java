package chap03;

public class Q3 {
	public static void main(String[] args) {

	}
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;
		int i = 0;
		while (i < n) {
			if (a[i] == key) {
				idx[count] = i;
				count++;
			}
			i++;
		}

		return count;
	}
}
