import java.util.*;

class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> nameList = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            nameList.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++) {
            int total = 0;
            
            for(int j = 0; j < photo[i].length; j++) {
                if(nameList.containsKey(photo[i][j])) {
                    total += nameList.get(photo[i][j]);
                }
            }
            
            answer.add(total);
        }
        
        return answer;
    }
}