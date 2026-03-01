class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
            
            // Early exit if we find 9 (maximum possible digit)
            if (maxDigit == 9) {
                return 9;
            }
        }
        
        return maxDigit;
    }
}