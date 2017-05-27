package sample06;

public class String_Example {

	public static void main(String[] args) {
		int len = "abcあいうえお".length(); // 文字列リテラルにlength()を適用
		System.out.println(len);

		String str ="ABC漢字";
		len = str.length();
		System.out.println(len);

	}

}
