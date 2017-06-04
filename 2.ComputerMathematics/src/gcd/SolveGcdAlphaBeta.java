package gcd;

public class SolveGcdAlphaBeta {
	public static void main(String[] args) {
		int [] q = {5,50,1,3};
		solveAlphaBeta(q);
	}

	public static void solveAlphaBeta(int[] q) {
		int n = q.length;
		int[][][] a = new int[n][2][2];
		for (int m = 0; m < n; m++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (i != j) {
						a[m][i][j] = 1;
					} else if (i * j == 1) {
						a[m][i][j] = -q[m];
					}
				}
			}
		}
		int[][][] b = new int[n][2][2];
		for (int m = n - 2; m >= 0; m--) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < 2; k++) {

						b[m][i][j] += a[m][i][k] * a[m + 1][k][j];

					}
				}
			}
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					a[m][i][j] = b[m][i][j];
				}
			}
		}

		System.out.println("alpha = " + a[0][0][0] + ",\nbeta = " + a[0][0][1]);
	}

	public static int[] solveQs(int a, int b) { // 未完成
		int q = 1;
		int count = 0;
		int[] fake = new int[100];
		int temp=0;
		while (b * q <= a) {
			q++;
			if (b * q > a) {
				temp = b;
				b = a - b * q;
				a = temp;
				fake[count] = q;
				q = 1;
				count++;
			}

		}int[] Q = new int [count];
		for(int i= 0;i<count;i++) {
			Q[i] = fake[i];
		}

		return Q;
	}

}
