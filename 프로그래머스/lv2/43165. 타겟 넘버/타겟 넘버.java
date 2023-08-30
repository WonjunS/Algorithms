class Solution {
    
    static int T, answer, N;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        T = target;
        N = numbers.length;
        
        dfs(0, 0, numbers);
        
        return answer;
    }
    
    static void dfs(int sum, int k, int[] numbers) {
        if(k == N) {
            if(sum == T) {
                answer++;
            }
            return;
        }
        dfs(sum + numbers[k], k + 1, numbers);
        dfs(sum - numbers[k], k + 1, numbers);
    }
}