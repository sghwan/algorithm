package chapter5.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String solution(String bracket) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char x : bracket.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }

        if (stack.size() > 0) answer = "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();
        System.out.println(solution(bracket));
        return;
    }
}
