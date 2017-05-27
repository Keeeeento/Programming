package pass10;

import lib.Input;

public class No1 {
	public static void main(String arg[]) {
		/*String Eword = Input.getString("英単語を入力してください");
		String Jword;
		if (Eword == "dog") {
			Jword = "いぬ";
			System.out.println(Eword + "は日本語で" + Jword + "です.");
		} else if (Eword == "cat") {
			Jword = "ねこ";
			System.out.println(Eword + "は日本語で" + Jword + "です.");
		} else if (Eword == "mouse") {
			Jword = "ねずみ";
			System.out.println(Eword + "は日本語で" + Jword + "です.");
		} else if (Eword == "rabbit") {
			Jword = "うさぎ";
			System.out.println(Eword + "は日本語で" + Jword + "です.");
		} else {
			Jword = "?";
			System.out.println(Eword + "は日本語で" + Jword + "です.");
		}*/
		String Eword;
		String Jword;
		while((Eword=Input.getString("英単語を入力してください"))!=null){
			if (Eword.equals("dog")) {
				Jword = "いぬ";
			} else if (Eword .equals("cat")) {
				Jword = "ねこ";
			} else if (Eword .equals("mouse")) {
				Jword = "ねずみ";
			} else if (Eword .equals("rabbit")) {
				Jword = "うさぎ";
			} else {
				Jword ="?";
			}
			System.out.println(Eword + "は日本語で「" + Jword + "」です.");

		}
	}

}
