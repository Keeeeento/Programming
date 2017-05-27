package pass14_01;

public class HealthRecord {
	private String name; // 名前
	private double height; // 身長 （m単位）

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// 問2
	public HealthRecord(String name, double height) {
		this.name = name;
		this.height = height;
	}

	// 問3
	public HealthRecord(double height) {
		// this.height = height;
		this("", height);
	}

	// 問4
	public double stdWeight(double height) {
		return height * height * 22;
	}

	// 問5
	// public String toString(String name, double height) {
	// return name + " / " + height + "m";
	// }

	public String toString() {
		return name + " / " + height + "m";
	}

}
