package chap02;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = s.nextInt();

		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]: ", i);
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		reverse(arr);

		System.out.println("-------------------");
		System.out.println("요소를 역순으로 정렬하였습니다.");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]: %d\n", i, arr[i]);
		}

		System.out.printf("배열 요소의 합계: %d", sumOf(arr));
	}

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
		return;
	}

	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			System.out.printf("a[%d]와 a[%d]를 교환합니다.\n", i, a.length - i - 1);
			swap(a, i, a.length - i - 1);

			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
	}

	static int sumOf(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}
