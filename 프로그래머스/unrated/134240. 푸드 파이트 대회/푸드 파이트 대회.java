class Solution {
    public String solution(int[] food) {
        String left = "";
        String right = "";
        
        for(int i = 1; i < food.length; i++) {
            int N = food[i];
            for(int j = 0; j < N / 2; j++) {
                left = left + i + "";
                right = i + "" + right;
            }
        }
        
        String answer = left + "0" + right;
        
        return answer;
    }
}