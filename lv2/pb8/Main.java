package lv2.pb8;

/**
 * 카펫
 */
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        for (int height = 1; height * height <= yellow; height++) {
            if(yellow % height == 0) {
                int width = yellow / height;
                int requiredBrown = 2 * height + 2 * width + 4;
                if(requiredBrown == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }

        return answer;
    }
}
