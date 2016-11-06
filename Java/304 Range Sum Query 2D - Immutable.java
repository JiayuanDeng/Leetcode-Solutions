public class NumMatrix {
    int[][] m;
    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null) return;
        if (matrix.length == 0 || matrix[0].length == 0) return;
        
        m = new int[matrix.length + 1][matrix[0].length + 1];
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int _row = 1; _row < m.length; _row++){
            for (int _col = 1; _col < m[0].length; _col++){
                m[_row][_col] = matrix[_row - 1][_col - 1];
                sum[_row][_col] = sum[_row - 1][_col] + sum[_row][_col - 1] - sum[_row - 1][_col - 1] + m[_row][_col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int _row1 = row1 + 1, _col1 = col1 + 1, _row2 = row2 + 1, _col2 = col2 + 1;
        if (_row1 > _row2){
            int tmp = _row1;
            _row1 = _row2;
            _row2 = tmp;
        }
        if (_col1 > _col2){
            int tmp = _col1;
            _col1 = _col2;
            _col2 = tmp;
        }
        return sum[_row2][_col2] - sum[_row2][_col1 - 1] - sum[_row1 - 1][_col2] + sum[_row1 - 1][_col1 - 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);