import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            int code = data[i][0];
            int date = data[i][1];
            int max = data[i][2];
            int remain = data[i][3];
            
            if(ext.equals("code")) {
                if(code < val_ext) {
                    answer.add(data[i]);
                }
            } else if(ext.equals("date")) {
                if(date < val_ext) {
                    answer.add(data[i]);
                }
            } else if(ext.equals("maximum")) {
                if(max < val_ext) {
                    answer.add(data[i]);
                }
            } else {
                if(remain < val_ext) {
                    answer.add(data[i]);
                }
            }
        }
        
        if(sort_by.equals("code")) {
            answer.sort((o1, o2) -> {
                return o1[0] - o2[0];
            });
        } else if(sort_by.equals("date")) {
            answer.sort((o1, o2) -> {
                return o1[1] - o2[1];
            });
        } else if(sort_by.equals("maximum")) {
            answer.sort((o1, o2) -> {
                return o1[2] - o2[2];
            });
        } else {
            answer.sort((o1, o2) -> {
                return o1[3] - o2[3];
            });
        }
        
        return answer;
    }
}