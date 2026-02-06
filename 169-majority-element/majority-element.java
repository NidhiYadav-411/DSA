class Solution {
    public static int majorityElement(int[] nums) {

        
        int count=0;
        int ans=nums[0];

        
       
        for (int i=0;i<nums.length;i++){
           
                if(count==0){
                    ans =nums[i];
                }
                if (ans==nums[i]){
                    count++;
                }
               
                else{
                    count--;

                }
                
                
            
        }
        return ans;


    }
    public static void main (String [] args ){
        int nums[]={1,1,2,3,4,2,2,2,2};
        int result = majorityElement(nums);
        System.out.println("majority: " +result);
    }
}