package baekjoon.basic1.Math_300;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Arrays;

public class _6588_goldbach {

    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        //String[] strArr = io.scanner_space();

        // 입력-제출용
        int[] intArr = {8, 20, 42, 0};


        // solve
        solution(intArr);

    }

    ;

    /**
     * 개념 원리
     * 소수  1과 나자신밖에 못나눠짐.
     * 원리
     * 자기가신까지의 수를 나눠본다.
     * 자기자신까지의 구구단값을 제거한다.
     * <p>
     * 설계
     * solution1
     * 1. 1~100 까지의 소수 구하기 -> 함수.
     * 2. 소수의합 만족한는 두 수 a,b 구하기 -> 구현
     */

    public static void solution(int[] intArr) {
        // 정렬
        Arrays.sort(intArr);

        // 소수 구하기
        _1929_sosu sf = new _1929_sosu();
        ArrayList<Integer> sosuList = sf.solution2(intArr[intArr.length - 1]);
        System.out.println("sosuList = " + sosuList);

        // 소수의합 만족한는 두 수 a,b 구하기
        for (int r : intArr) {

            for (int a : sosuList) {
                int b = r - a;

                if (b <= 0) {
                    break;
                } else if (sosuList.contains(b)) {
                    System.out.println(r + " = " + a + " + " + b);
                    break;
                }
            }

        }

    }


}