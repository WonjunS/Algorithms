class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 100000;
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            long time = calcTime(diffs, times, mid);
            
            if(time <= limit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private static long calcTime(int[] diffs, int[] times, int level) {
        long total = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];
            int prevTime = 0;
            if(i > 0) prevTime = times[i - 1];
            
            if(diff <= level) {
                total += time;
            } else {
                total += (prevTime + time) * (diff - level);
                total += time;
            }
        }
        
        return total;
    }
}