package chapter4.problem4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static int solution(String str1, String str2) {
        int answer = 0, lt = 0;
        Map<Character, Integer> resultMap = new HashMap<>();
        Map<Character, Integer> tmpMap = new HashMap<>();

        for (char x : str2.toCharArray())
            resultMap.put(x, resultMap.getOrDefault(x, 0) + 1);

        for (int i = 0; i < str2.length() - 1; i++)
            tmpMap.put(str1.charAt(i), tmpMap.getOrDefault(str1.charAt(i), 0) + 1);

        for (int rt = str2.length() - 1; rt < str1.length(); rt++) {
            tmpMap.put(str1.charAt(rt), tmpMap.getOrDefault(str1.charAt(rt), 0) + 1);
            if (tmpMap.equals(resultMap)) answer++;
            tmpMap.put(str1.charAt(lt), tmpMap.get(str1.charAt(lt)) - 1);
            if (tmpMap.get(str1.charAt(lt)) == 0) tmpMap.remove(str1.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.print(solution(str1, str2));

        return;
    }
}
