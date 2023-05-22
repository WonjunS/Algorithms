import java.util.*;

class Solution {
    
    static int N;
    static int PRICE = 100;
    static int[] priceList;
    static List<Integer> answer;
    static List<Integer>[] adj;
    static Map<String, Integer> sellerList;
    
    public List<Integer> solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        priceList = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        answer = new ArrayList<>();
        sellerList = new HashMap<>();
        sellerList.put("center", 0);
        for(int i = 0; i < enroll.length; i++) {
            sellerList.put(enroll[i], (i + 1));
        }
        
        for(int i = 0; i < enroll.length; i++) {
            String s1 = enroll[i];
            String s2 = referral[i];
            int c1 = sellerList.get(s1);
            if(s2.equals("-")) {
                adj[c1].add(0);
                continue;
            }
            int c2 = sellerList.get(s2);
            adj[c1].add(c2);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int n = sellerList.get(sellerName);
            int count = amount[i];
            int total = count * PRICE;
            
            int take = total - (total / 10);
            priceList[n] += take;
            
            dfs(adj[n].get(0), total / 10);
        }
        
        for(int i = 1; i <= N; i++) {
            answer.add(priceList[i]);
        }
        
        return answer;
    }
    
    private static void dfs(int n, int remaining) {
        if(n == 0) {
            return;
        }
        if(remaining < 10) {
            priceList[n] += remaining;
            return;
        }
        priceList[n] += remaining - (remaining / 10);
        
        dfs(adj[n].get(0), remaining / 10);
    }
}