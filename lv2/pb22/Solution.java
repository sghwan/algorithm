package lv2.pb22;

import java.util.*;

/**
 * 프린터
 */
class Paper {
    int l, p;

    public Paper(int l, int p) {
        this.l = l;
        this.p = p;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Paper(i, priorities[i]));
        }

        Arrays.sort(priorities);

        int index = priorities.length - 1;
        int max = priorities[index];

        while (true) {
            if(q.peek().p < max) q.add(q.poll());
            else {
                answer++;
                Paper p = q.poll();
                if(p.l == location) break;
                else max = priorities[--index];
            }
        }

        return answer;
    }
}
