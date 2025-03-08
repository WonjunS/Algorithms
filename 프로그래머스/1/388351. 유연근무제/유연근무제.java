import java.util.*;

class Solution {
    
    private static class Employee {
        private int empNo;
        private int point;
        
        private Employee(int empNo, int point) {
            this.empNo = empNo;
            this.point = point;
        }
        
        private void addPoint() {
            this.point++;
        }
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = timelogs.length;
        
        List<Employee> employees = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            Employee e = new Employee(i, 0);
            employees.add(e);
        }
        
        int day = startday;
        for(int i = 0; i < timelogs[0].length; i++) {
            if(isWeekend(day)) {
                day++;
                continue;
            }
            
            for(int j = 0; j < n; j++) {
                int wishTime = calcTime(schedules[j]);
                int arrivedTime = calcTime(timelogs[j][i]);
                // System.out.println("no = " + (j + 1) + ", wishTime = " + wishTime + ", arrivedTime = " + arrivedTime);
                if(wishTime + 10 >= arrivedTime) {
                    employees.get(j).addPoint();
                }
            }
            // System.out.println("---------------");
            
            day++;
        }
        
        employees.sort((e1, e2) -> (e2.point - e1.point));
        
        int prev = -1;
        for(Employee e : employees) {
            int point = e.point;
            if(point < 5) {
                break;
            }
            if(prev == -1 || point == prev) {
                answer++;
                prev = point;
            } else {
                break;
            }
        }
        
        return answer;
    }
    
    private static boolean isWeekend(int day) {
        int k = day % 7;
        if(k == 6 || k == 0) {
            return true;
        }
        return false;
    }
    
    private static int calcTime(int time) {
        int hour = time / 100;
        int mins = time % 100;
        
        return (hour * 60) + mins;
    }
}