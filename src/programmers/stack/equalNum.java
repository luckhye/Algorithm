package programmers.stack;

import java.util.Stack;


public class equalNum {

    public static void main(String[] args) {

        // 입력
        int[] test = {1, 1, 3, 3, 0, 1, 1};

        // solve
        int param1 = 4;
        System.out.println("답 = " + solution(test));
    }

    ;


    public static int[] solution(int[] arr) {
        int[] answer = {};

        // arr = [1, 1, 3, 3, 0, 1, 1] -> [1, 3, 0, 1] 을 return 합니다.

        /**
         *  stack
         *      peek
         *      자료구조
         *
         *  list
         *      마지막 값
         *      temp
         *
         *  '직전'에 나오는걸 '비교'를 한다.
         *
         *
         *  추가 분석
         *         // 비교값은 다음값만.
         *         //      비교란?
         *         //          이전값을 담을 자료구조
         *         //          특정 이전값만 필터.
         * */

        Stack s = new Stack<>();    // 비교할 문자열
        int j = 0;
        for (int i : arr) {

            System.out.println("아이템 i = " + i);
            if (s.size() == 0) {
                s.add(i);

            } else {
                // 동일하지 않다면 추가.
                System.out.printf("i", i);
                int peek = (int) s.peek();
                System.out.println(peek);
                if (peek != i) {
                    s.add(i);
                    answer[j] = i;
                    //System.out.println("i = "+i);
                    j++;
                }
                ;
            }
            ;


        }
        ;

        return answer;
    }


}