import java.util.*;

class Solution {
    public List<String> solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        int length = expressions.length;
        
        String[][] s = new String[length][4];
        boolean[] notAvailable = new boolean[10];
        int max = 0;
        for(int i = 0; i < length; i++) {
            String ex = expressions[i];
            String[] str = ex.split(" = "); // 수식과 결괏값 분리
            s[i][3] = str[1]; // 결괏값
            
            if(str[0].indexOf("+") > -1) {
                String[] nums = str[0].split(" \\+ ");
                s[i][0] = nums[0];
                s[i][1] = "+";
                s[i][2] = nums[1];
            } else {
                String[] nums = str[0].split(" - ");
                s[i][0] = nums[0];
                s[i][1] = "-";
                s[i][2] = nums[1];
            }
            
            String s1 = s[i][0];
            String s2 = s[i][2];
            for(int j = 0; j < s1.length(); j++) {
                int n = Integer.parseInt(s1.substring(j, j + 1));
                max = Math.max(max, n);
            }
            for(int j = 0; j < s2.length(); j++) {
                int n = Integer.parseInt(s2.substring(j, j + 1));
                max = Math.max(max, n);
            }
            if(!s[i][3].equals("X")) {
                String s3 = s[i][3];
                for(int j = 0; j < s3.length(); j++) {
                    int n = Integer.parseInt(s3.substring(j, j + 1));
                    max = Math.max(max, n);
                }
            }
        }
        if(max < 2) {
            max = 2;
        } else {
            max++;
        }
        
        for(int i = 0; i < length; i++) {
            if(s[i][3].equals("X")) {
                continue;
            } else {
                for(int j = max; j <= 9; j++) {
                    if(notAvailable[j]) continue;
                    
                    int a = Integer.parseInt(s[i][0]);
                    int b = Integer.parseInt(s[i][2]);
                    int result = Integer.parseInt(s[i][3]);

                    String op = s[i][1];
                    boolean flag = false;
                    if(op.equals("+")) {
                        int con_a = convertToDecimal(s[i][0], j);
                        int con_b = convertToDecimal(s[i][2], j);
                        int con_result = convertToDecimal(s[i][3], j);
                        if(con_a + con_b != con_result) flag = true;
                    } else {
                        int con_a = convertToDecimal(s[i][0], j);
                        int con_b = convertToDecimal(s[i][2], j);
                        int con_result = convertToDecimal(s[i][3], j);
                        if(con_a - con_b != con_result) flag = true;
                    }
                    
                    if(flag) notAvailable[j] = true;
                }
            }
        }
        
        for(int i = 0; i < length; i++) {
            if(s[i][3].equals("X")) {
                List<String> list = new ArrayList<>();
                for(int j = max; j <= 9; j++) {
                    if(notAvailable[j]) continue;
                    
                    int a = Integer.parseInt(s[i][0]);
                    int b = Integer.parseInt(s[i][2]);
                    
                    String op = s[i][1];
                    if(op.equals("+")) {
                        int con_a = convertToDecimal(s[i][0], j);
                        int con_b = convertToDecimal(s[i][2], j);
                        int sum = con_a+ con_b;
                        String result = convertFromDecimal(sum, j);
                        // System.out.println(j + "진법 = " + result);
                        if(!list.contains(result)) list.add(result);
                    } else {
                        int con_a = convertToDecimal(s[i][0], j);
                        int con_b = convertToDecimal(s[i][2], j);
                        int sum = con_a - con_b;
                        String result = convertFromDecimal(sum, j);
                        // System.out.println(j + "진법 = " + result);
                        if(!list.contains(result)) list.add(result);
                    }
                }
                
                String res = "";
                if(list.size() != 1) {
                    res = "?";
                } else {
                    res = list.get(0);
                }
                String str = expressions[i].split(" = ")[0] + " = " + res;
                answer.add(str);
            } 
        }
        
        return answer;
    }
    
    private static int convertToDecimal(String num, int k) {
        int n = Integer.parseInt(num);
        int total = 0;
        
        int length = num.length();
        int p = length - 1;
        for(int i = 0; i < length; i++) {
            int digit = Integer.parseInt(num.substring(i, i + 1));
            
            int x = (int) Math.pow(k, p--) * digit;
            total += x;
        }
        
        return total;
    }
    
    private static String convertFromDecimal(int num, int k) {
        String str = "";
        
        if(num == 0) return "0";
        
        while(num > 0) {
            int x = num % k;
            
            str = x + str;
            
            num /= k;
        }
        
        return str;
    }
}