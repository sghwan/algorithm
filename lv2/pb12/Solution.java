package lv2.pb12;

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int lt = 0, rt = people.length - 1;

        Arrays.sort(people);

        while(lt <= rt) {
            int judge = people[rt--];
            if (judge + people[lt] <= limit) lt++;
            answer++;
        }

        return answer;
    }
}
