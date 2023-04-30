class Solution {
    
    static int N;
    
    public long solution(int n, int[] times) {
        long answer = 0;
        N = n;
        
        long L = 1, R = (long) Math.pow(10, 18);
        while(L < R) {
            long mid = (L + R) / 2;
            if(isAvailable(mid, times)) {
                R = mid;
                answer = mid;
            } else {
                L = mid + 1;
            }
        }
        
        return answer;
    }
    
    static boolean isAvailable(long x, int[] times) {
        long total = 0;
        for(int time : times) {
            total += x / (long) time;
        }
        
        return total >= (long) N;
    }
}