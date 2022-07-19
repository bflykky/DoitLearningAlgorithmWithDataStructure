package chap03;

public class Q5 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9 };
		int firstIdx = binSearchX(arr, 11, 7);
		System.out.println("검색한 요소 중 가장 작은 인덱스 값: " + firstIdx);
	}

	static int binSearchX(int[] a, int n, int key) { //이진 검색 시 찾는 요소 중 가장 앞의 인덱스 값을 반환하는 메소드.
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key) {
				while (a[pc - 1] == key) { //가장 앞의 인덱스르 찾아가는 while문
					pc--;
				}
				return pc;
			}
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return -1;
	}
}
