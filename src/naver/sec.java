package naver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 제출 폼
 * <p>
 * public class Main {
 * public static void main(String[] args) {
 * //solution(strArr);
 * }
 * }
 */


public class sec {

    public static void main(String[] args) {

        // 입력
        //SystemIO io = new SystemIO();
        //ArrayList<String> lineList = io.scanner_auto();


        // solve
        String param1 = "azABaabza";
        System.out.println("답 = " + solution(param1));
    }

    ;


    public static int solution(String str) {
        int result = 1;

        char[] chars = str.toCharArray();

        ArrayList<Integer> cntArr = new ArrayList<>();


        int existCnt = 0;
        for (char c : chars) {

            if (Character.isLowerCase(c)) {
                Boolean flag = str.contains(String.valueOf(Character.toUpperCase(c)));

                if (flag) {
                    ++existCnt;
                } else {
                    cntArr.add(existCnt);
                    existCnt = 0;
                }

            }

            if (Character.isUpperCase(c)) {
                Boolean flag = str.contains(String.valueOf(Character.toLowerCase(c)));

                if (flag) {
                    ++existCnt;
                } else {
                    cntArr.add(existCnt);
                    existCnt = 0;
                }
                ;
            }
            ;
        }
        ;

        return Collections.min(cntArr);

    }


}