import java.util.*;

class Solution {
    
    static int answer, length;
    static int[][] board;
    static List<Integer> list;
    static Map<Integer, Integer> map;
    
    public int solution(int[] picks, String[] minerals) {
        board = new int[3][3];
        
        // 0 -> diamond, 1 -> iron, 2 -> stone
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        
        board[1][0] = 5;
        board[1][1] = 1;
        board[1][2] = 1;
        
        board[2][0] = 25;
        board[2][1] = 5;
        board[2][2] = 1;
        
        int count = Arrays.stream(picks).sum();
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < minerals.length; i+=5) {
            if(count == 0) break;
            List<Integer> subList = new ArrayList<>();
            for(int j = i; j < i + 5; j++) {
                if(j >= minerals.length) break;
                String mineral = minerals[j];
                int val = mineral.equals("iron") ? 1 : mineral.equals("stone") ?
                    2 : 0;
                subList.add(val);
            }
            list.add(subList);
            count--;
        }
        
        List<Score> scoreList = new ArrayList<>();
        for(List<Integer> l : list) {
            int d = 0, i = 0, s = 0;
            for(int m : l) {
                d += board[0][m];
                i += board[1][m];
                s += board[2][m];
            }
            
            scoreList.add(new Score(d, i, s));
        }
        
        Collections.sort(scoreList, new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                if(s1.stone == s2.stone) {
                    return s2.iron - s1.iron;
                }
                return s2.stone - s1.stone;
            }
        });
        
        for(Score score : scoreList) {
            if(picks[0] > 0) {
                answer += score.diamond;
                picks[0] -= 1;
                continue;
            }
            if(picks[1] > 0) {
                answer += score.iron;
                picks[1] -= 1;
                continue;
            }
            if(picks[2] > 0) {
                answer += score.stone;
                picks[2] -= 1;
                continue;
            }
        }
        
        return answer;
    }
    
    static class Score {
        private int diamond;
        private int iron;
        private int stone;
        
        public Score(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
}