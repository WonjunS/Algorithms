import java.util.*;

class Solution {
    
    private static int answer, curr, streak, time;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        Arrays.sort(attacks, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        curr = health;
        
        for(int i = 0; i < attacks.length; i++) {
            int attk_t = attacks[i][0];
            int attk_d = attacks[i][1];
            
            while(time < attk_t) {
                time++;
                streak++;
                if(streak == bandage[0]) {
                    curr = Math.min(curr + bandage[1] + bandage[2], health);
                    streak = 0;
                } else {
                    curr = Math.min(curr + bandage[1], health);
                    
                }
            }
            
            attack(attk_d);
            
            if(curr <= 0) {
                answer = -1;
                break;
            }
        }
        
        if(answer != -1) {
            answer = curr;
        }
        
        return answer;
    }
    
    private static void attack(int attk_d) {
        curr = curr - attk_d;
        streak = 0;
        
        time++;
    }
    
}