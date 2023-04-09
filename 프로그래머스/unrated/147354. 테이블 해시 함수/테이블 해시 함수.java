import java.util.*;

class Solution {
    
    static int answer;
    static int[] S;
    static List<int[]> list;
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        list = new ArrayList<>();
        for(int[] d : data) {
            list.add(d);
        }
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col - 1] == o2[col - 1]) {
                    return o2[0] - o1[0];
                }
                return o1[col - 1] - o2[col - 1];
            }
        });
        
        int length = row_end - row_begin;
        S = new int[length + 1];

        step3(row_begin, row_end);
        
        answer = step4(length);

        return answer;
    }
    
    private static void step3(int s, int e) {
        for(int i = s; i <= e; i++) {
            for(int n : list.get(i - 1)) {
                S[i - s] += (n % i);
            }
        }
    }
    
    private static int step4(int k) {
        if(k == 0) {
            return S[k];
        }
        return step4(k - 1) ^ S[k];
    }
}