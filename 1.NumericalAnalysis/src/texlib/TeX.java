package texlib;

public class TeX {

	/**
	 * section
	 * @param name セクション名
	 */
	public static void section(String name) {
		System.out.printf("\\section{%s}\n\n", name);
	}

	/**
	 * subSection
	 * @param name サブセクション名
	 */
	public static void subSection(String name) {
		System.out.printf("\\subsection{%s}\n\n", name);
	}

	/**
	 * beginTable
	 * 表のはじめ
	 * 中央ぞろえ
	 * @param n 要素の個数
	 */
	public static void beginTable(int n) {
		System.out.println("\\begin{table}[h!!]");
		System.out.println("   \\begin{center}");
		System.out.print("      \\begin{tabular}{");

		for (int i = 0; i < n - 1; i++) {
			System.out.print("c|");
		}
		System.out.println("c}");
	}

	public static void beginTable(String[] indexes) {
		beginTable(indexes.length);
		index(indexes);
	}

	/**
	 * index
	 * 表の見出し
	 * @param indexes
	 */
	public static void index(String[] indexes) {
		int n = indexes.length;
		System.out.print("         ");
		for (int i = 0; i < n - 1; i++) {
			System.out.printf("$%s$ & ", indexes[i]);
		}
		System.out.printf("$%s$ \\\\ \\hline\n", indexes[n - 1]);

	}

	/**
	 * endTable
	 * 表の終わり
	 */
	public static void endTable() {
		System.out.println("      \\end{tabular}");
		System.out.println("   \\end{center}");
		System.out.printf("\\end{table}\n\n");
	}
}
