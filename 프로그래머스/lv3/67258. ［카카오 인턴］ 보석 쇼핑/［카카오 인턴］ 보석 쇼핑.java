import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();        
        int size = new HashSet<>(Arrays.asList(gems)).size();
        
        int L = 0, length = Integer.MAX_VALUE;
        for(int R = 0; R < gems.length; R++) {
            map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);
            
            while(map.get(gems[L]) > 1) {
                map.put(gems[L], map.get(gems[L]) - 1);
                L++;
            }
            
            if(length > (R - L) && map.size() == size) {
                length = R - L;
                answer[0] = L + 1;
                answer[1] = R + 1;
            }
        }
        
        return answer;
    }
}