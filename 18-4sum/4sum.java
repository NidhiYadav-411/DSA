class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int k = i + 1; k < nums.length - 2; k++) {

                if (k > i + 1 && nums[k] == nums[k - 1]) continue;

                int left = k + 1;
                int right = nums.length - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[k] + nums[left] + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i], nums[k], nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}