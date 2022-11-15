import java.util.*;

class Solution {
    
    static ArrayList<String> list;
    static String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        list = new ArrayList<String>();
        String s = "";
        
        recur(s, 0);
        
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        
        int answer = list.indexOf(word) + 1;
        
        return answer;
    }
    
    static void recur(String word, int k) {
        if(k == 5) {
            if(word.equals("")) return;
            if(list.contains(word)) return;
            list.add(word);
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            recur(word + vowels[i], k + 1);
            recur(word, k + 1);
        }
    }
}