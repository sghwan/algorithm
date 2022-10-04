package lv2.pb16;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;
        String[] cache = new String[cacheSize];

        for (int i = 0; i < cities.length; i++) {
            boolean flag = false;
            int idx = cacheSize - 1;
            String c1 = cities[i].toLowerCase();

            for (int j = 0; j < cacheSize; j++) {
                String c2;
                if(cache[j] == null) c2 = "";
                else c2 = cache[j].toLowerCase();

                if(c1.equals(c2)) {
                    idx = j;
                    flag = true;
                    break;
                }
            }

            for (int k = idx; k >= 1; k--) {
                cache[k] = cache[k - 1];
            }

            if (flag) answer += 1;
            else answer += 5;

            cache[0] = cities[i];
        }

        return answer;
    }
}
