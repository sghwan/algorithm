package lv2.pb31;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 스킬트리
 * 다른 사람 풀이에 정규식을 이용한 좋은 풀이법 있음.
 */
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            Queue<Character> q = new LinkedList<>();
            boolean[] check = new boolean[26];

            for (int i = 0; i < skill.length(); i++) {
                q.add(skill.charAt(i));
            }

            for (int i = 0; i < skill_tree.length(); i++) {
                int index = (int) (skill_tree.charAt(i) - 'A');
                check[index] = true;
                if (q.isEmpty())
                    break;
                if (q.peek() == skill_tree.charAt(i)) {
                    q.poll();
                }
            }

            System.out.println();

            while (!q.isEmpty()) {
                int index = (int) (q.peek() - 'A');
                if (check[index])
                    break;
                q.poll();
            }

            if (q.isEmpty())
                answer++;
        }

        return answer;
    }
}
