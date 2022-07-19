package chap03;

public class Q1 {
	public int seqSearchSen(int[] a, int n, int key) { //for문 사용
		int i = 0;
		a[n] = key;

		for ( ; a[i]!= key; i++);
		return i == n ? -1 : i;
	}
	public static void main(String[] args) {

	}
}
