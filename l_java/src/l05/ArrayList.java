package l05;

public class ArrayList {

	public enum Subject {
		MATHEMATICS, PHYSICS, CHEMISTRY, ENGLISH;
	}

	public static void main(String[] args) {
		Subject s = Subject.MATHEMATICS;
		function(s);
		s = Subject.PHYSICS;
		function(s);
		s = Subject.CHEMISTRY;
		function(s);
		s = Subject.ENGLISH;
		function(s);
	}

	public static void function(Subject s) {
		switch (s) {
		case MATHEMATICS:
			System.out.println("数学");
			break;
		case PHYSICS:
			System.out.println("物理");
			break;
		case CHEMISTRY:
			System.out.println("化学");
			break;
		case ENGLISH:
			System.out.println("英語");
			break;
		}

	}
}
