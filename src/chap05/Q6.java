package chap05;

public class Q6 {
	/*실습 5-6을 숫자가 아닌 문자열로 기둥 이름을 출력하도록 프로그램을 수정하세요.
	예를 들어 'A 기둥', 'B 기둥', 'C 기둥'과 같이 출력하면 됩니다. */
	public static final String FIRST_PILLAR = "A 기둥";
	public static final String MID_PILLAR = "B 기둥";
	public static final String LAST_PILLAR = "C 기둥";
	static void move(int no, int x, int y) {
		//no개의 원반을 x기둥에서 y기둥으로 옮기는 메소드.
		String[] printStr = new String[2];

		for (int i = 0; i < printStr.length; i++) {
			int compareNum = -1;
			if (i == 0)
				compareNum = x;
			else if (i == 1)
				compareNum = y;

			if (compareNum == 1) {
				printStr[i] = FIRST_PILLAR;
			}
			else if (compareNum == 2) {
				printStr[i] = MID_PILLAR;
			}
			else
				printStr[i] = LAST_PILLAR;

		}

		if (no > 1)
			move(no - 1, x, 6 - x - y);

		System.out.printf("원반[%d]을 %s에서 %s으로 옮김\n", no, printStr[0], printStr[1]);

		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args) {
		move(3, 1, 3);
		System.out.println();
		move(4, 1, 3);

	}
}
