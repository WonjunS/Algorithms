class Solution {
    
    private static int[] servers;
    private static int M, K;
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        M = m;
        K = k;
        servers = new int[k];
        
        for(int i = 0; i < players.length; i++) {
            int start = i;
            int end = i + 1;
            
            int users = players[i];
            
            // 이용자가 m명 미만인 경우
            if(users < m) {
                // 1. 서버 개수 업데이트
                updateServerCount(0);
            } 
            
            // 이용자가 m명 이상인 경우
            else {
                // 1. 현재 활성화된 서버의 수 확인
                int count = getTotalServerCount();
                
                // 2. 필요한 서버의 수
                int reqCnt = users / m;
                
                if(count >= reqCnt) {
                    updateServerCount(0);
                } else {
                    int newCnt = reqCnt - count;
                    updateServerCount(newCnt);
                    answer += newCnt;
                    // System.out.println(">>> " + start + " ~ " + end + " = " + newCnt);
                }
            }
            
            // System.out.println(start + " ~ " + end + " = " + getTotalServerCount());
        }
        
        return answer;
    }
    
    // 현재 활성화된 서버의 개수
    private static int getTotalServerCount() {
        int total = 0;
        for(int i = 1; i < K; i++) {
            total += servers[i];
        }
        
        return total;
    }
    
    private static void updateServerCount(int cnt) {
        for(int i = 1; i < K - 1; i++) {
            servers[i] = servers[i + 1];
        }
        servers[K - 1] = cnt;
    }
}