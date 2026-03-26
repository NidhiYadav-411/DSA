class Solution {
    public int[][] merge(int[][] intervals) {
       int  n=intervals.length;

        Arrays.sort (intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List <int[]>result=new ArrayList<>();

       result.add(intervals[0]);

       for (int i=1;i<n;i++){
        int lastinterval[] =result.get(result.size()-1);

        if (lastinterval[1] >= intervals[i][0] && lastinterval[1] <= intervals[i][1]){
            lastinterval[1]=intervals[i][1];
        }
        else if (lastinterval[1]<intervals[i][0]) {
            result.add(intervals[i]);
        }
        else if (lastinterval[1]>intervals[i][1]){
            lastinterval[1]=lastinterval[1];
        }
       }
       return result.toArray(new int [result.size()][]);
        
    }
}