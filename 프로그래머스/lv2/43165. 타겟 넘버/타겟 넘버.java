class Solution {
    
    static int N, answer;
    static int[] selected;
    static char[] ops = {'+', '-'};
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        selected = new int[numbers.length];
        
        dfs(0, target, numbers);
        
        return answer;
    }
    
    static void dfs(int k, int target, int[] numbers) {
        if(k == N) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                char op = ops[selected[i]];
                if(op == '+') {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            if(sum == target) answer++;
            
            return;
        }
        for(int i = 0; i <= 1; i++) {
            selected[k] = i;
            dfs(k + 1, target, numbers);
            selected[k] = -1;
        }
    }
}