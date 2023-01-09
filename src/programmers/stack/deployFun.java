package programmers.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 제출 폼
 * <p>
 * public class Main {
 * public static void main(String[] args) {
 * //solution(strArr);
 * }
 * }
 */


public class deployFun {

    public static void main(String[] args) {

        // 입력
        int[] progresses = {93, 30, 55};
        int[] speed = {1, 30, 5};

        // solve
        System.out.println("답 = " + Arrays.toString(solution(progresses, speed)));
    }

    ;


    public static int[] solution(int[] progresses, int[] speed) {
        int[] answer = new int[progresses.length];

        // progresses = {93, 30, 55}
        // speed = {1, 30, 5}
        // -> [2, 1] 을 return 합니다.
        int workDay = 0;

        // workday arr
        int[] workDayArr = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            workDayArr[i] = getWorkDay(progresses[i], speed[i]);
        }

        int deployIdx = 0;
        Stack s = new Stack<>();
        for (int j = 0; j < workDayArr.length; j++) {

            if (j == 0) {
                s.push(workDayArr[j]);
                System.out.printf("\n j = %d, workDayArr[j] = %d , peek = %d ", j, workDayArr[j], (int) s.peek());
            } else {
                int peek = (int) s.peek();

                // 비교해서 만족할경우, 결과 카운트 증가.
                System.out.printf("\n j = %d, workDayArr[j] = %d , peek = %d ", j, workDayArr[j], peek);
                if (workDayArr[j] < peek) {
                    System.out.printf("answer[%d] = %d", deployIdx, answer[deployIdx]);
                    answer[deployIdx] += 1;

                    // 비교해서 만족안할경우, 결과배열의 인덱스를 증가.
                    // 비교해서 만족안할경우, 비교값은 스택에 추가
                } else {
                    s.add(workDayArr[j]);
                    deployIdx++;
                }
            }
            ;
        }
        ;


        return answer;
    }

    public static int getWorkDay(int progresses, int speed) {
        int[] answer = {};

        // progresses = {93, 30, 55}
        // speed = {1, 30, 5}
        // -> [2, 1] 을 return 합니다.

        int mock = (100 - progresses) / speed;
        int workDay = (100 - progresses) % speed == 0 ? mock : mock + 1;

        return workDay;
    }


}