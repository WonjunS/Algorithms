import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<String> routes;
    
    public String[] solution(String[][] tickets) {
        routes = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(routes);
        String[] answer = routes.get(0).split(" ");
        
        return answer;
    }
    
    static void dfs(String curr, String route, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            routes.add(route);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(from.equals(curr) && !visited[i]) {
                visited[i] = true;
                dfs(to, route + " " + to, tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}