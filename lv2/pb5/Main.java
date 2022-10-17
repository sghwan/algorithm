package lv2.pb5;

/**
 * 숫자의 표현
 */
class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0, lt = 1;

        for(int i = 1; i <= n / 2 + 1; i++) {
            sum += i;
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= lt++;
                if(sum == n) answer++;
            }
        }
        return answer;
    }
}

