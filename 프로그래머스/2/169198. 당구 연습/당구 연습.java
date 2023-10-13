import java.util.*;

class Solution {
    public List<Integer> solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minLength = 10000000;
            
            if(startX != targetX) {
                minLength = Math.min(minLength, up(startX, startY, targetX, targetY, m, n));
                minLength = Math.min(minLength, down(startX, startY, targetX, targetY, m, n));
            }
            
            if(startX == targetX) {
                if(startY > targetY) {
                    minLength = Math.min(minLength, up(startX, startY, targetX, targetY, m, n));
                } else if(startY < targetY) {
                    minLength = Math.min(minLength, down(startX, startY, targetX, targetY, m, n));
                }
            }
            
            if(startY != targetY) {
                minLength = Math.min(minLength, left(startX, startY, targetX, targetY, m, n));
                minLength = Math.min(minLength, right(startX, startY, targetX, targetY, m, n));
            }
            
            if(startY == targetY) {
                if(startX > targetX) {
                    minLength = Math.min(minLength, right(startX, startY, targetX, targetY, m, n));
                } else if(startX < targetX) {
                    minLength = Math.min(minLength, left(startX, startY, targetX, targetY, m, n));
                }
            }
            
            answer.add(minLength);
        }
        
        return answer;
    }
    
    private static int up(int startX, int startY, int targetX, int targetY, int m, int n) {
        int convertedX = targetX;
        int convertedY = targetY + ((n - targetY) * 2);
        
        int xSqr = (int) Math.pow(Math.abs(startX - convertedX), 2);
        int ySqr = (int) Math.pow(Math.abs(startY - convertedY), 2);
        
        int distance = xSqr + ySqr;
        
        return distance;
    }
    
    private static int down(int startX, int startY, int targetX, int targetY, int m, int n) {
        int convertedX = targetX;
        int convertedY = -targetY;
        
        int xSqr = (int) Math.pow(Math.abs(startX - convertedX), 2);
        int ySqr = (int) Math.pow(Math.abs(startY - convertedY), 2);
        
        int distance = xSqr + ySqr;
        
        return distance;
    }
    
    private static int left(int startX, int startY, int targetX, int targetY, int m, int n) {
        int convertedX = -targetX;
        int convertedY = targetY;
        
        int xSqr = (int) Math.pow(Math.abs(startX - convertedX), 2);
        int ySqr = (int) Math.pow(Math.abs(startY - convertedY), 2);
        
        int distance = xSqr + ySqr;
        
        return distance;
    }
    
    private static int right(int startX, int startY, int targetX, int targetY, int m, int n) {
        int convertedX = targetX + ((m - targetX) * 2);
        int convertedY = targetY;
        
        int xSqr = (int) Math.pow(Math.abs(startX - convertedX), 2);
        int ySqr = (int) Math.pow(Math.abs(startY - convertedY), 2);
        
        int distance = xSqr + ySqr;
        
        return distance;
    }
    
}