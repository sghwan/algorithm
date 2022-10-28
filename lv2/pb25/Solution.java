package lv2.pb25;

import java.util.Arrays;

/**
 * 타겟 넘버
 */
class Solution {
    public int dfs(int i, int sum, int[] numbers, int target) {
        if (i == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }

        return dfs(i + 1, sum + numbers[i], numbers, target) + dfs(i + 1, sum - numbers[i], numbers, target);
    }

    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
}
