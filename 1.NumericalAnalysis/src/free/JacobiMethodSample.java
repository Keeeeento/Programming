package free;

/**
 * Jacobi class provides the eigenvalue and eigenvector matrices
 * of an n x n symmetric matrix, matToDiagonalize. <br>
 * First call jacRot(RealMat matToDiagonalize) to get the eignevalue matrix
 * of the matrix matToDiagonalize <br>
 * Then call getMatR() to get the eigenvector matrix of the
 * matrix matToDiagonalize
 */
public class Jacobi extends RealMat {

	private int p, q; //indices of the largest off-diagonal element
	private RealMat matR = new RealMat(), //eigenvector square real matrix
			matA = new RealMat(); //eigenvalue square real matrix

	//---------------------//
	// Default constructor //
	//---------------------//

	public Jacobi() {
	}

	//---------//
	// Getters //
	//---------//

	/**
	 * Get the eigenvector matrix.
	 * @return the eigenvector matrix matR (a square real matrix)
	 */
	public RealMat getMatR() {
		return matR;
	}

	/**
	 * Find the sign of a real number.
	 * @param x the number with type double
	 * @return -1 if x is a negative number or 1 otherwise
	 */
	private int sign(double x) {
		if (x < 0)
			return -1;
		return 1;
	}

	/**
	 * Provide the n x n square real diagonal eigenvalue matrix matA
	 * and the n x n square real matrix matR with eigenvectors in rows.
	 * @param matToDiagonalize the original n x n square real matrix
	 * @return the eigenvalue matrix matA
	 */
	public RealMat jacobiRotation(RealMat matToDiagonalize) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matA.re[i][j] = matToDiagonalize.re[i][j];

		int iter = 0;

		for (int i = 0; i < n; i++)
			for (int z = 0; z < n; z++)
				matR.re[i][z] = 0.0; // RAZ

		for (int i = 0; i < n; i++)
			matR.re[i][i] = 1.0; // unit matrix

		String etat = "ITERATING";
		double tolerance = 0.00001;
		int maxIter = 1000;

		while (etat == "ITERATING") {
			double max = maxOffDiag();
			if (max > tolerance) {
				rotate();
				if (++iter == maxIter) {
					etat = "WONSTOP";
					System.out.println("maximum iteration reached");
				}
			} else {
				etat = "SUCCESS";
				//        matR = RealMat.transpose(matR); //eigenvectors in rows
			}
		}
		return matA;
	}

	/**
	 * Find the largest off-diagonal element in the eigenvalue matrix.
	 * @return a double value, the absolute value of the largest
	 * off-diagonal element
	 */
	private double maxOffDiag() {
		double max = 0.0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				double aij = Math.abs(matA.re[i][j]);
				if (aij > max) {
					max = aij;
					p = i;
					q = j;
				}
			}
		}
		return max;
	}

	/**
	 * Rotates matrix matA through theta in pq-plane to set matA.re[p][q] = 0 <br>
	 * Rotation stored in matrix matR whose columns are eigenvectors of matA
	 */
	private void rotate() {
		// d = cot 2*theta, t = tan theta, c = cos theta, s = sin theta
		double d = (matA.re[p][p] - matA.re[q][q]) / (2.0 * matA.re[p][q]);
		double t = sign(d) / (Math.abs(d) + Math.sqrt(d * d + 1));
		double c = 1.0 / Math.sqrt(t * t + 1);
		double s = t * c;
		matA.re[p][p] += t * matA.re[p][q];
		matA.re[q][q] -= t * matA.re[p][q];
		matA.re[p][q] = matA.re[q][p] = 0.0;
		for (int k = 0; k < n; k++) { // Transform matA
			if (k != p && k != q) {
				double akp = c * matA.re[k][p] + s * matA.re[k][q];
				double akq = -s * matA.re[k][p] + c * matA.re[k][q];
				matA.re[k][p] = matA.re[p][k] = akp;
				matA.re[k][q] = matA.re[q][k] = akq;
			}
		}
		for (int k = 0; k < n; k++) { // Store matR.re
			double rkp = c * matR.re[k][p] + s * matR.re[k][q];
			double rkq = -s * matR.re[k][p] + c * matR.re[k][q];
			matR.re[k][p] = rkp;
			matR.re[k][q] = rkq;
		}
	}

}//end of class Jacobi