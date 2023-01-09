package baekjoon.basic1.Dynamic1;

import util.IO.SystemIO;

import java.util.ArrayList;

public class _11726_tailing {

    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        ArrayList<String> lineList = io.scanner_auto();

        // solve
        int n = Integer.parseInt(lineList.get(0));
        System.out.println("답 = " + solution(n));
    }

    ;

    // 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수.
    // 점화식 구현
    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 2;

        // An-1 + An-2 = An
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1007;
        };

        return answer;
    }


}