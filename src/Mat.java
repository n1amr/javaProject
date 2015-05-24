import java.util.Scanner;

public class Mat {
    private float[][] data;
    private int n, m;
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Mat(int n, int m) {
	data = new float[n][m];
	this.n = n;
	this.m = m;
    }

    public Mat(String s) {
	Mat.copyMat(this, Mat.valueOf(s));
    }

    public Mat duplicate(Mat src) {
	Mat r = new Mat(src.n, src.m);
	Mat.copyMat(r, src);
	return r;
    }

    private static void copyMat(Mat dst, Mat src) {
	int n = dst.n = src.n;
	int m = dst.m = src.m;
	dst.data = new float[n][m];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < m; j++)
		dst.data[i][j] = src.data[i][j];
    }

    public Mat() {
	new Mat(1, 1);
    }

    public Mat(float k, int n, int m) {
	data = new float[n][m];
	this.n = n;
	this.m = m;

	this.fill(k);
    }

    public static void fill(Mat A, float k) {
	A.fill(k);
    }

    public void fill(float k) {
	Mat r = new Mat(n, m);
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		data[i][j] = k;
	    }
	}
	return r;
    }

    public int getN() {
	return n;
    }

    public int getM() {
	return m;
    }

    @Override
    public String toString() {
	StringBuilder s = new StringBuilder();
	if (name != null) {
	    s.append(name + " = \n");
	}
	s.append("[");
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		s.append("\t");
		s.append(data[i][j]);

	    }
	    s.append("\n");
	}
	s.deleteCharAt(s.length() - 1);
	s.append("\t]");
	return s.toString();
    }

    public static Mat transpose(Mat A) {
	return A.transpose();
    }

    public Mat transpose() {
	Mat ans = new Mat(m, n);
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		ans.data[i][j] = data[j][i];
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

    private static float[] constToVector(float k, int n) {
	float[] ans = new float[n];
	for (int i = 0; i < n; i++) {
	    ans[i] = k;
	}
	return ans;
    }

    private static Mat elementOp(Mat A, Mat B, int Op) {
	int n = A.getN();
	int m = A.getM();
	if (n != B.getN() || m != B.getM()) {
	    System.err.println("Dimension Error");
	    return null;
	}
	Mat ans = new Mat(n, m);
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		ans.data[i][j] = op(A.data[i][j], B.data[i][j], Op);
	    }
	}
	return ans;
    }

    /*
     * Arithmetic Operations
     */
    public static Mat add(Mat A, Mat B) {
	return elementOp(A, B, 1);
    }

    public static Mat minus(Mat A, Mat B) {
	return elementOp(A, B, 2);
    }

    public static Mat times(Mat A, Mat B) {
	return elementOp(A, B, 3);
    }

    public static Mat divide(Mat A, Mat B) {
	return elementOp(A, B, 4);
    }

    public Mat subMat(int n1, int n2, int m1, int m2) {
	Mat ans = new Mat(n2 - n1, m2 - m1);
	for (int i = n1; i < n2; i++) {
	    for (int j = m1; j < m2; j++) {
		ans.data[i - n1][j - m1] = data[i][j];
	    }
	}
	return ans;
    }

    public Mat getRow(int r) {
	return subMat(r, r + 1, 0, m);
    }

    public Mat getColumn(int c) {
	return subMat(0, n, c, c + 1);
    }

    public float getElement(int r, int c) {
	return data[r][c];
    }

    public void setRow(int r, float[] rowData) {
	data[r] = rowData;
    }

    public void setRow(int r, Mat rowData) {
	setRow(r, rowData.data[0]);
    }

    public void setColumn(int c, float[] colData) {
	for (int i = 0; i < n; i++) {
	    data[i][c] = colData[i];
	}
    }

    public void setColumn(int c, Mat colData) {
	setColumn(c, colData.data[0]);
    }

    public void setElement(int r, int c, float x) {
	data[r][c] = x;
    }

    public static Mat inv(Mat A) {
	return A.inv();
    }

    public Mat inv() {
	if (n != m) {
	    System.err.println("Dimension Error");
	    return null;
	}
	float s = 0; // /////////////////////////////////////////
	Mat ans = new Mat(n, n);
	int m = 2 * n;
	Mat S = new Mat(n, m);
	for (int i = 0; i < n; i++) {
	    S.setElement(i, i + n, 1);
	    for (int j = 0; j < n; j++) {
		S.setElement(i, j, this.getElement(i, j));
	    }
	}
	for (int i = 0; i < n; i++) {
	    float pivot = S.getElement(i, i);
	    S.setRow(i, divide(S.getRow(i), new Mat(pivot, 1, m)));

	    for (int j = 0; j < n; j++) {
		if (i == j)
		    continue;
		S.setRow(j, divide(S.getRow(j), new Mat(S.data[j][i], 1, m)));
		S.setRow(j, minus(S.getRow(j), S.getRow(i)));
	    }
	}
	System.out.println(S);
	for (int i = 0; i < n; i++) {
	    S.setRow(i, divide(S.getRow(i), new Mat(S.data[i][i], 1, m)));
	}
	ans = S.subMat(0, n, n, 2 * n);
	return ans;
    }

    public static Mat sumRows(Mat A) {
	Mat ans = new Mat(1, A.m);
	for (int j = 0; j < A.m; j++) {
	    float sum = 0;
	    for (int i = 0; i < A.n; i++) {
		sum += A.data[i][j];
	    }
	    ans.data[0][j] = sum;
	}
	return ans;
    }

    public Mat sumRows() {
	return sumRows(this);
    }

    public Mat sumCols(Mat A) {
	Mat ans = new Mat(A.n, 1);
	for (int i = 0; i < A.n; i++) {
	    float sum = 0;
	    for (int j = 0; j < A.m; j++) {
		sum += A.data[i][j];
	    }
	    ans.data[i][0] = sum;
	}
	return ans;
    }

    public Mat sumCols() {
	return sumCols(this);
    }

    public float sum(Mat A) {
	return sumRows(sumCols(A)).data[0][0];
    }

    public float sum() {
	return sum(this);
    }

    public static Mat multiply(Mat A, Mat B) {
	return A.multiply(B);
    }

    public Mat multiply(Mat A) {
	if (this.m != A.n) {
	    System.err.println("Dimension Error");
	    return null;
	}
	Mat ans = new Mat(this.n, A.m);
	for (int i = 0; i < this.n; i++) {
	    for (int j = 0; j < A.m; j++) {
		ans.data[i][j] = sum(Mat.times(this.getRow(i), A.getColumn(j)
			.transpose()));
	    }
	}
	return ans;
    }

    public static float det(Mat A) {
	return A.det();
    }

    public float det() {
	float sum = 0;
	float sign;
	if (n == 1)
	    return data[0][0];

	for (int i = 0; i < n; i++) {
	    Mat smaller = new Mat(n - 1, m - 1);

	    for (int a = 1; a < n; a++) {
		for (int b = 0; b < n; b++) {
		    if (b < i)
			smaller.data[a - 1][b] = data[a][b];
		    else if (b > i)
			smaller.data[a - 1][b - 1] = data[a][b];
		}
	    }
	    if (i % 2 == 0)
		sign = 1;
	    else
		sign = -1;

	    sum += sign * data[0][i] * smaller.det();
	}
	return sum;
    }

    public static void main(String[] args) {

	String s = "[1,  2.123,3;  \n" + "4,5,6;7,8,9]";
	Mat X = Mat.valueOf(s);
	X.name = "Test Name";
	System.out.println(X);
	// System.out.println(det(Y));

	Scanner in = new Scanner(System.in);

	// while (in.hasNextLine())
	Console.run("a=[1 2 3]");
	Console.run("b=[2;2;2]");
	Console.run("a*b");
    }

    private static boolean isPartOfNumber(char c) {
	return (Character.isDigit(c) || c == '.' || c == 'i' || c == 'j');
    }

    private static Mat valueOf(String s) {
	int rows = 1;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == ';')
		rows++;
	}
	int cols = 0;
	for (int i = 0; i < s.length(); i++) {
	    if (isPartOfNumber(s.charAt(i))) {
		cols++;
		while (isPartOfNumber(s.charAt(i)))
		    i++;
	    }
	    if (s.charAt(i) == ';')
		break;
	}

	Mat X = new Mat(rows, cols);

	int r = 0;
	int c = 0;
	float[] row = new float[cols];
	for (int i = 0; i < s.length(); i++) {
	    // Detect Number
	    while (i < s.length() && !isPartOfNumber(s.charAt(i)))
		i++;

	    // Select Number
	    int num_start = i;
	    while (i < s.length() && isPartOfNumber(s.charAt(i)))
		i++;
	    int num_end = i;

	    if (i < s.length()) {
		String num = s.substring(num_start, num_end).trim();
		float number = Float.valueOf(num);
		row[c++] = number;
	    }
	    if (i < s.length() && (s.charAt(i) == ';' || s.charAt(i) == ']')) {
		X.setRow(r, row);
		r++;
		c = 0;
		row = new float[cols];
	    } else if (i >= s.length()) {
		X.setRow(r, row);
	    }
	}
	return X;
    }
}
