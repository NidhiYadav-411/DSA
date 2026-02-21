/*brute force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
       

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
        
    }
}*/
//optimal solution
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement =target-nums[i];
            if(map.containsKey(complement)){
                return new int []{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
            throw new IllegalArgumentException("no two sum solution");
    }
}
