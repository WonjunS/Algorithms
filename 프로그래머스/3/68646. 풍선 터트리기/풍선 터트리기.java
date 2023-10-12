class Solution {
    public int solution(int[] a) {
        if(a.length == 1) {
            return 1;
        }
        
        if(a.length == 2) {
            return 2;
        }
        
        int answer = 0;
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        int minValue = Integer.MAX_VALUE;
        
        for(int i = 0; i < a.length; i++) {
            if(minValue > a[i]) {
                minValue = a[i];
            }
            leftMin[i] = minValue;
        }
        
        minValue = Integer.MAX_VALUE;
        for(int i = a.length - 1; i >= 0; i--) {
            if(minValue > a[i]) {
                minValue = a[i];
            }
            rightMin[i] = minValue;
        }
        
        for(int i = 0; i < a.length; i++) {
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}