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
            order = sortOrder(orders[i]);
            N = order.length();
            
            // 손님이 주문한 단품메뉴들을 가지고 코스 요리의 조합을 만듦
            combine("", 0);
        }
        
        for(int i = 0; i < course.length; i++) {
            List<String> subList = new ArrayList<>(); // 가장 많이 주문된 메뉴 구성을 저장
            int len = course[i];
            int max = 0;
            
            for(String menus : map.keySet()) {
                int cnt = map.get(menus); // 조합된 단품 메뉴들이 포함된 주문의 횟수
                if(cnt >= 2 && menus.length() == len) {
                    if(max == cnt) {
                        subList.add(menus);
                        continue;
                    }
                    if(cnt > max) {
                        subList.clear();
                        max = cnt;
                        subList.add(menus);
                        continue;
                    }
                }
            }
            for(String s : subList) {
                list.add(s);
                map.remove(s);
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    // 각 손님이 주문한 단품메뉴들을 조합하는 메서드
    static void combine(String course, int k) {
        if(k == N) {
            // 조합된 코스가 2개 이상의 메뉴로 이루어진 경우
            if(course.length() > 1) {
                map.put(course, map.getOrDefault(course, 0) + 1);
            }
            return;
        }
        combine(course + order.charAt(k) + "", k + 1); // 현재 메뉴를 포함
        combine(course + "", k + 1); // 현재 메뉴를 미포함
    }
    
    // orders 배열의 각 원소를 오름차순으로 정렬해주는 메서드
    static String sortOrder(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = "";
        for(char c : arr) {
            sorted = sorted + c + "";
        }
        
        return sorted;
    }
}