import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
            int weight1 = people[left];
            int weight2 = people[right];
            
            if(weight1 + weight2 <= limit) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        
        return answer;
    }
}