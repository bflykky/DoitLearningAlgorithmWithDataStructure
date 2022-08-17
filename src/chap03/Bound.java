package chap03;

import java.io.*;

//이진 검색을 비튼 문제일 시 알아두어야 할 알고리즘 => upper bound, lower bound(상계와 하계)
public class Bound {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	}

	private static int upperBound(int[] a, int n) {
		int low = 0;
		int high = a.length; //가장 큰 값의 upper bound를 구할 경우 [a.length] 값이 리턴되므로, a.length에서 시작해야 함.
		int mid = -1;
		while (low < high) {
			mid = (low + high) / 2;
			if (a[mid] <= n)
				low = mid + 1;
			else if (a[mid] > n)
				high = mid;
		}
		mid = (low + high) / 2;
		return mid;
	}

	private static int lowerBound(int[] a, int n) {
		int low = 0;
		int high = a.length;
		int mid = -1;
		while (low < high) {
			mid = (low + high) / 2;
			if (a[mid] < n)
				low = mid + 1;
			else if (a[mid] >= n)
				high = mid;
		}
		mid = (low + high) / 2;
		return mid;
	}
}
