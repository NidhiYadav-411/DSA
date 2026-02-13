class Solution {
    public static int maxSubArray(int[] nums) {
        int n=nums.length;
        int currsum=nums[0];
        int maxsum=nums[0];

        for(int i=1;i<n;i++){
            currsum=Math.max(currsum+nums[i],nums[i]);
            maxsum =Math.max(currsum,maxsum);
        }
        return maxsum;
        
    }
    public static void main(String [] args){
        int nums[]={-2,1,-3,4,-1,2,1,-5,4};
        int result =maxSubArray(nums);
        System.out.println (result);


    }
}