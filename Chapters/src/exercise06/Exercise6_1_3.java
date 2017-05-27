package exercise06;

public class Exercise6_1_3 {

	public static void main(String[] args) {
		String[] s = { "春", "夏", "秋", "冬" };
		System.out.println("すべての配列は,{ " + s[0] + " , " + s[1] + " , " + s[2] + " , " + s[3] + " }");

		System.out.print("すべての配列は,{");
		for (int i = 0; i < s.length - 1; i++) {
			System.out.print(" " + s[i] + " ,");
		}
		System.out.print(" " + s[s.length - 1] + " }");

	}

}
