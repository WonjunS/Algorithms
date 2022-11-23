import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        String[] nums = expression.split("[^0-9]");
        ArrayList<Long> numList = new ArrayList<>();
        for(String s : nums) numList.add(Long.parseLong(s));
        
        String[] operands = expression.split("[0-9]+");
        ArrayList<String> oprList = new ArrayList<>();
        for(int i = 1; i < operands.length; i++) oprList.add(operands[i]);
        
        ArrayList<Long> longTemp;
        ArrayList<String> oprTemp;
        
        longTemp = new ArrayList<Long>(numList);
        oprTemp = new ArrayList<String>(oprList);
        pro(longTemp, oprTemp, "+", "-", "*");
        answer = Math.max(answer, Math.abs(longTemp.get(0)));
        
        longTemp = new ArrayList<Long>(numList);
        oprTemp = new ArrayList<String>(oprList);
        pro(longTemp, oprTemp, "+", "*", "-");
        answer = Math.max(answer, Math.abs(longTemp.get(0)));
        
        longTemp = new ArrayList<Long>(numList);
        oprTemp = new ArrayList<String>(oprList);
        pro(longTemp, oprTemp, "-", "+", "*");
        answer = Math.max(answer, Math.abs(longTemp.get(0)));
        
        longTemp = new ArrayList<Long>(numList);
        oprTemp = new ArrayList<String>(oprList);
        pro(longTemp, oprTemp, "-", "*", "+");
        answer = Math.max(answer, Math.abs(longTemp.get(0)));
        
        longTemp = new ArrayList<Long>(numList);
        oprTemp = new ArrayList<String>(oprList);
        pro(longTemp, oprTemp, "*", "-", "+");
        answer = Math.max(answer, Math.abs(longTemp.get(0)));
        
        longTemp = new ArrayList<Long>(numList);
        oprTemp = new ArrayList<String>(oprList);
        pro(longTemp, oprTemp, "*", "+", "-");
        answer = Math.max(answer, Math.abs(longTemp.get(0)));
        
        return answer;
    }
    
    static void pro(ArrayList<Long> list, ArrayList<String> oprList,
                    String o1, String o2, String o3) {
        calc(list, oprList, o1);
        calc(list, oprList, o2);
        calc(list, oprList, o3);
    }
    
    static void calc(ArrayList<Long> list, ArrayList<String> oprList, String opr) {
        int i = 0;
        int length = oprList.size();
        
        while(i < length) {
            if(opr.equals(oprList.get(i))) {
                if(opr.equals("+")) {
                    list.set(i, list.get(i) + list.get(i + 1));
                }
                if(opr.equals("-")) {
                    list.set(i, list.get(i) - list.get(i + 1));
                }
                if(opr.equals("*")) {
                    list.set(i, list.get(i) * list.get(i + 1));
                }
                list.remove(i + 1);
                oprList.remove(i);
                i--;
                length--;
            }
            i++;
        }
    }
}