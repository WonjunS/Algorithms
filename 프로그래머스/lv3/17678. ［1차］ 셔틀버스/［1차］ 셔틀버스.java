import java.util.*;

class Solution {
    
    static int N, T, M;
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        N = n;
        T = t;
        M = m;
        
        int last_time = 540 + ((n - 1) * t);
        
        Arrays.sort(timetable);
        
        int time = binarySearch(timetable, last_time);
        answer = convertToTimeFormat(time);
        
        return answer;
    }
    
    static String convertToTimeFormat(int time) {
        String hh = String.valueOf(time / 60);
        String mm = String.valueOf(time % 60);
        
        if(hh.length() < 2) {
            hh = "0" + hh;
        }
        if(mm.length() < 2) {
            mm = "0" + mm;
        }
        
        return hh + ":" + mm;
    }
    
    static int binarySearch(String[] timetable, int x) {
        int L = 0, R = x;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(isAvailable(timetable, mid)) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        
        return R;
    }
    
    static boolean isAvailable(String[] timetable, int k) {        
        int[] passengers = new int[N];
        
        for(int i = 0; i < timetable.length; i++) {
            String[] str = timetable[i].split(":");
            int hh = Integer.parseInt(str[0]);
            int mm = Integer.parseInt(str[1]);
            
            int time = (hh * 60) + mm;
            if(time > k) {
                break;
            }
            
            for(int j = 0; j < N; j++) {
                int bus_time = 540 + (j * T);
                if(bus_time >= time && passengers[j] < M) {
                    passengers[j]++;
                    break;
                }
            }
        }
        
        return passengers[N - 1] < M;
    }
}