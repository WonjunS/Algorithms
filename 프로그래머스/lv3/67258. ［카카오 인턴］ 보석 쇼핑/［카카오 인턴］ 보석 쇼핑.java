import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int left = 1, right = gems.length;
        int length = Integer.MAX_VALUE;
        
        Set<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        
        int size = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int R = 0;
        for(int L = 0; L < gems.length; L++) {
            while(R < gems.length && map.size() < size) {
                map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);
                R++;
            }
            
            if(length > (R - L) && map.size() == size) {
                left = L + 1;
                right = R;
                length = (R - L);
            }
            
            map.put(gems[L], map.get(gems[L]) - 1);
            
            if(map.get(gems[L]) == 0) {
                map.remove(gems[L]);
            }
        }
        
        int[] answer = {left, right};
        
        return answer;
    }
}