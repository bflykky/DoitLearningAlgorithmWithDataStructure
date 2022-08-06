package chap06;

import chap05.IntStack;

public class Q12 {
	public static void main(String[] args) {

	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	//실습 6-9
	public static void quickSortVer1(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = a[ (pl + pr) / 2 ];

		do {
			while (a[pl] < pivot)
				pl++;
			while (a[pr] > pivot)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);

		if (pr - left <= right - pl) {
			if (pr > left)
				quickSortVer1(a, left, pr);
			if (pl < right)
				quickSortVer1(a, pl, right);
		}
		else {
			if (pl < right)
				quickSortVer1(a, pl, right);
			if (pr > left)
				quickSortVer1(a, left, pr);
		}
	}

	//실습 6-10
	public static void quickSortVer2(int[] a, int left, int right) {
		IntStack ls = new IntStack(right - left + 1);
		IntStack rs = new IntStack(right - left + 1);

		ls.push(left);
		rs.push(right);

		while (ls.isEmpty() == false) {
			int pl = left = ls.pop();
			int pr = right = rs.pop();
			int pivot = a[ (pl + pr) / 2 ];

			do {
				while (a[pl] < pivot)
					pl++;
				while (a[pr] > pivot)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			if (pr - left >= right - pl) {
				if (left < pr) {
					ls.push(left);
					rs.push(pr);
				}
				if (right > pl) {
					ls.push(pl);
					rs.push(right);
				}
			}
			else {
				if (right > pl) {
					ls.push(pl);
					rs.push(right);
				}
				if (left < pr) {
					ls.push(left);
					rs.push(pr);
				}
			}
		}



	}
}
