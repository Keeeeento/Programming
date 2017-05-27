package pass12_03;

public class Pass12_03 {

	public static void main(String[] args) {

		int[] dots = { 5, 7, 9, 14, 7, 4, 2 };

		graph(dots);

	}

	public static void drow(int dots) {
		for (int i = 0; i < dots; i++) {
			System.out.print("#");
		}
		System.out.println(); // 改行
	}

	//// public static void graph(int[] count) {
	// for (int i = 0; i < count.length; i++) {
	// drow(count[i]);
	// }
	// }

	public static void graph(int[] count) {
		for (int dots : count) {
			drow(dots);
		}
	}
}
