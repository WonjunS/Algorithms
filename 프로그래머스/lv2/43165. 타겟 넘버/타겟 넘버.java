class Solution {
    
    static int N, answer;
    static int[] selected;
    static char[] ops = {'+', '-'};
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        selected = new int[N];
        
        dfs(0, target, numbers);
        
        return answer;
    }
    
    static void dfs(int k, int target, int[] numbers) {
        // N개의 연산자가 선택된 경우 계산 후 dfs 종료
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
            // selected[k]의 값이 0이면 '+', 1이면 '-'를 선택
            selected[k] = i;
            dfs(k + 1, target, numbers); // 인덱스 값 1 증가
            selected[k] = -1;
        }
    }
}