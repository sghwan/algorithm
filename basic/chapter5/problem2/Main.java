package chapter5.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static String solution(String bracket) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : bracket.toCharArray()) {
            if (x == ')') {
                if(stack.isEmpty()) continue;
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();
        System.out.println(solution(bracket));
        return;
    }
}
