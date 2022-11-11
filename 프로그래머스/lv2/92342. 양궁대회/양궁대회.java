class Solution {
    static int best_score = Integer.MIN_VALUE;
    static int[] answer = { -1 };
    static int[] lion;
    
    public int[] solution(int n, int[] info) {
        lion = new int[11];
        recur(0, n, info);
        
        return answer;
    }
    
    static void recur(int cnt, int n, int[] info) {
        if(cnt == n) {
            int apache_score = 0, lion_score = 0;
            for(int i = 0; i < 10; i++) {
                if(lion[i] != 0 || info[i] != 0) {
                    if(lion[i] <= info[i]) {
                        apache_score += (10 - i);
                    } else {
                        lion_score += (10 - i);
                    }
                }
            }
            if(lion_score > apache_score) {
                if(lion_score - apache_score >= best_score) {
                    answer = lion.clone();
                    best_score = lion_score - apache_score;
                }
            }
            return;
        }
        for(int i = 0; i <= 10 && lion[i] <= info[i]; i++) {
            lion[i]++;
            recur(cnt + 1, n, info);
            lion[i]--;
        }
    }
    
}