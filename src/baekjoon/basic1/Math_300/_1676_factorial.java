package baekjoon.basic1.Math_300;

import util.IO.SystemIO;

public class _1676_factorial {

    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        //String[] strArr = io.scanner_space();

        // 입력-제출용
        int n = 10;

        // solve
        System.out.println(solution(10));

    }

    ;

    /**
     * 문제
     * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오
     * <p>
     * 원리
     * 0은 값이 아니라 형태를 의미.
     * 결과값에 0형태의 갯수를 구하는것.
     * 10! = 362880                    -> 갯수 2
     * 500! = 2432902008176640000      -> 갯수 124
     * <p>
     * 0의 갯수를 어떻게 구할 수 있을까요?
     * 1부터 500까지 곱해 나갈때
     * 0이 언제 1개씩 생기는지를 조사해서, 그 갯수를 하나씩 세면 되는 것이지요 :)
     * <p>
     * 1부터 5까지 곱해볼까요?
     * 1x2x3x4x5 = 120
     * 엇, 10을 곱한 적이 없는데 0이 하나 따라붙었군요.
     * 그것은 바로 2x5가 10이기 때문입니다.
     * <p>
     * 처음에는 무식하게 팩토리얼 값을 구한 뒤 0의 값을 구해 보려고 했지만 20만 넘어가도 long으로는 담을 수가 없다 나머지 연산을 이용해 뒷부분만 뽑아 보려고 했지만 그마저도 넘어간다
     * 이 문제는 팩토리얼 값을 구하는 문제가 아니라 소인수분해를 잘 이용하는 문제에 가깝다
     * 가장 뒷자리가 0이 되기 위해서는 2*5의 합이 있어야 하는데, 2는 무조건 짝수에 포함되어 있기 때문에 5가 몇 번 들어갔는지만 계산해 주면 된다
     * 때문에 값을 5로 나눠 준 뒤 5의 제곱수(25, 125등)에서 계속해서 나눠주는 방식을 사용했다
     * <p>
     * 플로우
     * ( 2 * 5 ) 소인수 분해.
     * 제곱수 을 쌓는다.
     * 카운팅 을 쌓는다.
     * <p>
     * 효율
     * 1.제곱수
     * 무한루프 + 자바 복합연산자 사용
     * ex. 5의 배수 + 25의 배수 + 125의 배수    ( factorial_count0 클래스 )
     * 메스라이브러의 제곱수 이용.
     * ex. Math.pow(5, 2); //5의제곱
     */

    // 5의 배수 + 25의 배수 + 125의 배수 + ...
    public static int solution(int N) {

        int ans = 0;

        while (true) {
            if (N < 5) break;
            ans += N / 5;   // 카운팅
            N /= 5;         // 제곱수
        }

        return ans;
    }


}