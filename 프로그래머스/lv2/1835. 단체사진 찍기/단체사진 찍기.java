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
                char a = data[i].charAt(0);
                char b = data[i].charAt(2);
                char comp = data[i].charAt(3);
                int dist = Character.getNumericValue(data[i].charAt(4));
                
                if(comp == '>') {
                    int a_idx = findIndex(a);
                    int b_idx = findIndex(b);
                    
                    if(Math.abs(a_idx - b_idx) <= dist + 1) {
                        return;
                    }
                } else if(comp == '<') {
                    int a_idx = findIndex(a);
                    int b_idx = findIndex(b);
                    
                    if(Math.abs(a_idx - b_idx) >= dist + 1) {
                        return;
                    }
                } else if(comp == '=') {
                    int a_idx = findIndex(a);
                    int b_idx = findIndex(b);
                    
                    if(Math.abs(a_idx - b_idx) != dist + 1) {
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