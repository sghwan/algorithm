package lv2.pb34;

import java.util.Stack;

/**
 * 주식 가격
 */
class Solution {
    public int calculateSecond(int currentIndex, int[] prices) {
        Stack<Integer> s = new Stack<>();
        int currentPrice = prices[currentIndex];
        int nextIndex = currentIndex + 1;
        boolean flag = true;

        for (int i = nextIndex; i < prices.length; i++) {
            if(!flag) break;
            if(currentPrice > prices[i]) flag = false;
            s.push(prices[i]);
        }

        return s.size();
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length - 1; i++) {
            answer[i] = calculateSecond(i, prices);
        }

        answer[prices.length - 1] = 0;

        return answer;
    }
}
