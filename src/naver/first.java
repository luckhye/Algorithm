package naver;

import util.IO.SystemIO;

import java.util.ArrayList;

/**
 * 제출 폼
 * <p>
 * public class Main {
 * public static void main(String[] args) {
 * //solution(strArr);
 * }
 * }
 */


public class first {

    public static void main(String[] args) {

        // 입력
        //SystemIO io = new SystemIO();
        //ArrayList<String> lineList = io.scanner_auto();


        // solve
        int param1 = (int) (Math.random() * 100000000);
        System.out.println("param1 = " + param1);


        System.out.println("답 = " + solution(param1));
    }

    ;


    public static int solution(int N) {
        int result = 1;

        if (N != 1) {
            int len = Integer.toString(N).length();
            System.out.println("len = " + len);

            result = (int) (Math.pow(10, len) / 10);
            System.out.println("result = " + (result + "").length());
        }
        ;

        return result;

    }


}