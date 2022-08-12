package chap10;

public class Q2 {
	public static void main(String[] args) {
		BinTree<Integer, Integer> test = new BinTree<>();

		test.add(9, 9);
		test.add(5, 5);
		test.add(7, 7);
		test.add(6, 6);
		test.add(8, 8);
		test.add(10, 10);
		test.add(11, 11);
		test.add(12, 12);
		test.add(2, 2);
		test.add(4, 4);
		test.add(1, 1);
		test.add(3, 3);

		System.out.printf("가장 작은 키를 가진 노드의 키, 데이터: %d, %d\n", test.getMinKey(), test.getDataWithMinKey());
		System.out.printf("가장 큰 키를 가진 노드의 키, 데이터: %d, %d\n", test.getMaxKey(), test.getDataWithMaxKey());
	}
}
