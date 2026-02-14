class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int i=0;
        int j=n-1;
        int maxwater=0;


        while(i<j){
            int weight =j-i;
            int minheight =Math.min(height[i],height[j]);
            int currweight=weight*minheight;
            maxwater=Math.max(maxwater,currweight);
            if (height[i]<height[j]){
                i++;
            }else{
                j--;
            }

        }

        
        return maxwater;
    }
}