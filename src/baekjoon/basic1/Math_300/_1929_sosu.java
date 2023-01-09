package baekjoon.basic1.Math_300;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Arrays;

public class _1929_sosu {

    /**
     * 문제
     * 1~ end 범위내 소수를 찾아라.
     */
    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        //String[] strArr = io.scanner_space();

        // 입력-제출용
        String[] strArr = {"3", "42"};


        // solve
        solution(strArr);

        // solve
        solution2(Integer.parseInt(strArr[1]));
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
     * 빈복 과정 : 소수로 시작한 숫자에서 2~16까지 인덱스로 나누어 떨어지면 제거
     * <p>
     * 절차 분기 : 나눌숫자가 2인경우 16까지 나눈다.
     * 나눌숫자에서도 지운다.
     * <p>
     * 패턴화
     * 자료구조 : 나눌숫자를 미리 비열에 담아둠.
     * <p>
     * 처리 : dfs()
     * <p>
     * 시간복잡도 : 100 + M
     * <p>
     * solution2
     * 빈복 과정 : i(1~100) < j(1~소수만)
     * <p>
     * 절차 분기 : i % j == 0 인 count
     * <p>
     * 패턴화
     * 처리 : 이중 for문
     * <p>
     * 시간복잡도 : N*K
     * <p>
     * <p>
     * <p>
     * 구현
     * solution1   1~end 범위의 소수 구하기
     * - [2,4,6,8,10,12,16] 준비
     * <p>
     * - [2,4,6,8,10,12,16] 제거
     * - [3,6,9,12] 제거
     * - [4,8] 제거
     * - ...
     * - [2,3,4,...,k]         반복은 sosu>end 까지
     * <p>
     * solution2    1~100 범위의 소수 구하기
     * - 2 -> [2]
     * - if(count==1) 체크
     * - 3 -> [2,3]
     * - if(count==1) 체크
     * - 4 -> [2,3,4]
     * - if(count==1) 체크
     * ...
     * - k -> [2,3,4,...,k]         반복은 sosu(end)까지
     */
    public static void solution(String[] strArr) {
        int answer = 0;
        int start = Integer.parseInt(strArr[0]);
        int end = Integer.parseInt(strArr[1]);


        ArrayList<String> sosuArr = new ArrayList(end - start + 1);
        for (int i = start; i <= end; i++) {
            sosuArr.add(Integer.toString(i));
        }
        ;
        //System.out.printf("전 sosuArr = %s \n", sosuArr );

        // 1 ~ 16
        getDfs(sosuArr, end, 2);

        // 답
        System.out.println(sosuArr);

    }

    public static void getDfs(ArrayList<String> sosuArr, int end, int sosu) {
        //System.out.printf("중 sosuArr = %s, end = %d, sosu = %d \n", sosuArr, end, sosu);

        if (sosu > end) {
            return;
        }


        for (int i = 2; i <= end; i++) {
            //System.out.printf("중 i = %d, sosu * i = %d , sosuArr.contains( sosu * i ) = %b \n", i, sosu * i, sosuArr.contains(Integer.toString(sosu * i)));
            System.out.printf("sosu = %d, i = %d (sosu * i = %d ) \n", sosu, i, sosu * i);

            // 주어진 수보다 작은 경우.
            if (sosu * i < end) {

                if (sosuArr.contains(Integer.toString(sosu * i))) {
                    sosuArr.remove(Integer.toString(sosu * i));
                }
                // 주어진 수보다 큰 경우
            } else {
                getDfs(sosuArr, end, sosu + 1);
                break;
            }
        }
        ;

    }


    public static ArrayList<Integer> solution2(int end) {
        ArrayList<Integer> sosuList = new ArrayList<Integer>();
        System.out.println("end = " + end);

        // 1 ~ 100
        for (int i = 2; i <= end; i++) {
            int count = 0;

            System.out.printf("\n i = " + i + " ");
            // 1 ~ 소수
            for (int k = 2; k <= i; k++) {
                System.out.printf("k = %d , ", k);
                if (i % k == 0) {
                    count++;
                }
                ;
            }
            ;

            if (count == 1) {
                System.out.printf("\n %d 는 소수입니다. ", i);
                sosuList.add(i);
            }
        }
        ;

        return sosuList;
    }


}