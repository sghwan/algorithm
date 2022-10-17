package lv2.pb18;

import java.util.Stack;

/**
 * 괄호 회전하기
 */
class Solution {
    public int checkBracket(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '[' || x == '{' || x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return 1;
                if (stack.peek() == '[' && x == ']') stack.pop();
                else if (stack.peek() == '{' && x == '}') stack.pop();
                else if (stack.peek() == '(' && x == ')') stack.pop();
            }
        }

        return stack.size();
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (checkBracket(s) == 0) answer++;
        }

        return answer;
    }
}