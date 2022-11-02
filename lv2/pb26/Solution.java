package lv2.pb26;

import java.util.PriorityQueue;

/**
 * 더 맵게
 */
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : scoville) {
            pq.add(x);
        }

        while (true) {
            if(pq.size() == 1 && pq.peek() < K) return -1;
            if(pq.size() == 1 && pq.peek() >= K) return answer;

            int first = pq.poll();
            int second = pq.poll();

            if (first >= K) break;

            pq.add(first + (second * 2));

            answer++;
        }

        return answer;
    }
}
