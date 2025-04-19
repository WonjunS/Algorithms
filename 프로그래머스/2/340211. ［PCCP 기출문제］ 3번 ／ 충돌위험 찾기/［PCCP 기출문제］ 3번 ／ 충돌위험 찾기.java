import java.util.*;

class Solution {
    
    private static int N, totalTime, answer;
    private static int[][] countMap;
    private static List<Robot>[] map;
    
    private static class Robot {
        private int r;
        private int c;
        private int second;
        private int idx;
        
        public Robot(int r, int c, int second, int idx) {
            this.r = r;
            this.c = c;
            this.second = second;
            this.idx = idx;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        N = routes.length; // 로봇의 개수
        
        init();
        
        // 로봇이 이동한 좌표 저장
        for(int i = 0; i < N; i++) {
            int[] route = routes[i];
            
            totalTime = 0; // 특정 로봇이 이동하는데 걸린 총 시간
            
            move(points, route, i); // 특정 route를 따라 움직인 로봇의 이동 경로 계산
        }
        
        
        // 가장 오래걸린 로봇의 이동시간 계산
        int time = countMaxSeconds();
        
        // i초에 특정 좌표에 2대 이상의 로봇이 지나갔는지 확인
        for(int t = 0; t <= time; t++) {
            for(int i = 0; i < N; i++) {
                int maxTime = map[i].size();
                if(t >= maxTime) continue;
                
                Robot robot = map[i].get(t);
                int r = robot.r;
                int c = robot.c;
                
                countMap[r][c]++;
            }
            // 특정 시간에 2개 이상 지나간 좌표가 있는지 확인
            checkMultipleVisits(); 
            
            // 초기화
            clearCountMap();
        }
        
        return answer;
    }
    
    private static void clearCountMap() {
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                countMap[i][j] = 0;
            }
        }
    }
    
    private static void checkMultipleVisits() {
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                int count = countMap[i][j];
                if(count >= 2) {
                    answer++;
                }
            }
        }
    }
    
    private static void init() {
        // i번째 로봇이 방문한 좌표 목록을 저장할 리스트 배열
        map = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        
        // 특정 좌표를 지나간 로봇의 수를 저장할 배열
        countMap = new int[101][101];
    }
    
    private static int countMaxSeconds() {
        int max = 0;
        for(int i = 0; i < N; i++) {
            int length = map[i].size();
            max = Math.max(length, max);
        }
        
        return max;
    }
    
    private static void move(int[][] points, int[] route, int idx) {
        int start_r = points[route[0] - 1][0];
        int start_c = points[route[0] - 1][1];
        Robot robot = new Robot(start_r, start_c, totalTime, idx);
        map[idx].add(robot);
        totalTime++;
        
        for(int i = 1; i < route.length; i++) {
            int prevPoint = route[i - 1]; // 이전 포인트
            int nextPoint = route[i]; // 이동할 포인트
            
            int from_r = points[prevPoint - 1][0]; // 이전 포인트의 r 좌표
            int from_c = points[prevPoint - 1][1]; // 이전 포인트의 c 좌표
            
            int to_r = points[nextPoint - 1][0]; // 이동할 포인트의 r 좌표
            int to_c = points[nextPoint - 1][1]; // 이동할 포인트의 c 좌표
            
            // 수직 이동
            moveVertically(from_r, to_r, from_c, idx);
            
            // 수평 이동
            moveHorizontally(from_c, to_c, to_r, idx);
        }
    }
    
    // r 좌표가 변하는 이동
    private static void moveVertically(int from_r, int to_r, int from_c, int idx) {
        // 아래에서 위로 이동하는 경우
        if(from_r > to_r) {
            for(int r = from_r - 1; r >= to_r; r--) {
                Robot robot = new Robot(r, from_c, totalTime, idx);
                map[idx].add(robot);
                totalTime++;
            }
        } 
        // 위에서 아래로 이동하는 경우
        else {
            for(int r = from_r + 1; r <= to_r; r++) {
                Robot robot = new Robot(r, from_c, totalTime, idx);
                map[idx].add(robot);
                totalTime++;
            }
        }
    }
    
    // c 좌표가 변하는 이동
    private static void moveHorizontally(int from_c, int to_c, int to_r, int idx) {
        // 아래에서 위로 이동하는 경우
        if(from_c > to_c) {
            for(int c = from_c - 1; c >= to_c; c--) {
                Robot robot = new Robot(to_r, c, totalTime, idx);
                map[idx].add(robot);
                totalTime++;
            }
        } 
        // 위에서 아래로 이동하는 경우
        else {
            for(int c = from_c + 1; c <= to_c; c++) {
                Robot robot = new Robot(to_r, c, totalTime, idx);
                map[idx].add(robot);
                totalTime++;
            }
        }
    }

    
}