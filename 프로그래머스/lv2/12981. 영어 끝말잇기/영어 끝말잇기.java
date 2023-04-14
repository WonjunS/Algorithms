import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int num = 0;
        int turn = 0;
        List<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            if(prev.charAt(prev.length() - 1) == curr.charAt(0)) {
                if(wordList.contains(curr)) {
                    if((i + 1) % n == 0) {
                        num = n;
                        turn = (i + 1) / n;
                    } else {
                        num = (i + 1) % n;
                        turn = (i + 1) / n + 1;
                    }
                break;
                } else {
                    wordList.add(curr);
                }
            } else {
                if((i + 1) % n == 0) {
                    num = n;
                    turn = (i + 1) / n;
                } else {
                    num = (i + 1) % n;
                    turn = (i + 1) / n + 1;
                }
                break;
            }
        }
        
        int[] answer = {num, turn};

        return answer;
    }
}