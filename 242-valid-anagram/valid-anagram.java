// //brute force tc =o(nlogn),sc=o(1)
// class Solution {
//    public boolean isAnagram(String s, String t) {
//        char[] arr1 = s.toCharArray();
//        char[] arr2 = t.toCharArray();
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//        return Arrays.equals(arr1, arr2);
//    }
// }
//optimal approach 
//tc=o(n) ,sc=o(1)


class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m){
            return false;
        }

        int[] count =new int [26];
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;

        }
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}