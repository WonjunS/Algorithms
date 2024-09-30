import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int h = 1000; h > 0; h--) {
            int over = 0;
            int under = 0;
            
            for(int i = 0; i < citations.length; i++) {
                int citation = citations[i];
                if(citation >= h) over++;
                if(citation <= h) under++;
            }
            
            if(over >= h && h >= under) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}