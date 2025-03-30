import java.util.*;

class Solution {
    
    public String solution(long n, String[] bans) {
        List<Long> indexList = new ArrayList<>();
        
        for(String ban : bans) {
            long idx = convertToIndex(ban);
            indexList.add(idx);
        }
        
        indexList.sort((o1, o2) -> o1.compareTo(o2));
        
        for(Long idx : indexList) {
            if(idx <= n) {
                n++;
            } else {
                break;
            }
        }
        
        return convert_10_to26(n);
    }
    
    private static long convertToIndex(String ban) {
        int length = ban.length();
        long idx = 0;
        for(int i = 1; i <= length; i++) {
            char c = ban.charAt(i - 1);
            int diff = (int) (c - 'a') + 1;

            idx += (long) Math.pow(26, (length - i)) * diff;
        }
        
        return idx;
    }
    
    private static String convert_10_to26(long idx) {
        String text = "";
        while(idx > 0) {
            long r = idx % 26;
            idx /= 26;
            if(r == 0) {
                text = "z" + text;
                idx--;
            } else {
                char c = (char) ('a' + r - 1);
                text = c + text;
            }
        }
        
        long r = idx % 26;
        if(r > 0) {
            char c = (char) ('a' + r - 1);
            text = c + text;
        }
        
        return text;
    }
    
}