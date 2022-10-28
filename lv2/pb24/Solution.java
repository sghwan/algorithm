package lv2.pb24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * k진수에서 소수 개수 구하기
 */
public class Solution {
    private boolean isPrime(long num) {
        if(num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String kNotation = Integer.toString(n, k);
        String regex = "([1-9]+)";
        System.out.println("kNotation = " + kNotation);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(kNotation);

        while(matcher.find()) {
            long num = Long.parseLong(matcher.group());
            if(isPrime(num)) answer++;
        }

        return answer;
    }
}
