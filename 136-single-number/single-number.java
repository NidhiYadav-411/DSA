/* brute force approach
class Solution {
    public static int singleNumber(int[] nums) {
        int n=nums.length ;

        for(int i=0; i<=n-1;i++){
            for (int j=0; j<n-i-1;j++){
                if (nums[j]> nums[j+1]){
                  int temp=nums[j];
                  nums[j]=nums[j+1];
                   nums[j+1]=temp;

                 
                }

            }
        }
        if (nums.length == 1) {
           return nums[0];
}

        int ans =-1;

        for (int i=0;i<n;i++){
            if (i==0){
                if (nums[i]!=nums[i+1]){
                    ans =nums[i];
                    break;


                }
            }else if (i==n-1){
                if (nums[i]!=nums[i-1]){
                    ans=nums[i];
                    break;
                }
            }
            else {
                if (nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                    ans=nums[i];
                    break;
                }

            }
        }

        return ans  ;

        
    }
    public static void main  (String [] args ){
        int nums[]={1,1,2,3,3};
         
         int result= singleNumber(nums);
         System.out.println (result);



    }
}*/
//optimized Approach
class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        for (int val=0;val<nums.length;val++){
            ans=ans^nums[val];
        }
        return ans;
    }
}