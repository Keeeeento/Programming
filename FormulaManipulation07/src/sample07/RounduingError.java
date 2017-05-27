package sample07;

public class RounduingError {

	public static void main(String[] args) {
		System.out.println(0.1);
		System.out.println(Double.toHexString(0.1)); // 16進数で

		System.out.println(0.1 == 0.3 - 0.2);
		System.out.println(Double.toHexString(0.3 - 0.2));
	}

}
