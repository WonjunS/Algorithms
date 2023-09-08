import java.util.*;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
         
        for(int i = 0; i < score.length; i++) {
            if(list.size() < k) {
                list.add(score[i]);
            } else {
                if(score[i] > list.get(0)) {
                    list.remove(list.get(0));
                    list.add(score[i]);
                }
            }
            list.sort((o1, o2) -> (o1 - o2));
            
            answer.add(list.get(0));
        }
        
        return answer;
    }
}