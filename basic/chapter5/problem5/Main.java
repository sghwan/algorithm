package chapter5.problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(String bracket) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                stack.add(bracket.charAt(i));
            } else {
                stack.pop();
                if (bracket.charAt(i - 1) == '(') answer += stack.size();
                else answer += 1;
            }
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
