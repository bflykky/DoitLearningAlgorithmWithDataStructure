package chap05;

public class Q9 {
	static boolean[] flag_a = new boolean[8];
	static boolean[] flag_b = new boolean[15];
	static boolean[] flag_c = new boolean[15];
	static int[] pos = new int[8];

	public static String str = "";


	//8퀸 문제를 비재귀적으로 구현하시오.
	public static void main(String[] args) {
		nonRecurSet(0);
//		System.out.println(str);
	}

	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
//			str += String.format("%2d", pos[i]);
//		str += "\n";
	}

	static void nonRecurSet(int i) {
		IntStack iStack = new IntStack(80);
		IntStack jStack = new IntStack(80);
		int j = 0;
		Start: while (true) {

			while(j < 8) {
				if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) {
					pos[i] = j;
					if (i == 7)
						print();
					else {
						flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
						iStack.push(i++);
						jStack.push(j);
						j = 0;
						continue Start;
					}
				}
				j++;
			}

			if (iStack.isEmpty())
				return;
			if (j == 8) {
				i = iStack.pop();
				j = jStack.pop();
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++;
			}
		}


	}
}
