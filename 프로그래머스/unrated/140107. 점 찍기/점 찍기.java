class Solution {
    
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i+=k) {
            int maxY = possibleYDistance(i, d);
            answer += countY(maxY, k);
        }
        
        return answer;
    }
    
    private static int possibleYDistance(int x, int d) {
        long a = (long) Math.pow(x, 2);
        long b = (long) Math.pow(d, 2);
        int y = (int) (Math.sqrt(b - a));
        return y;
    }
    
    private static int countY(int y, int k) {
        return (y / k) + 1;
    }
}