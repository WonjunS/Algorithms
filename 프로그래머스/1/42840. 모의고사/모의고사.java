import java.util.*;

class Solution {
    
    private static int stu1, stu2, stu3;
    private static int[] pattern1 = {1, 2, 3, 4, 5};
    private static int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public List<Integer> solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if(pattern1[i % 5] == answer) stu1++;
            if(pattern2[i % 8] == answer) stu2++;
            if(pattern3[i % 10] == answer) stu3++;
        }
        
        int max = Math.max(stu1, Math.max(stu2, stu3));
        if(stu1 == max) list.add(1);
        if(stu2 == max) list.add(2);
        if(stu3 == max) list.add(3);
        
        return list;
    }
}