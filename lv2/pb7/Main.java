package lv2.pb7;

/**
 * 다음 큰 숫자
 */
class Solution {

    public int countOne(int n) {
        int cnt = 0;
        String binary = Integer.toString(n, 2);
        for (char x : binary.toCharArray()) {
            if(x == '1') cnt++;
        }
        return cnt;
    }

    public int solution(int n) {
        int answer = 0;
        int cnt = countOne(n);
        int s = n + 1;
        boolean flag = false;

        while(!flag) {
            int nextCnt = countOne(s);
            if(nextCnt == cnt) flag = true;
            else s++;
        }

        answer = s;

        return answer;
    }

}
