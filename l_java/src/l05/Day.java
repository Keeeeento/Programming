package l05;

class Day {
	int year;
	int month;
	int day;

	public String toString() {
		return this.year + "/" + this.month + "/" + this.day;
	}

	Day(int toshi, int tsuki, int hi) {
		this.year = toshi;
		this.month = tsuki;
		this.day = hi;
	}
}
