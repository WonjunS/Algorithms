class Solution {
    
    public int solution(String s) {
        for(int len = s.length(); len > 0; len--) {
            for(int i = 0; i + len <= s.length(); i++) {
                if(isPalindrome(s, i, i + len - 1)) return len;
            }
        }
        return 1;
    }
    
    static boolean isPalindrome(String str, int start, int end) {
        while(start <= end) {
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        
        return true;
    }
}