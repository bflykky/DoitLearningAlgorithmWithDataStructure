package chap04;
import java.io.*;

class ShareStackTester {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		shareStack s = new shareStack(12); // 최대 100개를 푸시할 수 있는 스택

		while (true) {
			System.out.println("현재 스택 상태");
			for (int i = 0; i < s.capacity; i++) {
				System.out.print(s.shareStk[i] + " ");
			}
			System.out.println();
			System.out.println("현재의 데이터 수");
			System.out.printf("A스택: %d/%d\n", s.sizeA(), s.capacityA());
			System.out.printf("B스택: %d/%d\n", s.sizeB(), s.capacityB());
			System.out.println("(A)A스택 (B)B스택");
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)검색 (6)비움 (7)정보표시 (0)종료");
			System.out.println("예시) A 1");
			System.out.print("입력해주세요 >> ");

			String input = br.readLine();
			String[] splitInput = input.split(" ");
			String whichStack = splitInput[0];
			int menu = Integer.parseInt(splitInput[1]);

			if (menu == 0)
				break;

			//본격 시작-----------
			int x;
			if (whichStack.equals("A")) {
				switch (menu) {
					case 1: // 푸시
						System.out.print("데이터: ");
						x = Integer.parseInt(br.readLine());
						try {
							s.pushA(x);
						} catch (shareStack.OverflowShareStackException e) {
							System.out.println("스택A가 가득 찼습니다.");
						}
						break;

					case 2: // 팝
						try {
							x = s.popA();
							System.out.println("팝한 데이터는 " + x + "입니다.");
						} catch (shareStack.EmptyShareStackException e) {
							System.out.println("스택이 비었습니다.");
						}
						break;

					case 3: // 피크
						try {
							x = s.peekA();
							System.out.println("피크한 데이터는 " + x + "입니다.");
						} catch (shareStack.EmptyShareStackException e) {
							System.out.println("스택이 비었습니다.");
						}
						break;

					case 4: // 덤프
						s.dumpA();
						break;

					case 5: // 검색
						System.out.print("찾는 데이터: ");
						x = Integer.parseInt(br.readLine());
						int n = s.indexOfA(x);
						if (n >= 0)
							System.out.printf("%d는 [%d]에 있습니다.\n", x, n);
						else
							System.out.printf("%d가 없습니다.\n", x);
						break;

					case 6: // 비움
						s.clearA();
						break;

					case 7: // 정보표시
						System.out.println("용량: " + s.capacityA());
						System.out.println("데이터 수: " + s.sizeA());
						System.out.println("비어 " + (s.isEmptyA() ? "있습니다." : "있지 않습니다."));
						System.out.println("가득 " + (s.isFull() ? "찼습니다." : "차지 않았습니다."));
						break;
				}
			}
			else if (whichStack.equals("B")) {
				switch (menu) {
					case 1: // 푸시
						System.out.print("데이터: ");
						x = Integer.parseInt(br.readLine());
						try {
							s.pushB(x);
						} catch (shareStack.OverflowShareStackException e) {
							System.out.println("스택A가 가득 찼습니다.");
						}
						break;

					case 2: // 팝
						try {
							x = s.popB();
							System.out.println("팝한 데이터는 " + x + "입니다.");
						} catch (shareStack.EmptyShareStackException e) {
							System.out.println("스택이 비었습니다.");
						}
						break;

					case 3: // 피크
						try {
							x = s.peekB();
							System.out.println("피크한 데이터는 " + x + "입니다.");
						} catch (shareStack.EmptyShareStackException e) {
							System.out.println("스택이 비었습니다.");
						}
						break;

					case 4: // 덤프
						s.dumpB();
						break;

					case 5: // 검색
						System.out.print("찾는 데이터: ");
						x = Integer.parseInt(br.readLine());
						int n = s.indexOfB(x);
						if (n >= 0)
							System.out.printf("%d는 [%d]에 있습니다.\n", x, n);
						else
							System.out.printf("%d가 없습니다.\n", x);
						break;

					case 6: // 비움
						s.clearB();
						break;

					case 7: // 정보표시
						System.out.println("용량: " + s.capacityB());
						System.out.println("데이터 수: " + s.sizeB());
						System.out.println("비어 " + (s.isEmptyB() ? "있습니다." : "있지 않습니다."));
						System.out.println("가득 " + (s.isFull() ? "찼습니다." : "차지 않았습니다."));
						break;
				}
			}
			else {
				System.out.println("스택이 잘못 입력되었습니다. 다시 시도해 주세요.");
			}
		}

	}
}
