package chap07;

import java.util.Arrays;

public class Q1ToQ5 {
	public static void main(String[] args) {
		IntSet s1 = new IntSet(5);
		IntSet s2 = new IntSet(10);
		IntSet s3 = new IntSet(10);
		s1.add(3);
		s1.add(20);
		s1.add(9);
		s1.add(15);
		System.out.println("현재 s1 집합: " + s1);


		s2.add(7);
		s2.add(1);
		s2.add(8);
		s2.add(11);
		s2.add(2);
		System.out.println("현재 s2 집합: " + s2);

		s3.add(11);
		s3.add(4);
		s3.add(7);
		s3.add(10);
		s3.add(5);
		System.out.println("현재 s3 집합: " + s3);

//		s1.add(s2);
//		s1.retain(s2);
//		s1.remove(s2);
//		System.out.println("집합 s1은 집합 s2의 부분집합이다: " + s1.isSubsetOf(s2));
//		System.out.println("집합 s1은 집합 s2의 진부분집합이다: " + s1.isProperSubsetOf(s2));
//		s1.intersectionOf(s2, s3);
		s1.differenceOf(s2, s3);
		System.out.println("현재 s1 집합: " + s1);
	}
}

class IntSet {
	private int max; // 집합의 최대 개수
	private int num; // 집합의 요소 개수
	private int[] set; // 집합 본체

	// 생성자
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; // 집합 배열 생성
		} catch (OutOfMemoryError e) { // 배열 생성 실패
			max = 0;
		}
	}

	// 집합의 최대 개수
	public int capacity() {
		return max;
	}

	// 집합의 요소 개수
	public int size() {
		return num;
	}

	// 집합에서 n을 검색합니다(index 반환).
	public int indexOf(int n) {
		for (int i = 0; i < num; i++)
			if (set[i] == n)
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// 집합에 n이 있는지 없는지 확인합니다.
	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}

	// 집합에 n을 추가합니다.
	public boolean add(int n) {
		if (num >= max || contains(n) == true) // 가득 찼거나 이미 n이 존재합니다.
			return false;
		else {
			set[num++] = n; // 가장 마지막 자리에 추가합니다.
			sort();
			return true;
		}
	}

	// 집합에서 n을 삭제합니다.
	public boolean remove(int n) {
		int idx; // n이 저장된 요소의 인덱스

		if (num <= 0 || (idx = indexOf(n)) == -1) // 비어 있거나 n이 존재하지 않을 때
			return false;
		else {
			set[idx] = set[--num]; // 마지막 요소를 삭제한 곳으로 옮깁니다. + 요소의 개수(num) - 1
			sort();
			return true;
		}
	}

	// 집합 s에 복사합니다.
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num; // 복사할 요소 개수
		for (int i = 0; i < n; i++)
			s.set[i] = set[i];
		s.num = n;
		sort();
	}

	// 집합 s를 복사합니다.
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num; // 복사할 요소 개수
		for (int i = 0; i < n; i++)
			set[i] = s.set[i];
		num = n;
		sort();
	}

	// 집합 s와 같은지 확인합니다.
	public boolean equalTo(IntSet s) {
		if (num != s.num) // 요소 개수가 같지 않으면
			return false; // 집합도 같지 않습니다.

		for (int i = 0; i < num; i++) {
			int j = 0;
			for (; j < s.num; j++)
				if (set[i] == s.set[j])
					break;
			if (j == s.num) // set[i]는 s에 포함되지 않습니다.
				return false;
		}
		return true;
	}

	// 집합 s1과 s2의 합집합을 복사합니다.
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1); // 집합 s1을 복사합니다.
		for (int i = 0; i < s2.num; i++) // 집합 s2의 요소를 추가합니다.
			add(s2.set[i]);
		sort();
	}

	// "{ a b c }"형식의 문자열로 표현을 바꿉니다.
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}

	// ------------------------------ Q1 ------------------------------//
	// 집합이 비어 있는가?
	public boolean isEmpty() {
		return num == 0;
	}

	// 집합이 가득 찼는가?
	public boolean isFull() {
		return num == max;
	}

	// 집합을 비움(모든 요소를 삭제)
	public void clear() {
		num = 0;
	}

	// ------------------------------ Q2 ------------------------------//
	public boolean add(IntSet s) { //합집합
		int addCount = 0;
		for (int i = 0; i < s.size(); i++) {
			if (!contains(s.set[i]))
				addCount++;
		}

		if (addCount == 0)
			return false;

		if (size() + addCount > max) {
			max = (size() + addCount) * 2;
			int[] tmpSet = new int[max];
			for (int i = 0; i < size(); i++)
				tmpSet[i] = set[i];
			set = tmpSet;
		}

		for (int i = 0; i < s.size(); i++) {
			add(s.set[i]);
		}
		sort();
		return true;
	}

	public boolean retain(IntSet s) { //교집합
		//s.set의 요소들을 가지고 있으면 그 요소들을 하나씩 배열에 저장하고 이를 set에 복사하는 게 빠르지 않을까? 예상.
		int beforeSize = size();
		for (int i = 0; i < size(); i++) {
			if (!s.contains(set[i])) {
				remove(set[i]);
				i--; // 끝의 요소를 끌어와서 set[i]에 저장했으니 해당 공간에 저장된 값을 재검사해야 함.
				/* 교재의 답지에서는 "remove 메소드를 통해 맨 끝에 있던 값을 끌어와서 저장했을 때, 해당 값이 교집합에 속하지 않는 경우"를 생각하지 않음. */
			}
		}
		int afterSize = size();

		if (beforeSize == afterSize)
			return false;
		else {
			sort();
			return true;
		}


	}

	public boolean remove(IntSet s) { //차집합
		boolean flag = false;
		for (int i = 0; i < s.size(); i++) {
			int element = s.set[i];
			if (contains(element)) {
				remove(element);
				flag = true;
			}
		}
		sort();
		return flag;
	}

	// ------------------------------ Q3 ------------------------------//
	public boolean isSubsetOf(IntSet s) {
		boolean flag = true;
		for (int i = 0; i < size(); i++) {
			if (s.contains(set[i]) == false)
				flag = false;
		}

		return flag;
	}

	public boolean isProperSubsetOf(IntSet s) {
		boolean flag = true;

		for (int i = 0; i < size(); i++) {
			if (s.contains(set[i]) == false)
				flag = false;
		}

		if (size() == s.size())
			flag = false;

		return flag;
	}

	// ------------------------------ Q4 ------------------------------//
	public void intersectionOf(IntSet s1, IntSet s2) {
		s1.retain(s2);
		set = s1.set;
		num = s1.num;
		max = s1.max;
		sort();
		return;
	}

	public void differenceOf(IntSet s1, IntSet s2) {
		s1.remove(s2);
		set = s1.set;
		num = s1.num;
		max = s1.max;
		sort();
		return;
	}

	// ------------------------------ Q5 ------------------------------//

	private void sort() {
		Arrays.sort(set, 0, num);
	}

}
