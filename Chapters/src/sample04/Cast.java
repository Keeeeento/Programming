package sample04;

public class Cast {

	public static void main(String[] args) {
		int n, m, k;
		double x = 52.76;
		n = (int) 123456789L; // longのリテラルをintにキャスト
		m = (int) x; // doubleの変数（の値）をintにキャスト
		k = (int) (x + 3.8); // 式x+3.8（の値）をintにキャスト

		System.out.println(n);
		System.out.println(m);
		System.out.println(k);
	}

}
