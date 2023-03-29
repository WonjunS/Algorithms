import java.util.*;

class Solution {
    
    static int answer;
    static int[] selected;
    static char[] chars = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        answer = 0;
        
        selected = new int[8];
        
        recur(data, 0);
        
        return answer;
    }
    
    static void recur(String[] data, int k) {
        if(k == 8) {
            for(int i = 0; i < data.length; i++) {
                char friend = data[i].charAt(0);
                char opponent = data[i].charAt(2);
                char condition = data[i].charAt(3);
                int dist = Character.getNumericValue(data[i].charAt(4));
                
                int friend_idx = findIndex(friend);
                int opponent_idx = findIndex(opponent);
                
                if(condition == '>') {
                    if(Math.abs(friend_idx - opponent_idx) - 1 <= dist) {
                        return;
                    }
                } else if(condition == '<') {
                    if(Math.abs(friend_idx - opponent_idx) - 1 >= dist) {
                        return;
                    }
                } else if(condition == '=') {
                    if(Math.abs(friend_idx - opponent_idx) - 1 != dist) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        for(int i = 0; i < 8; i++) {
            boolean isSelected = false;
            for(int j = 0; j < k; j++) {
                if(selected[j] == i) {
                    isSelected = true;
                }
            }
            
            if(!isSelected) {
                selected[k] = i;
                recur(data, k + 1);
                selected[k] = -1;
            }
        }
    }
    
    static int findIndex(char c) {
        for(int i = 0; i < selected.length; i++) {
            if(chars[selected[i]] == c) {
                return i;
            }
        }
        
        return -1;
    }
}