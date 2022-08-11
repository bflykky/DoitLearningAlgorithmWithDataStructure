package chap09;

public class Q2 {
	public static void main(String[] args) {
		LinkedList<Integer> test = new LinkedList<>();

		test.addFirst(3);
		test.addFirst(16);
		test.addFirst(4);
		test.addLast(7);
		test.addFirst(1);
		test.addFirst(12);
		test.addFirst(5);

		test.dump();

		System.out.println("------------");
		System.out.println(test.retrieve(3));



	}
}
