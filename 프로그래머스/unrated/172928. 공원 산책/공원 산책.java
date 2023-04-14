class Solution {
    
    static int N, M, x, y;
    static char[][] map;
    
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        map = new char[N][M];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                char c = park[i].charAt(j);
                if(c == 'S') {
                    x = i;
                    y = j;
                }
                map[i][j] = c;
            }
        }
        
        for(String route : routes) {
            String[] str = route.split(" ");
            String dir = str[0];
            int dist = Integer.parseInt(str[1]);
            
            move(dir, dist);
        }
        
        int[] answer = {x, y};
        return answer;
    }
    
    static void move(String dir, int dist) {
        if(dir.equals("E")) {
            int after = y + dist;
            if(after >= M) return;
            
            for(int i = y; i <= after; i++) {
                if(map[x][i] == 'X') return;
            }
            
            map[x][y] = 'O';
            y = y + dist;
            map[x][y] = 'S';
        }
        if(dir.equals("W")) {
            int after = y - dist;
            if(after < 0) return;
            
            for(int i = y; i >= after; i--) {
                if(map[x][i] == 'X') return;
            }
            
            map[x][y] = 'O';
            y = y - dist;
            map[x][y] = 'S';
        }
        if(dir.equals("S")) {
            int after = x + dist;
            if(after >= N) return;
            
            for(int i = x; i <= after; i++) {
                if(map[i][y] == 'X') return;
            }
            
            map[x][y] = 'O';
            x = x + dist;
            map[x][y] = 'S';
        }
        if(dir.equals("N")) {
            int after = x - dist;
            if(after < 0) return;
            
            for(int i = x; i >= after; i--) {
                if(map[i][y] == 'X') return;
            }
            
            map[x][y] = 'O';
            x = x - dist;
            map[x][y] = 'S';
        }
    }
}