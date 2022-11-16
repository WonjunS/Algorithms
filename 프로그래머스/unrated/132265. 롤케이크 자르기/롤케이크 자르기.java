import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int answer = 0;
        
        for(int n : topping) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        
        int idx = topping.length - 1;
        while(map1.size() != map2.size() && idx >= 0) {
            int x = topping[idx--];
            map2.put(x, map2.getOrDefault(x, 0) + 1);
            if(map1.get(x) == 1) {
                map1.remove(x);
            } else {
                map1.put(x, map1.get(x) - 1);
            }
        }
        
        if(idx == 0) return answer;
        
        while(map1.size() == map2.size() && idx >= 0) {
            int x = topping[idx--];
            map2.put(x, map2.getOrDefault(x, 0) + 1);
            if(map1.get(x) == 1) {
                map1.remove(x);
            } else {
                map1.put(x, map1.get(x) - 1);
            }
            answer++;
        }
        
        return answer;
    }
}