class Solution {
    static int answer = -1;
    static int[] selected;
    
    static void combi(int[][] dungeons, int idx, int k) {
        if(idx == dungeons.length) {
            int cnt = 0;
            for(int i = 0; i < idx; i++) {
                int min = dungeons[selected[i]][0];
                int x = dungeons[selected[i]][1];
                
                if(min > k || x > k) break;
                k -= x;
                cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i = 0; i < dungeons.length; i++) {
            boolean isUsed = false;
            for(int j = 0; j < idx; j++) {
                if(selected[j] == i)
                    isUsed = true;
            }
            if(!isUsed) {
                selected[idx] = i;
                combi(dungeons, idx + 1, k);
                selected[idx] = 0;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        
        selected = new int[n];
        combi(dungeons, 0, k);
        
        return answer;
    }
}