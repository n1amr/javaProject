public class Mat {
    private float[][] data;
    private int numberOfRows, numberOfColumns;
    private String name = null;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /***
     * Create empty matrix with specified dimensions
     * 
     * @param rows
     *            number of rows
     * @param cols
     *            number of columns
     * ***/
    public Mat(int rows, int cols) {
	data = new float[rows][cols];
	this.numberOfRows = rows;
	this.numberOfColumns = cols;
    }

    /*** Create a matrix from a string ***/
    public Mat(String s) {
	Mat.copyMat(this, Mat.fromString(s));
    }

    /** Creates a new copy of passed matrix **/
    public Mat duplicate(Mat src) {
	Mat r = new Mat(src.getNumberOfRows(), src.getNumberOfColumns());
	Mat.copyMat(r, src);
	return r;
    }

    private static void copyMat(Mat destination, Mat source) {
	int n = source.numberOfRows;
	int m = source.numberOfColumns;

	destination = new Mat(n, m);

	for (int i = 0; i < n; i++)
	    for (int j = 0; j < m; j++)
		destination.setElement(i, j, source.getElement(i, j));
    }

    public Mat(float sigleElement) {
	numberOfRows = numberOfColumns = 1;
	data = new float[1][1];
	setElement(0, 0, sigleElement);
    }

    public Mat() {
	new Mat(0);
    }

    public Mat(float k, int rows, int cols) {
	data = new float[rows][cols];
	this.numberOfRows = rows;
	this.numberOfColumns = cols;

	this.fill(k);
    }

    public static void fill(Mat A, float k) {
	A.fill(k);
    }

    public void fill(float k) {
	for (int i = 0; i < numberOfRows; i++) {
	    for (int j = 0; j < numberOfColumns; j++) {
		setElement(i, j, k);
	    }
	}
    }

    public int getNumberOfRows() {
	return numberOfRows;
    }

    public int getNumberOfColumns() {
	return numberOfColumns;
    }

    @Override
    public String toString() {
	StringBuilder s = new StringBuilder();
	// if (name != null) {
	// s.append(name + " = \n");
	// }
	s.append("[");
	for (int i = 0; i < numberOfRows; i++) {
	    for (int j = 0; j < numberOfColumns; j++) {
		s.append("\t");
		s.append(getElement(i, j));
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
	int n = getNumberOfRows();
	int m = getNumberOfColumns();
	Mat mat = new Mat(n, m);
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		mat.setElement(i, j, getElement(j, i));
	    }
	}
	return mat;
    }

    private static final int OP_ADD = 1;
    private static final int OP_SUBTRACT = 2;
    private static final int OP_MULTIPLY = 3;
    private static final int OP_DIVIDE = 4;

    private static float op(float a, float b, int Op) {
	switch (Op) {
	    case OP_ADD:
		return a + b;
	    case OP_SUBTRACT:
		return a - b;
	    case OP_MULTIPLY:
		return a * b;
	    case OP_DIVIDE:
		return a / b;
	    default:
		// throw new Exception("Not a supported operation: " + Op);
	}
	return 0;
    }

    private static Mat elementOp(Mat A, Mat B, int Op) {
	int n = A.getNumberOfRows();
	int m = A.getNumberOfColumns();
	if (n != B.getNumberOfRows() || m != B.getNumberOfColumns()) {
	    // throw new Exception("Dimensions mismatch", new Throwable());
	    System.err.println("Dimension Error");
	    return null;
	}
	Mat ans = new Mat(n, m);
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		float val = op(A.getElement(i, j), B.getElement(i, j), Op);
		ans.setElement(i, j, val);
	    }
	}
	return ans;
    }

    /*
     * Arithmetic Operations
     */
    public static Mat add(Mat A, Mat B) {
	return elementOp(A, B, OP_ADD);
    }

    public static Mat subtract(Mat A, Mat B) {
	return elementOp(A, B, OP_SUBTRACT);
    }

    public static Mat times(Mat A, Mat B) {
	return elementOp(A, B, OP_MULTIPLY);
    }

    public static Mat divide(Mat A, Mat B) {
	return elementOp(A, B, OP_DIVIDE);
    }

    public Mat subMat(int fromRow, int toRow, int fromColumn, int toColumn) {
	Mat ans = new Mat(toRow - fromRow, toColumn - fromColumn);
	for (int i = fromRow; i < toRow; i++) {
	    for (int j = fromColumn; j < toColumn; j++) {
		ans.setElement(i - fromRow, j - fromColumn,
			this.getElement(i, j));
	    }
	}
	return ans;
    }

    public Mat getRow(int row) {
	return subMat(row, row + 1, 0, numberOfColumns);
    }

    public float[] getRowAsArray(int row) {
	return getRow(row).data[0];
    }

    public Mat getColumn(int column) {
	return subMat(0, numberOfRows, column, column + 1);
    }

    public float[] getColumnAsArray(int column) {
	float[] arr = new float[this.getNumberOfRows()];
	for (int i = 0; i < arr.length; i++) {
	    arr[i] = this.getElement(i, column);
	}
	return arr;
    }

    public float getElement(int row, int column) {
	return data[row][column];
    }

    public void setRow(int row, float[] rowData) {
	data[row] = rowData;
    }

    public void setRow(int row, Mat rowData) {
	if (rowData.getNumberOfRows() != 0 && rowData.getNumberOfColumns() != 0) {
	    if (rowData.getNumberOfRows() == 1
		    && rowData.getNumberOfColumns() == this
			    .getNumberOfColumns()) {
		setRow(row, rowData.getRowAsArray(0));
	    } else if (rowData.getNumberOfColumns() == 1
		    && rowData.getNumberOfRows() == this.getNumberOfRows()) {
		setRow(row, rowData.getColumnAsArray(0));
	    }
	} else {
	    // throw new Exception("Dimensions error", new Throwable());
	}
    }

    public void setColumn(int column, float[] colData) {
	for (int i = 0; i < numberOfRows; i++) {
	    this.setElement(i, column, colData[i]);
	}
    }

    public void setColumn(int column, Mat colData) {
	if (colData.getNumberOfRows() != 0 && colData.getNumberOfColumns() != 0) {
	    if (colData.getNumberOfRows() == 1
		    && colData.getNumberOfColumns() == this
			    .getNumberOfColumns()) {
		setColumn(column, colData.getRowAsArray(0));
	    } else if (colData.getNumberOfColumns() == 1
		    && colData.getNumberOfRows() == this.getNumberOfRows()) {
		setColumn(column, colData.getColumnAsArray(0));
	    }
	} else {
	    // throw new Exception("Dimensions error", new Throwable());
	}

	setColumn(column, colData.data[0]);
    }

    public void setElement(int row, int column, float val) {
	data[row][column] = val;
    }

    public static Mat inv(Mat A) {
	return A.inv();
    }

    public Mat inv() {
	if (numberOfRows != numberOfColumns) {
	    System.err.println("Dimension Error");
	    return null;
	}
	float s = 0; // /////////////////////////////////////////

	Mat ans = new Mat(getNumberOfRows(), getNumberOfRows());

	int n = getNumberOfRows();
	int m = getNumberOfColumns();
	int m2 = 2 * getNumberOfColumns();

	Mat S = new Mat(n, m2);

	// Initialize
	for (int i = 0; i < n; i++) {
	    S.setElement(i, i + m, 1);
	    for (int j = 0; j < m; j++) {
		S.setElement(i, j, this.getElement(i, j));
	    }
	}

	for (int i = 0; i < n; i++) {
	    float pivot = S.getElement(i, i);

	    Mat newPivotRow = divide(S.getRow(i), new Mat(pivot, 1, m2));
	    S.setRow(i, newPivotRow);

	    for (int j = 0; j < n; j++) {
		if (i == j)
		    continue;// was set before
		Mat normalizedRow = divide(S.getRow(j),
			new Mat(S.getElement(j, i), 1, m2));
		S.setRow(j, normalizedRow);
		S.setRow(j, subtract(S.getRow(j), S.getRow(i)));
	    }
	}

	// Normalize
	for (int i = 0; i < n; i++) {
	    S.setRow(i, divide(S.getRow(i), new Mat(S.data[i][i], 1, m2)));
	}

	ans = S.subMat(0, n, m, m2);
	return ans;
    }

    public static Mat sumRows(Mat A) {
	return A.sumRows();
    }

    public Mat sumRows() {
	int n = this.getNumberOfRows();
	int m = this.getNumberOfColumns();
	Mat ans = new Mat(1, m);

	for (int j = 0; j < m; j++) {
	    float columnSum = 0;
	    for (int i = 0; i < n; i++) {
		columnSum += this.getElement(i, j);
	    }
	    ans.setElement(0, j, columnSum);
	}
	return ans;
    }

    public static Mat sumCols(Mat A) {
	return A.sumCols();
    }

    public Mat sumCols() {
	int n = this.getNumberOfRows();
	int m = this.getNumberOfColumns();
	Mat ans = new Mat(n, 1);

	for (int i = 0; i < n; i++) {
	    float rowSum = 0;
	    for (int j = 0; j < m; j++) {
		rowSum += this.getElement(i, j);
	    }
	    ans.setElement(i, 0, rowSum);
	}
	return ans;
    }

    public float sum() {
	return sumRows().sumCols().getElement(0, 0);
    }

    public float sum(Mat A) {
	return A.sum();
    }

    public static Mat multiply(Mat A, Mat B) {
	return A.multiply(B);
    }

    public Mat multiply(Mat A) {
	// [n][m] * [m][p] = [n][p]
	int n = this.getNumberOfRows();
	int m = this.getNumberOfColumns();
	int p = A.getNumberOfColumns();

	if (m != A.numberOfRows) {
	    System.err.println("Dimension Error");
	    return null;
	}

	Mat ans = new Mat(n, p);

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < p; j++) {
		ans.setElement(i, j, sum(Mat.times(this.getRow(i),
			A.getColumn(j).transpose())));
	    }
	}
	return ans;
    }

    public float det() {
	float sum = 0;
	float sign;
	if (numberOfRows == 1)
	    return data[0][0];

	for (int i = 0; i < numberOfRows; i++) {
	    Mat smaller = new Mat(numberOfRows - 1, numberOfColumns - 1);

	    // Copy determinant to smaller except current row & column
	    for (int a = 1; a < numberOfRows; a++) {
		for (int b = 0; b < numberOfRows; b++) {
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

    public static float det(Mat A) {
	return A.det();
    }

    public static void main(String[] args) {

	String s = "[2,1 ; 7,4]";
	Mat X = Mat.fromString(s);
	X = X.transpose();
	X.name = ".Solution Name";
	System.out.println(X);
	// System.out.println(det(Y));

	// Scanner in = new Scanner(System.in);

	// while (in.hasNextLine())
	// Console.run("a=[1 2 3]");
	// Console.run("b=[2;2;2]");
	// Console.run("a*b");
    }

    private static boolean isPartOfNumber(char c) {
	return (Character.isDigit(c) || c == '.' || c == 'i' || c == 'j');
    }

    private static Mat fromString(String s) {

	// Determine number of rows
	int rows = 1;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == ';')
		rows++;
	}

	// Determine number of columns
	int cols = 0;
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (isPartOfNumber(c)) {
		cols++;
		while (i < s.length() && isPartOfNumber(c) && c != ';') {
		    i++;
		    c = s.charAt(i);
		}
	    }
	    if (c == ';')
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
	    int num_end = i; // Exclusive

	    if (i < s.length()) {
		String num = s.substring(num_start, num_end).trim();
		float number = Float.valueOf(num);
		row[c] = number;
		c++;
		if (c == row.length) {
		    while (i < s.length() && s.charAt(i) != ';')
			i++;
		}
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
