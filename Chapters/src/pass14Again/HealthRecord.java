package pass14Again;

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

	public HealthRecord(String name, double height) {
		this.name = name;
		this.height = height;
	}

	public HealthRecord(double height) {
		this("", height);
	}

	public double stdWeight() {
		return height * height * 22;
	}

	public String toString() {
		return "「" + name + "/" + height + "m」";
	}
	
	
}