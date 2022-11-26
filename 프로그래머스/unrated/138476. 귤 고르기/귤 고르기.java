import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int n = tangerine[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> m1, 
                               Map.Entry<Integer, Integer> m2) {
                return m2.getValue() - m1.getValue();
            }
        });
        
        int answer = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> m : list) {
            count += m.getValue();
            answer++;
            if(count >= k) break;
        }
        
        return answer;
    }
}