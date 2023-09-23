import java.util.*;
import java.io.*;

public class Main {
    
    private static class Store { 
        private int x;
        private int y;
        
        public Store(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static int hx, hy, rx, ry;
    private static boolean flag;
    private static boolean[] visited;
    private static List<Store> list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());
            
            list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                list.add(new Store(x, y));
            }
            
            st = new StringTokenizer(br.readLine());
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());
            
            int dist = Math.abs(rx - hx) + Math.abs(ry - hy);
            if(dist <= 1000) {
                sb.append("happy").append('\n');
                continue;
            }
            
            flag = false;
            visited = new boolean[n + 1];
            
            bfs();
            
            if(flag) {
                sb.append("happy").append('\n');
            } else {
                sb.append("sad").append('\n');
            }
        }
        
        System.out.println(sb.toString());
    }
    
    private static void bfs() {
        Queue<Store> q = new LinkedList<>();
        q.add(new Store(hx, hy));
        
        while(!q.isEmpty()) {
            Store store = q.poll();
            
            if(check(store.x, store.y, rx, ry)) {
                flag = true;
                return;
            }
            
            for(int i = 0; i < list.size(); i++) {
                if(visited[i]) continue;
                
                Store tmp = list.get(i);
                if(check(tmp.x, tmp.y, store.x, store.y)) {
                    visited[i] = true;
                    q.add(new Store(tmp.x, tmp.y));
                    continue;
                }
            }
        }
    }
    
    private static boolean check(int x1, int y1, int x2, int y2) {
        int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        
        return dist <= 1000;
    }
    
}