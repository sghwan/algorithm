package lv2.pb13;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        double da = a, db = b;

        while(da != db) {
            da = Math.ceil(da / 2.0);
            db = Math.ceil(db / 2.0);
            answer++;
        }

        return answer;
    }
}
