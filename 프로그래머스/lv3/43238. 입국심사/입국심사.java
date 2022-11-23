class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long L = 1, R = (long) Math.pow(10, 18);
        
        while(L <= R) {
            long mid = (L + R) / 2;
            if(determination(times, mid, n)) {
                R = mid - 1;
                answer = mid;
            } else {
                L = mid + 1;
            }
        }
        
        return answer;
    }
    
    static boolean determination(int[] times, long mid, int n) {
        long total = 0;
        for(int i = 0; i < times.length; i++) {
            total += mid / (long) times[i];
        }
        return total >= (long) n;
    }
}