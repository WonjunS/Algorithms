class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        if(n == num) {
            return 1;
        }
        
        int floor = (num % w == 0) ? (num / w) - 1 : num / w;
        int idx = -1;
        if(floor % 2 != 0) {
            idx = w - ((num - 1) % w) - 1;
        } else {
            idx = (num - 1) % w;
        }
        
        while(true) {
            int next = floor * w;
            
            if(floor % 2 == 0) {
                next += (idx + 1);
            } else {
                next += (w - idx);
            }
            
            if(next > n) {
                break;
            }
            
            answer++;
            floor++;
        }
        
        return answer;
    }
}