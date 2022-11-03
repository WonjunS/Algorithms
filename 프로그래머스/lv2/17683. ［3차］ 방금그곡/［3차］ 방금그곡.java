import java.util.*;

class Solution {
    class Music {
        private int time;
        private String title;
        private String melody;
        
        public Music(int time, String title, String melody) {
            this.time = time;
            this.title = title;
            this.melody = melody;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        List<Music> musicList = new ArrayList<>();
        String answer = "(None)";
        m = replace(m);
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            
            String start_time = str[0];
            String[] str1 = start_time.split(":");
            int h1 = Integer.parseInt(str1[0]);
            int m1 = Integer.parseInt(str1[1]);
            int t1 = (60 * h1) + m1;
            
            String end_time = str[1];
            String[] str2 = end_time.split(":");
            int h2 = Integer.parseInt(str2[0]);
            int m2 = Integer.parseInt(str2[1]);
            int t2 = (60 * h2) + m2;
            
            String title = str[2];
            String melody = str[3];
            
            melody = replace(melody);
            
            boolean correct = isCorrect(m, melody, (t2 - t1 + 1));
            if(correct) {
                if(answer.equals("(None)")) {
                    musicList.add(new Music((t2 - t1 + 1), title, melody));
                    answer = title;
                } else {
                    if((t2 - t1 + 1) > musicList.get(0).time) {
                        musicList.remove(0);
                        musicList.add(new Music((t2 - t1 + 1), title, melody));
                        answer = title;
                    }
                    else continue;
                }
            }
        }
        
        return answer;
    }
    
    static boolean isCorrect(String m, String melody, int time) {
        String str = "";
        List<String> list = new ArrayList<>();
        for(int i = 0; i < melody.length(); i++) {
            str = String.valueOf(melody.charAt(i));
            list.add(str);
        }

        String compare = "";
        for(int i = 0; i < time; i++) {
            compare += list.get((i % list.size()));
        }
        if(compare.contains(m)) return true;
        return false;
    }
    
    static String replace(String str){
        str = str.replaceAll("C#", "H");
        str = str.replaceAll("D#", "I");
        str = str.replaceAll("F#", "J");
        str = str.replaceAll("G#", "k");
        str = str.replaceAll("A#", "L");
        return str;
    }
}