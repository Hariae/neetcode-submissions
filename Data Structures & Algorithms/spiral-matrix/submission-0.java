class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int up = 0, down = rows-1;
        int left = 0, right = cols-1;
        List<Integer> result = new ArrayList<>();

        while (result.size() < (rows*cols)) {

            // left to right
            for (int c=left;c<=right;c++) {
                result.add(matrix[up][c]);
            }

            // up to down
            for (int r=up+1;r<=down;r++) {
                result.add(matrix[r][right]);
            }

            // right to left
            if (up != down) {
                for (int c=right-1;c>=left;c--) {
                    result.add(matrix[down][c]);
                }
            }
            

            //down to top
            if (left != right) {
                for(int r=down-1;r>up;r--) {
                    result.add(matrix[r][left]);
                }
            }
            

            up++;
            down--;
            left++;
            right--;


        }
        

        return result;
        
    }
}
