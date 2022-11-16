import java.util.*;

class Solution {
    
    static int answer, x, y;
    static ArrayList<String> routes;
    static int[] up = {0, 1};
    static int[] down = {0, -1};
    static int[] left = {-1, 0};
    static int[] right = {1, 0};
    
    public int solution(String dirs) {
        routes = new ArrayList<>();
        x = 0;
        y = 0;
        
        for(int i = 0; i < dirs.length(); i++) {
            String dir = String.valueOf(dirs.charAt(i));
            move(dir);
        }
        
        System.out.println(routes);
        System.out.println(routes.size());
        
        return answer;
    }
    
    static void move(String direction) {
        if(direction.equals("U")) {
            int nx = x + up[0];
            int ny = y + up[1];
            String route1 = String.valueOf(x) + String.valueOf(y) 
                + String.valueOf(nx) + String.valueOf(ny);
            String route2 = String.valueOf(nx) + String.valueOf(ny) 
                + String.valueOf(x) + String.valueOf(y);
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) return;
            x = nx;
            y = ny;
            if(routes.contains(route1) || routes.contains(route2)) return;
            routes.add(route1);
            routes.add(route2);
            answer++;
            return;
        }
        if(direction.equals("D")) {
            int nx = x + down[0];
            int ny = y + down[1];
            String route1 = String.valueOf(x) + String.valueOf(y) 
                + String.valueOf(nx) + String.valueOf(ny);
            String route2 = String.valueOf(nx) + String.valueOf(ny) 
                + String.valueOf(x) + String.valueOf(y);
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) return;
            x = nx;
            y = ny;
            if(routes.contains(route1) || routes.contains(route2)) return;
            routes.add(route1);
            routes.add(route2);
            answer++;
            return;
        }
        if(direction.equals("L")) {
            int nx = x + left[0];
            int ny = y + left[1];
            String route1 = String.valueOf(x) + String.valueOf(y) 
                + String.valueOf(nx) + String.valueOf(ny);
            String route2 = String.valueOf(nx) + String.valueOf(ny) 
                + String.valueOf(x) + String.valueOf(y);
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) return;
            x = nx;
            y = ny;
            if(routes.contains(route1) || routes.contains(route2)) return;
            routes.add(route1);
            routes.add(route2);
            answer++;
            return;
        }
        if(direction.equals("R")) {
            int nx = x + right[0];
            int ny = y + right[1];
            String route1 = String.valueOf(x) + String.valueOf(y) 
                + String.valueOf(nx) + String.valueOf(ny);
            String route2 = String.valueOf(nx) + String.valueOf(ny) 
                + String.valueOf(x) + String.valueOf(y);
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) return;
            x = nx;
            y = ny;
            if(routes.contains(route1) || routes.contains(route2)) return;
            routes.add(route1);
            routes.add(route2);
            answer++;
            return;
        }
    }
}