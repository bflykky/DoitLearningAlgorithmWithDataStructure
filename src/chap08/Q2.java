package chap08;

public class Q2 {
	public static void main(String[] args) {
		String txt = "AGCAIOLSKDCAOKCLQEHGVHAIOLSKDKDKSLIOIIQPKCKOLFJSLDIO";
		String pat = "IOLS";
		int num;

		System.out.println(bfMatch(txt, pat));
		System.out.println(num = bfMatchLast(txt, pat));
		System.out.println(txt.substring(num, num + pat.length()));
	}

	public static int bfMatch(String txt, String pat) {
		int pt = 0;
		int pp = 0;

		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			}
			else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}

		if (pp == pat.length())
			return pt - pp;

		return - 1;
	}

	public static int bfMatchLast(String txt, String pat) {
		//Q2. 텍스트에 패턴이 여러 개 있을 경우 가장 뒤에 위치한 패턴의 인덱스 리턴하기.
		//그러면, 그냥 맨 뒤부터 검사하자.
		int pt = txt.length() - 1;
		int pp = pat.length() - 1;

		int count = 0;
		while (pt >= 0 && pp >= 0) { //pt만 0 미만이 되면 텍스트의 뒤부터 앞까지 전부 검사했다는 의미. pp가 0보다 작아지면 패턴을 찾았다는 의미.
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt--;
				pp--;
				count++;
			}
			else {
				pt = pt + count - 1;
				pp = pat.length() - 1;
				count = 0;
			}
		}

		if (pp == -1)
//			return pt + pat.length(); 이건 패턴의 끝부분 인덱스 반환
			return pt + 1;

		return -1;
	}


}
