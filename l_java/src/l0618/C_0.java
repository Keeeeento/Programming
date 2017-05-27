package l0618;

public class C_0 {

	public static void main(String[] args) {
		int[][] M = { { 2, 1, 3, 3, 4 }, { 1, 2, 1, 4, 2 }, { 2, 4, 1, 4, 3 }, { 4, 1, 2, 2, 4 }, { 2, 4, 4, 3, 4 } };
		int count = 0;
		int FullCount = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				if (i == 0) {
					if (j == 0) {
						if (M[i][j] == M[i + 1][j]) {
							count += 1;
						}
						if (M[i][j] == M[i][j + 1]) {
							count += 1;
						}

					} else if (j == M[i].length - 1) {

						if (M[i][j] == M[i + 1][j]) {
							count += 1;
						}

						if (M[i][j] == M[i][j - 1]) {
							count += 1;
						}
					} else {
						if (M[i][j] == M[i + 1][j]) {
							count += 1;
						}

						if (M[i][j] == M[i][j + 1]) {
							count += 1;
						}
						if (M[i][j] == M[i][j - 1]) {
							count += 1;
						}
					}
					if (count == M[i][j]) {
						FullCount += M[i][j] * M[i][j];

					}
				} else if (i == M.length - 1) {
					if (j == 0) {
						if (M[i][j] == M[i - 1][j]) {
							count += 1;
						}
						if (M[i][j] == M[i][j + 1]) {
							count += 1;
						}

					} else if (j == M[i].length - 1) {

						if (M[i][j] == M[i - 1][j]) {
							count += 1;
						}

						if (M[i][j] == M[i][j - 1]) {
							count += 1;
						}
					} else {
						if (M[i][j] == M[i - 1][j]) {
							count += 1;
						}

						if (M[i][j] == M[i][j - 1]) {
							count += 1;
						}
						if (M[i][j] == M[i][j + 1]) {
							count += 1;
						}
					}
					if (count == M[i][j]) {
						FullCount += M[i][j] * M[i][j];
					}
				} else {
					if (j == 0) {
						if (M[i][j] == M[i - 1][j]) {
							count += 1;
						}
						if (M[i][j] == M[i][j + 1]) {
							count += 1;
						}
						if (M[i][j] == M[i + 1][j]) {
							count += 1;
						}

					} else if (j == M[i].length - 1) {
						if (M[i][j] == M[i - 1][j]) {
							count += 1;
						}
						if (M[i][j] == M[i][j - 1]) {
							count += 1;
						}
						if (M[i][j] == M[i + 1][j]) {
							count += 1;
						}

					} else {

						if (M[i][j] == M[i - 1][j]) {
							count += 1;
						}

						if (M[i][j] == M[i][j - 1]) {
							count += 1;
						}

						if (M[i][j] == M[i + 1][j]) {
							count += 1;
						}
						if (M[i][j] == M[i][j + 1]) {
							count += 1;

						}
					}
					if (count == M[i][j]) {
						FullCount += M[i][j] * M[i][j];

					}

				}
			}

		}
		System.out.println(FullCount);
	}

}
