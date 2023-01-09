package baekjoon.basic1.Math_300;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Arrays;

public class _10872_factorial {

    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        //String[] strArr = io.scanner_space();

        // 입력-제출용
        int n = 10;


        // solve
        solution_for(n);

        // solve
        solution_jaegui(n, 1);

        // solve
        System.out.println(solution_jaegui2(10));

    }

    ;

    /**
     * 개념 원리
     * 개념
     * 팰토리얼    n이 하나의 자연수일 때, 1에서 n까지의 모든 자연수의 곱을 n에 상대하여 이르는 말이다.
     * n! = n * (n -1) * (n -2) * ... * 3 * 2 * 1
     * 원리
     * https://marobiana.tistory.com/79
     * 두번째로 호출된 fact(3)은 종료되지 않은 상태로 Stack에 쌓이고,fact(3)이 호출한 fact(2)이 실행된다
     * <p>
     * 구현
     * loof_for    solution1
     * loof_재귀
     * 단계	코드의 흐름
     * 1	10 * factorial ( 9 )
     * 2	10 * 9 * factorial ( 8 )
     * 3	10 * 9 * 8 * factorial ( 7 )
     * 4	10 * 9 * 8 * 7 * factorial ( 6 )
     * 5	10 * 9 * 8 * 7 * 6 * factorial ( 5 )
     * <p>
     * <p>
     * 효과
     * 장점
     * 재귀호출을 사용하는 이유는 코드의 목적과 가독성 입니다.
     * 이 반복문이 어떤 목적인지 코드를 모두 해석해야 의미를 파악할 수
     * <p>
     * 단점
     * For문에 비해 재귀함수를 이용하면 속도도 떨어지고, 메모리 낭비도 심해집니다.
     * <p>
     * 보완
     * 이러한 문제가 있음에도 재귀함수가 사용되는 이유가 무엇일까요?
     * 1. 동적프로그램이나 병합정렬, 그래프탐색알고리즘 등의 특정한 부분의 개발에 유리하다.
     * 2. 가독성이 높다.
     * 3. 변수의 사용을 줄여준다.
     */

    public static void solution_for(int n) {

        int sum = 1;

        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }

        System.out.println(sum);

    }

    /**
     * 1 ) 함수 호출 → 재귀
     * 재귀는 종료 시점을 가정하고, 함수를 반복해서 호출하는 귀납적인 접근 방법이다.
     * <p>
     * 2 ) 반복문
     * 특정 절차 기준 종료
     * <p>
     * 3 ) 분기문
     * 특정 조건을 기준으로 절차를 나눈다.
     * <p>
     * <p>
     * solution_jaegui         param으로 sum
     * solution_jaegui2        리턴으로 sum
     */
    public static void solution_jaegui(int n, int sum) {

        // 종료 시점
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        ;

        // 종료 시점이 아닌경우
        sum = sum * n;
        solution_jaegui(n - 1, sum);
    }

    public static int solution_jaegui2(int n) {

        // 종료 시점
        if (n <= 1) {
            return n;
            // 종료 시점이 아닌경우
        } else {
            return n * solution_jaegui2(n - 1);
        }

    }


}