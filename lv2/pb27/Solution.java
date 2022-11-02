package lv2.pb27;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        int length = 0;
        Map<String, String> hashMap = new HashMap<>();

        for (String r : record) {
            String[] str = r.split(" ");
            String status = str[0];
            String userId = str[1];
            if(str.length == 3) {
                String name = str[2];
                hashMap.put(userId, name);
            }
            if(!status.equals("Change")) length++;
        }

        String[] answer = new String[length];
        int idx = 0;

        for (String r : record) {
            String[] str = r.split(" ");
            String status = str[0];
            String userId = str[1];
            String name = hashMap.get(userId);
            if(status.equals("Enter")) answer[idx++] = name + "님이 들어왔습니다.";
            else if(status.equals("Leave")) answer[idx++] = name + "님이 나갔습니다.";
        }

        return answer;
    }
}
