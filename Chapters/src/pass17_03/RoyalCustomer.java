package pass17_03;

public class RoyalCustomer extends Customer{
	private double discountRate;
	public RoyalCustomer(double discountRate) {
		super(null);
		this.discountRate = discountRate;
	}

	public void display() {
//		System.out.println(id + "/"+discountRate); // id が不可視
	}

}
