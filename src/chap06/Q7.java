package chap06;

public class Q7 {
	public static void main(String[] args) {
		int[] arr = {0, 22, 5, 11, 32, 120, 68, 70}; //a[0]은 쓰레기 값.
		insertionSortSen(arr);

		System.out.print("[ ");
		for (int num : arr) {
			System.out.printf("%d ", num);
		}
		System.out.println("]");
	}

		public static void insertionSortSen(int[] a) {
		for (int i = 2; i < a.length; i++) {
			int j;
			int tmp = a[0] = a[i];
			/*
			a[0]에 꼭 -10 같이 지정해서 넣을 필요 없이,
			아래 조건식 a[j-1] > tmp에서 보초 지점에서 빠져나올 수만 있으면 되므로
			a[0]에도 tmp를 넣어 j - 1 = 0일 때 조건식 값이 false가 되도록 만들어준다.
			 */
			for (j = i; a[j - 1] > tmp; j--)
				a[j] = a[j - 1];

			a[j] = tmp;
		}
	}
}
