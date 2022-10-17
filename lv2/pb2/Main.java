package lv2.pb2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JadenCase 문자열 만들기
 */
class Solution {
    public String solution(String s) {
        boolean isNextUpper = true;
        StringBuffer sb = new StringBuffer();

        for (int inx = 0; inx < s.length(); inx++) {
            char c = s.charAt(inx);
            if (inx == 0 || isNextUpper) {
                sb.append(Character.toUpperCase(c));
                isNextUpper = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }

            if (c == ' ') {
                isNextUpper = true;
            }
        }
        return sb.toString();
    }
}
