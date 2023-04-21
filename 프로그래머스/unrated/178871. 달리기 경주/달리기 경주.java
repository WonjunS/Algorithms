import java.util.*;

class Solution {
    
    static String[] answer;
    static Map<Integer, String> map1;
    static Map<String, Integer> map2;
    
    public String[] solution(String[] players, String[] callings) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        
        for(int i = 1; i <= players.length; i++) {
            map1.put(i, players[i - 1]);
            map2.put(players[i - 1], i);
        }
        
        for(String calling : callings) {
            int n = map2.get(calling);
            String player = map1.get(n - 1);
            map1.put(n, map1.get(n - 1));
            map2.put(player, n);
            map1.put(n - 1, calling);
            map2.put(calling, n - 1);
        }
        
        answer = new String[players.length];
        for(String k : map2.keySet()) {
            int idx = map2.get(k);
            answer[idx - 1] = k;
        }
        
        return answer;
    }
    
}