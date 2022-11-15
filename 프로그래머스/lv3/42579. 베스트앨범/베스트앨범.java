import java.util.*;

class Solution {

    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        for(Map.Entry<String, Integer> list : entryList) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(list.getKey().equals(genres[i])) {
                    temp.add(i);
                }
            }
            Collections.sort(temp, new Comparator<>() {
                @Override
                public int compare(Integer n1, Integer n2) {
                    return plays[n2] - plays[n1];
                }
            });
            if(temp.size() == 1) {
                answer.add(temp.get(0));
                continue;
            }
            for(int i = 0; i < 2; i++) {
                answer.add(temp.get(i));
            }
            
        }

        return answer;
    }
}
