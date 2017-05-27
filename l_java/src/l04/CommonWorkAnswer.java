package l04;

/**
 * Created by Onodera on 2016/05/14.
 */

public class CommonWorkAnswer{
    public static void main(String[] args) {
        System.out.println(Power(5,2));
        System.out.println(Factorial(10));
        System.out.println(MySin(Math.PI/2));
    }

    public static double Power(double k,int n)
    {
        //答えであるdouble型の箱を用意する
        double ans =1.0;
        //n回for文で繰り返す
        for (int i = 0; i < n; i++) {
            //ansにkを掛ける
            ans=ans*k;
            // ans*=k　でも可
        }
        //returnで答えを返す
        return ans;
    }

    public static double Factorial(int n)
    {
        //答えであるdouble型の箱を用意する
        double ans =1.0;

        //nまでfor文で繰り返す
        for (int i = 0; i <n; i++) {
            ans*=(n-i);
        }
        //returnで答えを返す
        return ans;
    }

    public static double MySin(double x){

        //答えであるdouble型の箱を用意する
        double ans =0.0;

        //nまでfor文で繰り返す
        for (int i = 0; i <10; i++) {
            int k=10-i;

            //(-1)^k+1を求める
            double a;
            a=Power(-1,k+1);

            //(2k-1)!を求める
            double b;
            b=Factorial(2*k-1);

            //x^2k-1を求める
            double c;
            c=Power(x,2*k-1);

            ans+=(a/b)*c;
        }
        //returnで答えを返す
        return ans;
    }
}
