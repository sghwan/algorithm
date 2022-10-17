package lv2.pb15;

/**
 * 점프와 순간 이동
 */
public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if(n % 2 == 0) n = n / 2;
            else {
                n = (n - 1) / 2;
                ans++;
            }
        }

        return ans;
    }
}
