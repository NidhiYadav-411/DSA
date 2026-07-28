class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int column=matrix[0].length-1;

        while(row<matrix.length && column>=0){
            if(matrix[row][column]==target){
                System.out.println("found key at ("+ row +","+ column+")");
                return true;

            }else if(target<matrix[row][column]){
                column--;

            }else{
                row++;

            }
        }
        System.out.println("key not found");
        return false;

    }
 
}