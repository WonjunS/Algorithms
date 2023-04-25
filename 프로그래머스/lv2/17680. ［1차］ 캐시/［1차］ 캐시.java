import java.util.*;

class Solution {
    
    static int answer;
    static List<String> list;
    
    public int solution(int cacheSize, String[] cities) {
        list = new ArrayList<>();
        for(String city : cities) {
            if(cacheSize == 0) {
                answer += 5;
                continue;
            }
            if(list.size() < cacheSize) {
                if(list.contains(city.toLowerCase())) {
                    answer += 1;
                    list.add(city.toLowerCase());
                    continue;
                } else {
                    answer += 5;
                    list.add(city.toLowerCase());
                    continue;
                }
            } else {
                if(list.contains(city.toLowerCase())) {
                    list.remove(city.toLowerCase());
                    list.add(city.toLowerCase());
                    answer += 1;
                    continue;
                } else {
                    list.remove(0);
                    list.add(city.toLowerCase());
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}