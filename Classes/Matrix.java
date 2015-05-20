import java.util.*;

public class .Mat {

    public static void main(String[] args) {
	System.out.println("Hello");
	float A[][] = { { 1, 2, 3 }, { 1, -1, 2 }, { 3, 1, 1 } };
	float[][] B = inv(A);
	for (int i = 0; i < B.length; i++) {
	    System.out.println(Arrays.toString(B[i]));
	}
    }

    private static float[][] transpose(float[][] A) {
	int m = A.length, n = A[0].length;
	float[][] ans = new float[n][m];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		ans[i][j] = A[j][i];
	    }
	}
	return ans;
    }

    private static float op(float a, float b, int Op) {
	switch (Op) {
	    case 1:
		return a + b;
	    case 2:
		return a - b;
	    case 3:
		return a * b;
	    case 4:
		return a / b;
	}
	return 0;
    }

    private static float[][] constToMat(float k, int n, int m) {
	float[][] ans = new float[n][m];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		ans[i][j] = k;
	    }
	}
	return ans;
    }

    private static float[] constToVector(float k, int n) {
	float[] ans = new float[n];
	for (int i = 0; i < n; i++) {
	    ans[i] = k;
	}
	return ans;
    }

    private static float[] elementOp(float[] A, float[] B, int Op) {
	return matToVec(elementOp(vecToMat(A), vecToMat(B), Op));
    }

    private static float[][] elementOp(float[][] A, float[][] B, int Op) {
	int n = A.length;
	if (n < 1) {
	    System.err.println("Dimension Error");
	    return null;
	}
	int m = A[0].length;
	if (B.length != n || (B.length < 1 || B[0].length != m)) {
	    System.err.println("Dimension Error");
	    return null;
	}

	float[][] ans = new float[n][m];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		ans[i][j] = op(A[i][j], B[i][j], Op);
	    }
	}
	return ans;
    }

    private static float[][] elementOp(float[][] A, float x, int Op) {
	int n = A.length;
	int m = A[0].length;
	return elementOp(A, constToMat(x, n, m), Op);
    }

    private static float[][] elementOp(float x, float[][] A, int Op) {
	int n = A.length;
	int m = A[0].length;
	return elementOp(A, constToMat(x, n, m), Op);
    }

    private static float[] elementOp(float[] A, float x, int Op) {
	int n = A.length;
	return elementOp(A, constToVector(x, n), Op);
    }

    private static float[] elementOp(float x, float[] A, int Op) {
	int n = A.length;
	return elementOp(A, constToVector(x, n), Op);
    }

    /*
     * Arithmetic Operations
     */
    private static float[][] add(float[][] A, float[][] B) {
	return elementOp(A, B, 1);
    }

    private static float[] add(float[] A, float[] B) {
	return elementOp(A, B, 1);
    }

    private static float[][] minus(float[][] A, float[][] B) {
	return elementOp(A, B, 2);
    }

    private static float[] minus(float[] A, float[] B) {
	return elementOp(A, B, 2);
    }

    private static float[][] times(float[][] A, float[][] B) {
	return elementOp(A, B, 3);
    }

    private static float[] times(float[] A, float[] B) {
	return elementOp(A, B, 3);
    }

    private static float[][] divide(float[][] A, float[][] B) {
	return elementOp(A, B, 4);
    }

    private static float[] divide(float[] A, float[] B) {
	return elementOp(A, B, 4);
    }

    private static float[][] subMat(float[][] A, int n1, int n2, int m1, int m2) {
	float[][] ans = new float[n2 - n1][m2 - m1];
	for (int i = n1; i < n2; i++) {
	    for (int j = m1; j < m2; j++) {
		ans[i - n1][j - m1] = A[i][j];
	    }
	}
	return ans;
    }

    private static float[][] getRowMat(float[][] A, int r) {
	return subMat(A, r, r + 1, 0, A[0].length);
    }

    private static float[][] getColumnMat(float[][] A, int c) {
	return subMat(A, 0, A.length, c, c + 1);
    }

    private static float[] getRow(float[][] A, int r) {
	return A[r];
    }

    private static void setRow(float[][] A, int r, float[] rowData) {
	A[r] = rowData;
    }

    private static float[] getColumn(float[][] A, int c) {
	float[] ans = new float[A[0].length];
	for (int i = 0; i < ans.length; i++) {
	    ans[i] = A[i][c];
	}
	return ans;
    }

    private static void setColumn(float[][] A, int c, float[] colData) {
	int n = A[0].length;
	for (int i = 0; i < n; i++) {
	    A[i][c] = colData[i];
	}
    }

    private static float[][] inv(float[][] A) {
	int n = A.length;
	if (n < 1 || n != A[0].length) {
	    System.err.println("Dimension Error");
	    return null;
	}
	float ans[][] = new float[n][n];
	int m = 2 * n;
	float S[][] = new float[n][m];
	for (int i = 0; i < n; i++) {
	    S[i][i + n] = 1;
	    for (int j = 0; j < n; j++) {
		S[i][j] = A[i][j];
	    }
	}
	for (int i = 0; i < n; i++) {
	    float pivot = S[i][i];
	    S[i] = matToVec(divide(getRowMat(S, i), constToMat(pivot, 1, m)));
	    for (int j = 0; j < n; j++) {
		if (i == j)
		    continue;
		S[j] = divide(S[j], constToVector(S[j][i], m));
		S[j] = minus(S[j], S[i]);

	    }
	}
	for (int i = 0; i < n; i++) {
	    S[i] = divide(S[i], constToVector(S[i][i], m));
	}
	for (int i = 0; i < n; i++) {
	    for (int j = n; j < 2 * n; j++) {
		ans[i][j - n] = S[i][j];
	    }
	}
	return ans;
    }

    private static float[] matToVec(float[][] A) {
	return A[0];
    }

    private static float[][] vecToMat(float[] A) {
	return new float[][] { A };
    }
}
