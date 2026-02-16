/*brute force approach
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>=nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    System.out.println(nums);
                }

            }
            

        }
       
        
    }
}*/

/*optimized approach 
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int count0=0;
        int count1=0;
        int count2=0;

        for(int i=0; i<n;i++){
            if(nums[i]==0){
                count0++;
            }else if(nums[i]==1){
                count1++;
            }else {
                count2++;
            }
        }
        int idx=0;
        for(int i=0;i<count0;i++){
            nums[idx++]=0;
        }
        for(int i=0;i<count1;i++){
            nums[idx++]=1;
        }
        for(int i=0;i<count2;i++){
            nums[idx++]=2;
        }
        System.out.println(nums);
        
    }
}*/

//optimal approach in a single pass 
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
               int temp=nums[mid];
                    nums[mid]=nums[low];
                    nums[low]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
               int temp=nums[mid];
                    nums[mid]=nums[high];
                    nums[high]=temp;
                high--;
            }
        }
        
    }
}