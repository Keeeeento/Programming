package inverseMatrix;

import mathlib.LUDecomposition;
import mathlib.Matrix;
import mathlib.Vector;

public class InverseMatrix2 {
	public static void main(String[] args) {
		for (int n = 4; n <= 12; n += 4) {
			System.out.printf("n = %d のとき\n", n);

			Matrix a = new Matrix(n);
			a.hilbert();

			// 1
			/* 無限大ノルムによる条件数を求めよ */
			System.out.printf("κ(A) = %.3e\n", a.getConditionNumber(0));

			// 2
			/*
			 * 連立方程式Ax=b(x= {1,1,…,1})をLU分解によって解き、 得られた近似解x1に対する残差ノルムと誤差ノルムを求めよ。
			 */
			Vector x = new Vector(n);
			x.allNumber(1);
			Vector b = a.multiply(a, x);
			Vector x1 = LUDecomposition.solve(a, b);

			System.out.printf("residualNorm = %.3e\n", a.residual(a, x1, b).getInfinityNorm());
			System.out.printf("errorNorm = %.3e\n", x.getAbsoluteErrorOfInfinityNorm(x1));

			System.out.println();
		}
		// 3
		/*
		 * 条件数の大きさ (1)より、行列サイズnが大きくなるにつれて、条件数は大きくなっている。
		 * 特に、n=12の時、条件数は10^16を上回っており、計算結果に大きな影響を及ぼすと予想される。
		 */
	}
}
