package chap05;

public class Q8 {
	//실습 5-9의 print 메소드를 수정하여 전각 기호＠■□
	public static void main(String[] args) {
		set(0);
	}

	static boolean[] flag_a = new boolean[8];
	static boolean[] flag_b = new boolean[15];
	static boolean[] flag_c = new boolean[15];
	static int[] pos = new int[8];

	static void print() {
		// pos의 요소: [ 0 4 7 5 2 6 1 4 ]
		char[][] chessBoard = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoard[i][j] = '□';
			}
		}

		for (int i = 0; i < 8; i++) {
			chessBoard[pos[i]][i] = '■';
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%2c", chessBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			if (flag_a[j] == false && flag_b[i+j] == false && flag_c[i - j + 7] == false) {
				pos[i] = j;
				if (i == 7)
					print();
				else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
					set(i + 1);
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				}
			}
		}
	}

}
