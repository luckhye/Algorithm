package baekjoon.basic1.Math_300;

import java.util.Arrays;
import java.util.Scanner;

public class _1374_jinsu {

    /**
     * 문제
     * 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.
     * <p>
     * 출력
     * 첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
     * <p>
     * 예제
     * 입력      ->      출력
     * 314      ->      11001100
     */
    public static void main(String[] args) {

        // 한자리수 변환
        convert_num1(6);
        convert_numM(3316);
    }

    ;

    public static String convert_num1(int N) {

        // 8진수 -> 2진수.
        //      ex. 6 -> 1 , 1, 0
        int i = 2;
        String jinsu2 = "";
        while (i >= 0) { // 3등분
            jinsu2 += N / (int) Math.pow(2, i);
            N = N % (int) Math.pow(2, i);
            System.out.printf("\n i = %d, jinsu2 = %s, n = %d ", i, jinsu2, N);
            i--;
        }

        System.out.println("jinsu2 = " + jinsu2);
        return jinsu2;
    }

    // M자리수 변환
    public static void convert_numM(int N) {

        // M자리수
        // 3    3    1    6
        // 011, 011, 001, 110
        String reduceStrResult = Arrays.stream(Integer.toString(N).split("")).reduce("", (partString, element) -> partString + convert_num1(Integer.parseInt(element)));
        System.out.println("reduceStrResult = " + reduceStrResult);

        // 의미없는 0 제거
        reduceStrResult.replaceFirst("0$", "");
        System.out.println("reduceStrResult = " + reduceStrResult);


    }

}