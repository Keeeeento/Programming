package l04;

public class CommonWork {

	public static void main(String[] args) {

		//System.out.println(Power(2, 20));
		System.out.println(Power(2,10));

		//System.out.println(Fractional(10));

		//System.out.println(sin(Math.PI/2));

	}

	public static double Power(double k, int n) {

		double l = 1;
		for (int i = 0; i < n; i++) {
			l *= k;
		}
		return l;

	}

	public static double Fractional(int n) {
		int f = n;
		n--;
		while (n > 0) {
			f *= n;
			n--;
		}

		return (f);
	}

	public static double sin(double x){
		int i;
		double s=0;
		for(i=0;i<=10;i++){
			s += Power(-1,i)*Power(x,2*i+1)/Fractional(2*i+1);
		}
		return s;

	}

}
