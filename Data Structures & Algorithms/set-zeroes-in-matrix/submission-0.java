class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstCol = false, firstRow=false;
        int rows = matrix.length, cols=matrix[0].length;

        for (int c=0;c<cols;c++) {
            if (matrix[0][c] == 0) {
                firstRow=true;
            }
        }

        for (int r=0;r<rows;r++) {
            if (matrix[r][0] == 0) {
                firstCol=true;
            }
        }


        // mark row[0], col[0] as 0 for any 0 found

        for (int i=1;i<rows;i++) {
            for (int j=1;j<cols;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }
            }
        }

        // mark all cells with row[0] or col[0]  as 0

        for (int i=1;i<rows;i++) {
            for (int j=1;j<cols;j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int c=0;c<cols;c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstCol) {
            for (int r=0;r<rows;r++) {
                matrix[r][0] = 0;
            }
        }


        
    }
}
