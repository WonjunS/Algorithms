import java.util.*;

class Solution {
    
    private static class City {
        private int idx;
        private int gold;
        private int silver;
        private int weight;
        private int time;
        
        public City(int idx, int gold, int silver, int weight, int time) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.weight = weight;
            this.time = time;
        }
    }
    
    private static int N, a, b;
    private static List<City> cityList;
    
    public long solution(int a_, int b_, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        
        a = a_;
        b = b_;
        cityList = new ArrayList<>();
        
        N = g.length; // 도시의 개수
        for(int i = 0; i < N; i++) {
            int gold = g[i];
            int silver = s[i];
            int weight = w[i];
            int time = t[i];
            
            City city = new City(i, gold, silver, weight, time);
            cityList.add(city);
        }
        
        long left = 0, right = 400000000000000L;
        while(left < right) {
            long target = (left + right) / 2;
            boolean flag = moveAvailable(target);
            if(flag) {
                right = target;
            } else {
                left = target + 1;
            }
        }
        
        answer = left;
        
        return answer;
    }
    
    private static boolean moveAvailable(long time) {
        boolean flag = false;
        long total = 0;
        long totalGold = 0;
        long totalSilver = 0;
        for(City city : cityList) {
            int g = city.gold;
            int s = city.silver;
            int w = city.weight;
            int t = city.time;
            long moveCnt = time / (t * 2); // 이동 가능 횟수
            if((time / t) % 2 == 1) {
                moveCnt++; // 마지막 이송후에 도시로 돌아올 필요 없으므로 +1
            }
            
            long tmp = Math.min(w * moveCnt, g + s);
            total += tmp;
            totalGold += Math.min(g, tmp);
            totalSilver += Math.min(s, tmp);
        }
        
        if(total >= (a + b) && totalGold >= a && totalSilver >= b) {
            flag = true;
        }
        
        return flag;
    }
}