package baekjoon.basic1.Math_300;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Scanner;

public class _1212_jinsu {

    /**
     * 문제
     * 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.
     * <p>
     * 출력
     * 첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
     * <p>
     * 예제
     * 입력          ->      출력
     * 11001100     ->      314
     */
    public static void main(String[] args) {

        solution2();
    }

    ;


    /**
     * 문제개념
     * 진수     https://itbeginner2020.tistory.com/17
     * 2진법이란, 0~1까지의 2개의 숫자를 사용해서 수를 표현한다.
     * 8진법이란, 0~7 까지의 8개의 숫자를 사용해서 수를 표현한다.
     * 16진법이란, 0~9 까지의 10개의 숫자를 사용하고 남는 자리는 A~F 까지 6개의 문자를 사용해서 수를 표현한다.
     * <p>
     * 원리
     * 110101 이라는 이진수가 있을 때
     * 세 자리씩 끊어서 10진수로 변환하면 8진수가 된다.
     * 110/101
     * 110 -> 6
     * 101 -> 5
     * =>65
     * <p>
     * 추론
     * 수를 표현할때 8진수는 8개수로 표현
     * <p>
     * 3자리씩 끊는 것.
     **/

    public static void solution2() {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        if (n % 3 == 1) { //세 자리씩 끊었을 때 맨 앞에 한 자리만 남는경우
            System.out.println(s.charAt(0));
        } else if (n % 3 == 2) { //두 자리만 남는경우
            System.out.println((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0'));
        }
        //나머지 경우
        for (int i = n % 3; i < n; i += 3) {
            System.out.println((s.charAt(i) - '0') * 4 + (s.charAt(i + 1) - '0') * 2 + (s.charAt(i + 2) - '0'));
        }
    }


}