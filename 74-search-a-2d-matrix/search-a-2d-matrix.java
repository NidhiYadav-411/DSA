/*brute force approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean ans=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    ans=true;
                    return ans;
                }
                
            }
        }
        return ans;
        
    }
}*/
//optimal approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;

        while(row < matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if (matrix[row][col]<target){
                row++;
            }
            else if(matrix[row][col]>target){
                col--;

            }
        }
        return false;
        
    }
}