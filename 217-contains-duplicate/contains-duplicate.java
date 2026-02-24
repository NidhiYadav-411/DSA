/*brute force approach
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
        
    }
}*/
//optimized approach
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> intSet= new HashSet<>();

        for(int num=0;num<nums.length;num++){
            if(intSet.contains(nums[num])){
                return true;
            }
            intSet.add(nums[num]);
        }
        return false;
        
    }
}