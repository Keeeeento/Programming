package pass14_02;

public class Exec {

	public static void main(String[] args) {
		Range range = new Range(50.0, 250.0);
		double[] data = { 150.5, 75.1, 35.3, 281.2, 210.3 };

		// for (int i = 0; i < data.length; i++) {
		// if (range.isOk(data[i])==true) {
		// System.out.println(data[i] + " : true");
		// }else if(range.isOk(data[i])==false){
		// System.out.println(data[i]+" : false");
		// }
		// }

		for (double d : data) {
			System.out.println(d + " : " + range.isOk(d));
		}
	}

}

// double min = 50.0;
// double max = 250.0;
//
// double[] data = { 150.5, 75.1, 35.3, 281.2, 210.3 };
//
// for (int i = 0; i < data.length; i++) {
// if (isOk(data[i])==true) {
// System.out.println(data[i] + " : true");
// }else if(isOk(data[i])==false){
// System.out.println(data[i]+" : false");
// }
// }