package chap03;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q7 {

	static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
		return binarySearch(a, key, c, "ASC");
	}

	static <T> int binarySearch (T[] a, T key, Comparator<? super T> c, String order) { //검색한 값과 동일한 값의 인덱스 반환.
		int low = 0;
		int high = a.length - 1;

		int mid = 0;

		if (order.toUpperCase().equals("ASC")) {
			//오름차순일 때
			while (low <= high) {
				mid = (low + high) / 2;
				T midVal = a[mid];
				int cmp = c.compare(midVal, key);
				
				if (cmp > 0)
					high = mid - 1;
				else if (cmp < 0)
					low = mid + 1;
				else
					return mid;

			}
			return -(mid + 1);
		}
		else if (order.toUpperCase().equals("DESC")) {
			//내림차순일 때
			while (low <= high) {
				mid = (low + high) / 2;
				T midVal = a[mid];
				int cmp = c.compare(midVal, key);

				if (cmp > 0)
					low = mid + 1;
				else if (cmp < 0)
					high = mid - 1;
				else
					return mid;
			}
			return -(mid + 1);
		}
		else {
			System.out.println("넌 틀렸어 병신 하하");
			return -100;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PhysExamSearch.PhyscData[] x = {
						new PhysExamSearch.PhyscData("이수민", 175, 2.0), new PhysExamSearch.PhyscData("홍준기", 171, 1.5),
						new PhysExamSearch.PhyscData("이호연", 174, 1.2), new PhysExamSearch.PhyscData("김한결", 169, 0.8),
						new PhysExamSearch.PhyscData("전서현", 173, 0.7), new PhysExamSearch.PhyscData("유지훈", 168, 0.4),
						new PhysExamSearch.PhyscData("이나령", 162, 0.3), };

		bw.write("시력이 몇인 사람을 찾고 있나요?: ");
		bw.flush();
		double vision = Double.parseDouble(br.readLine());

		int idx = binarySearch(x, new PhysExamSearch.PhyscData("", 0, vision), PhysExamSearch.PhyscData.HEIGHT_order, "DESC");
		System.out.println("idx: " + idx);
		if (idx < 0)
			bw.write("해당 시력을 가진 학생이 없습니다.");
		else {
			bw.write("해당 시력을 가진 학생의 정보입니다.");
			bw.newLine();
			bw.write(String.valueOf(x[idx]));
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

class PhysExamSearch {
	static class PhyscData {
		private String name;
		private int height;
		private double vision;

		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height= height;
			this.vision = vision;
		}

		public String toString() {
			return name + " " + height + " " + vision;
		}

		public static final Comparator<PhyscData> HEIGHT_order = new VisionOrderComparator();

		private static class VisionOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				if (d1.vision > d2.vision)
					return 1;
				else if (d1.vision < d2.vision)
					return -1;
				else
					return 0;
			}
		}

	}
}