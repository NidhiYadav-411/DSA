
//chatgpt
class Solution {
public:
    int minimizeArrayValue(vector<int>& nums) {
        long long sum = 0;  // prefix sum
        int ans = 0;        // final minimized maximum

        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            // use integer math for ceil(sum / (i+1))
            int val = (sum + i) / (i + 1);
            ans = max(ans, val);
        }

        return ans;  // return the minimized maximum
    }
};