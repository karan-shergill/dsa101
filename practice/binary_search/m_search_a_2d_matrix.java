// https://leetcode.com/problems/search-a-2d-matrix/description/

// Intutive Solution - Apply BS 2 times - first to find possible ROW, then apply BS in that row to find target
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // find row
        int start = 0;
        int end = matrix.length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (matrix[mid][matrix[0].length-1] == target) {
                return true;
            } else if (matrix[mid][matrix[0].length-1] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //start is the ROW on which we can apply BS to find target
        int ROW = start > matrix.length-1 ? matrix.length-1 : start;

        start = 0;
        end = matrix[0].length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (matrix[ROW][mid] == target) {
                return true;
            } else if (matrix[ROW][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

// Intresting Solution: See a sorted matrix as an array

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int start = 0;
        int end = ROW * COL - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            int row = getRow(mid, COL);
            int col = getCol(mid, COL);

            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private int getRow(int mid, int COL) {
        return mid/COL;
    }

    private int getCol(int mid, int COL) {
        return mid%COL;
    }
}

/* Learning:
Its tricky to apply BS on a matrix that is sorted, the trick is to find to map to find row and col to a array index

get_col = array_index % COL
get_row = array_index / COL

TC: O(log(m×n))
*/
