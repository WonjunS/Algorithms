import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) {
                answer.add(i - map.get(c));
                map.put(c, i);
            } else {
                map.put(c, i);
                answer.add(-1);
            }
        }
        
        return answer;
    }
}