import java.util.*;

class Solution {
    
    private static int N, M;
    
    public int solution(int[] mats, String[][] park) {
        int length = 0;
        
        N = park.length;
        M = park[0].length;
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length; j++) {
                String s = park[i][j];
                
                if(s.equals("-1")) {
                    length = Math.max(length, findMaxLength(i, j, park));
                }
            }
        }
        
        int answer = -1;
        Arrays.sort(mats);
        
        for(int i = 0; i < mats.length; i++) {
            if(mats[i] <= length) {
                answer = mats[i];
            } else {
                break;
            }
        }
        
        return answer;
    }
    
    private static int findMaxLength(int x, int y, String[][] park) {
        int max = 1;
        int w = 2;
        while(true) {
            boolean flag = true;
            
            if(x + w > N || y + w > M) break;
            
            for(int i = x; i < x + w; i++) {
                for(int j = y; j < y + w; j++) {
                    if(!park[i][j].equals("-1")) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(!flag) break;
            
            max = w;
            w++;
        }
        
        return max;
    }
}