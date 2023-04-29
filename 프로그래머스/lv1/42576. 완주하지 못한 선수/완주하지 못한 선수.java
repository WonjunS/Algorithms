import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(participant)
            .forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        for(String player : completion) {
            int cnt = map.get(player);
            if(cnt == 1) {
                map.remove(player);
                continue;
            }
            map.put(player, cnt - 1);
        }
        
        String answer = "";
        for(String ky : map.keySet()) {
            answer = ky;
        }
        
        return answer;
    }
}