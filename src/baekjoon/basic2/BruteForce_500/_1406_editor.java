package baekjoon.basic2.BruteForce_500;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Arrays;

public class _1406_editor {

    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        ArrayList<String> lineList = io.scanner_auto();

        // solve
        int Ena = 15;
        int Sna = 28;
        int Mna = 19;
        System.out.println("답 = " + solution(lineList));

    }

    ;

    //    P x
//    L
//    P y
    public static int solution(ArrayList<String> lineList) {
        String answer = "";
        String str = lineList.get(0);

        int cmdCnt = Integer.parseInt(lineList.get(1));
        // 커서 디펄트
        int N = str.length();
        int currIdx = getCsIdx(N);


        // 커맨드 반복수.
        for (int i = 0; i < cmdCnt; i++) {
            String cmd = lineList.get(i + 1);


            if (cmd.contains("P")) {
                String[] arr = cmd.split("");
                String addStr = arr[1];

                // 커서
                N++;
                currIdx = getCsIdx(N);
                // 문자 중간 삽입/삭제/추가
                //str.substring(addStr,  )


            }

        }

        return 0;

    }

    private static int getCsIdx(int N) {
        return N * 2 + 1;
    }

    private static int getStIdx(int N) {
        return N * 2;
    }


}