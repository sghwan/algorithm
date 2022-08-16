package chapter4.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static String solution(String str1, String str2) {
        String answer = "YES";

        Map<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            int value = hash.getOrDefault(str1.charAt(i), 0);
            if (value == 0) hash.put(str1.charAt(i), 1);
            else hash.put(str1.charAt(i), value + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            int value = hash.getOrDefault(str2.charAt(i), 0);
            if (value == 0 || value < 0) {
                answer = "NO";
                break;
            } else {
                hash.put(str2.charAt(i), value - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str1, str2));
        return;
    }
}

