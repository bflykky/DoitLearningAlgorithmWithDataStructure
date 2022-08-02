package chap05;

import java.util.Stack;

public class Q7 {
	public static String str1 = "";
	public static String str2 = "";
	static void move(int no, int x, int y) {

		if (no > 1)
			move(no - 1, x, 6 - x - y);

		str1 += String.format("원반[%d]을 %s 기둥에서 %s 기둥으로 옮김\n", no, x, y);
//		System.out.printf("원반[%d]을 %s 기둥에서 %s 기둥으로 옮김\n", no, x, y);

		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	static void move_new(int no, int x, int y) {
		//Q7. 위와 같이 재귀적으로 구현되어 있던 move 메소드를 비재귀적으로 구현하시오.

		/* 꼬리 재귀를 제거한 구현.
		while(true) {
			if (no > 1)
				move_new(no - 1, x, 6 - x - y);
			System.out.printf("원반[%d]을 %d 기둥에서 %d 기둥으로 옮김\n", no, x, y);
			if (no > 1) {
				x = 6 - x - y;
				no--;
				continue;
			}
			else
				break;
		 */

		IntStack noStack = new IntStack(100);
		IntStack xStack = new IntStack(100);
		IntStack yStack = new IntStack(100);
		IntStack step = new IntStack(100);
		int nowStep = 0;

		while (true) {
			step.push(nowStep);
			if (no > 1 && nowStep == 0) {
				noStack.push(no--);
				xStack.push(x);
				yStack.push(y);
				y = 6 - x - y;
				continue;
			}

			do {
				nowStep = step.pop() + 1;

				if (nowStep == 1) { //필요하지 않을까? 11:12
					str2 += String.format("원반[%d]을 %s 기둥에서 %s 기둥으로 옮김\n", no, x, y);
//					System.out.printf("원반[%d]을 %d 기둥에서 %d 기둥으로 옮김\n", no, x, y);
					nowStep++;
				}

				if (no > 1 && nowStep == 2) {
					no = no - 1;
					x = 6 - x - y;
//				y = y;
					nowStep = 0;
					break;
				}
				nowStep++;

				if (noStack.isEmpty()) {
					return;
				}


				if (nowStep == 3) {
					no = noStack.pop();
					x = xStack.pop();
					y = yStack.pop();
				}

			} while (nowStep == 3);
		}
	}

	public static void main(String[] args) {
		move(5, 1, 3);
		System.out.print(str1);
		System.out.println("----------------------");
		move_new(5, 1, 3);
		System.out.print(str2);
		System.out.printf("str1과 str2는 동일한가요?: %s", str1.equals(str2));
	}
}
