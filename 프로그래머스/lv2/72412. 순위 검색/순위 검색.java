import java.util.*;

class Solution {
    
    static String[] infoArr, strings;
    static Map<String, ArrayList<Integer>> scoreMap;
    static List<Integer> answer;
    
    static void dfs(int k, int score) {
        if(k == 4) {
            String str = String.join("", strings);
            if(!scoreMap.containsKey(str)) {
                scoreMap.put(str, new ArrayList<>());
            }
            scoreMap.get(str).add(score);
            return;
        } else {
            strings[k] = infoArr[k];
            dfs(k + 1, score);
            strings[k] = "-";
            dfs(k + 1, score);
        }
    }
    
    static int lowerBound(ArrayList<Integer> list, int score) {
        int L = 0, R = list.size() - 1;
        
        while(L <= R) {
            int mid = (L + R) / 2;
            
            if(list.get(mid) < score) L = mid + 1;
            else R = mid - 1;
        }
        
        return L;
    }
    
    public List<Integer> solution(String[] info, String[] query) {
        answer = new ArrayList<>();
        scoreMap = new HashMap<>();
        
        for(String i : info) {
            strings = new String[4];
            infoArr = i.split(" ");
            int score = Integer.parseInt(infoArr[4]);
            dfs(0, score);
        }
        
        for(String key : scoreMap.keySet()) {
            Collections.sort(scoreMap.get(key));
        }
        
        for(String q : query) {
            String[] str = q.split(" ");
            String key = str[0] + str[2] + str[4] + str[6];
            
            if(!scoreMap.containsKey(key)) {
                answer.add(0);
            } else {
                ArrayList<Integer> list = scoreMap.get(key);
                answer.add(list.size() - lowerBound(list, Integer.parseInt(str[7])));
            }
        }
        
        return answer;
    }
}