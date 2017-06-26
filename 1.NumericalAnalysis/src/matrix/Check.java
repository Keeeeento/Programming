package matrix;

public class Check {
	public static void main(String[] args) {
		double [][] data = {{1,2,3},{2,3,4},{3,4,5}};
		Matrix a = new Matrix(data);
		a.scalarMultiple(3);
		a.print();
	}
}
