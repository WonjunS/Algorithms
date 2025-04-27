import java.util.*;

class Solution {
    
    private static int N, maxWins;
    private static List<Integer> myDice, opponentDice, answer;
    private static boolean[] checked;
    private static int[][] dice;
    
    public List<Integer> solution(int[][] dice) {
        init(dice);
        
        chooseDice(0, 0);
        
        return answer;
    }
    
    private static void init(int[][] d) {
        dice = d;
        N = dice.length;
        maxWins = 0;
        answer = new ArrayList<>();
        checked = new boolean[N + 1];
    }
    
    private static void chooseDice(int idx, int prev) {
        if(idx == N / 2) {
            List<Integer> myDice = new ArrayList<>();
            List<Integer> oppDice = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                if(checked[i] == true) {
                    myDice.add(i);
                } else {
                    oppDice.add(i);
                }
            }
            
            int wins = calculateMyWins(myDice, oppDice);
            if(wins > maxWins) {
                maxWins = wins;
                answer.clear();
                for(int k : myDice) {
                    answer.add(k);
                }
            }
            
            return;
        }
        for(int i = prev + 1; i <= N; i++) {
            checked[i] = true;
            chooseDice(idx + 1, i);
            checked[i] = false;
        }
    }
    
    private static int calculateMyWins(List<Integer> myDice, List<Integer> oppDice) {
        int totalWins = 0;
        
        List<Integer> mySums = getAllSums(myDice);
        List<Integer> oppSums = getAllSums(oppDice);
        
        Collections.sort(oppSums);
        
        for(int sum : mySums) {
            int wins = upperBounds(oppSums, sum - 1);
            totalWins += wins;
        }
        
        return totalWins;
    }
    
    private static int upperBounds(List<Integer> oppSums, int target) {
        int left = 0, right = oppSums.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(target >= oppSums.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private static List<Integer> getAllSums(List<Integer> diceList) {
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        
        for(int diceIdx : diceList) {
            List<Integer> temp = new ArrayList<>();
            for(int sum : sums) {
                for(int num : dice[diceIdx - 1]) {
                    temp.add(sum + num);
                }
            }
            sums = temp;
        }
        
        return sums;
    }
    
}