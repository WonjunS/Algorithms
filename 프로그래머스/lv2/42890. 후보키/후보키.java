import java.util.*;

class Solution {
    
    static String[][] table;
    static List<Set<Character>> candidateKeys;
    
    public int solution(String[][] relation) {
        table = relation;
        candidateKeys = new ArrayList<>();
        
        String columns = "";
        for(int i = 0; i < relation[0].length; i++) {
            columns += i;
        }
        
        for(int i = 1; i <= relation[0].length; i++) {
            combination(columns, new HashSet<>(), i);
        }
        
        return candidateKeys.size();
    }
    
    static void combination(String columns, Set<Character> set, int r) {
        if(r == 0 && isUnique(set) && isMinimal(set)) {
            candidateKeys.add(set);
            return;
        }
        
        for(int i = 0; i < columns.length(); i++) {
            Set<Character> newSet = new HashSet<>(set);
            newSet.add(columns.charAt(i));
            combination(columns.substring(i + 1), newSet, r - 1);
        }
    }
    
    static boolean isUnique(Set<Character> key) {
        Set<String> set = new HashSet<>();
        for(String[] row : table) {
            String str = "";
            for(char col : key) {
                str += row[col - '0'];
            }
            if(set.contains(str)) return false;
            else set.add(str);
        }
        
        return true;
    }
    
    static boolean isMinimal(Set<Character> key) {
        for(Set<Character> candidateKey : candidateKeys) {
            if(key.containsAll(candidateKey)) return false;
        }
        
        return true;
    }
}