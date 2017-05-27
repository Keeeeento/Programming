package sample07;

public class ArrayArray {

	public static void main(String[] args) {
		int[][] A = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };

		System.out.println(A[0][0] + "\t" + A[0][1] + "\t" + A[0][2]);
		System.out.println(A[1][0] + "\t" + A[1][1] + "\t" + A[1][2]);
		System.out.println(A[2][0] + "\t" + A[2][1] + "\t" + A[2][2]);

		// System.out.println(A.length);←3
		System.out.println();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.print("\n");

		}
	}

}
