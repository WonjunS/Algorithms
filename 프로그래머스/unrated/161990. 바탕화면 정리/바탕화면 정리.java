import java.util.*;

class Solution {
    public List<Integer> solution(String[] wallpaper) {
        List<Integer> answer = new ArrayList<>();
        
        int minx = 100, miny = 100, maxx = -1, maxy = -1;
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if(c == '#') {
                    int x = i;
                    int y = j;
                    
                    minx = Math.min(minx, x);
                    miny = Math.min(miny, y);
                    maxx = Math.max(maxx, x + 1);
                    maxy = Math.max(maxy, y + 1);
                }
            }
        }
        
        answer.add(minx);
        answer.add(miny);
        answer.add(maxx);
        answer.add(maxy);
        
        return answer;
    }
}