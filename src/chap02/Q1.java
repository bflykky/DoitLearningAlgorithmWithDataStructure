package chap02;

import java.util.Scanner;
import java.util.Random;

public class Q1 {
	public static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}

		return max;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("키의 최댓값 구하기");
		int num = rand.nextInt(100) + 1;

		int[] height = new int[num];

		System.out.println("키 값은 아래와 같다.");
		for (int i = 0; i < height.length; i++) {
			height[i] = 150 + rand.nextInt(40) + 1;
			System.out.printf("height[%d]: %d\n", i, height[i]);
		}

		System.out.printf("최댓값은 %d이다.", maxOf(height));

	}
}
