import java.util.*;

class Solution {
    
    static int N;
    static String order;
    static List<String> list;
    static Map<String, Integer> map;
    
    public List<String> solution(String[] orders, int[] course) {
        list = new ArrayList<>();
        map = new HashMap<>();
        
        for(int i = 0; i < orders.length; i++) {
            order = sortMenu(orders[i]);
            N = order.length();
            
            combine("", 0);
        }
        
        for(int i = 0; i < course.length; i++) {
            List<String> subList = new ArrayList<>();
            int len = course[i];
            int max = 0;
            
            for(String ky : map.keySet()) {
                int cnt = map.get(ky);
                if(cnt >= 2 && ky.length() == len) {
                    if(max == cnt) {
                        subList.add(ky);
                        continue;
                    }
                    if(cnt > max) {
                        subList.clear();
                        max = cnt;
                        subList.add(ky);
                        continue;
                    }
                }
            }
            for(String s : subList) {
                list.add(s);
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    static void combine(String course, int k) {
        if(k == N) {
            if(course.length() > 1) {
                map.put(course, map.getOrDefault(course, 0) + 1);
            }
            return;
        }
        combine(course + order.charAt(k) + "", k + 1);
        combine(course + "", k + 1);
    }
    
    static String sortMenu(String s) {
        String[] str = s.split("");
        Arrays.sort(str);
        String sorted = "";
        for(String x : str) {
            sorted = sorted + x;
        }
        
        return sorted;
    }
}