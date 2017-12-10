package exerciseOfNewtonsMethod;

public class MiniTest {
	public static void main(String[] args) {
		double x = 2;
		double epsilon = 1e-10;
		int iter = 0;
		int maxIter = 1000;

		while (Math.abs(f(x)) >= epsilon) {
			x -= f(x) / df(x);
			iter++;
			if (iter > maxIter) {
				System.out.println("収束しません");
				break;
			}
		}
		System.out.println("反復回数は" + iter + "回");
		System.out.println("近似解は" + x);
	}

	static double f(double x) {
		return x * x - 2;
	}

	static double df(double x) {
		return 2 * x;
	}

	// 注意 : 反復過程で近似解が発散，停滞，あるいは一定の値を繰り返しとることなどにより，収束
	// 判定条件が満たされず，反復が終了しない場合がある．そのため，最大反復回数を設定し，そ
	// の回数を超える場合には反復を強制的に停止するような処理を加える必要がある．
}
