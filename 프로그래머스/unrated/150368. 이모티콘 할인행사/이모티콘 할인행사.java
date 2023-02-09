class Solution {
    
    static int N, total_price, service;
    static int[] discount_rate;
    
    public int[] solution(int[][] users, int[] emoticons) {
        N = emoticons.length;
        discount_rate = new int[N];
        
        recur(users, emoticons, 0);
        
        int[] answer = {service, total_price};
        
        return answer;
    }
    
    static void recur(int[][] users, int[] emoticons, int k) {
        if(k == N) {
            int serv = 0;
            int T = 0;
            for(int i = 0; i < users.length; i++) {
                int rate = users[i][0];
                int price = users[i][1];
                
                int total = 0;
                for(int j = 0; j < N; j++) {
                    int emoticon_price = emoticons[j];
                    int discount = discount_rate[j];
                    
                    if(discount >= rate) {
                        int t = emoticon_price * (100 - discount);
                        int p = t / 100;
                        total += p;
                    }
                }
                if(total >= price) {
                    serv++;
                    continue;
                } else {
                    T += total;
                }
            }
            
            if(serv > service) {
                service = serv;
                total_price = T;
                return;
            }
            if(serv == service) {
                total_price = Math.max(total_price, T);
            }
            return;
        } else {
            for(int i = 1; i <= 4; i++) {
                discount_rate[k] = (i * 10);
                recur(users, emoticons, k + 1);
                discount_rate[k] = 0;
            }
        }
    }
}