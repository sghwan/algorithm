package chapter1.problem8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static String solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String reversedStr = new StringBuilder(s).reverse().toString();

        if (s.equals(reversedStr)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
        return;
    }
}