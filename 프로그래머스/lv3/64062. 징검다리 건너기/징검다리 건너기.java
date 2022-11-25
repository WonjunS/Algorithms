class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int L = 1, R = 200000000;
        
        while(L <= R) {
            int mid = (L + R) / 2;
            
            if(determination(stones, mid, k)) {
                L = mid + 1;
                answer = mid;
            } else {
                R = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean determination(int[] stones, int mid, int k) {
        int count = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] - mid < 0) count++;
            if(count >= k) return false;
            if(stones[i] - mid >= 0) count = 0;
        }
        return true;
    }
}