package baekjoon.basic2.BruteForce_500;

import util.IO.SystemIO;

import java.util.ArrayList;

public class _1476_dateCal {

    public static void main(String[] args) {

        // 입력

        // solve
        int Ena = 15;
        int Sna = 28;
        int Mna = 19;
        System.out.println("답 = " + solution(Ena, Sna, Mna));

    }

    ;


    // 15, 28, 19
    public static int solution(int Ena, int Sna, int Mna) {
        int answer = 0;

        int E = 15;
        int S = 28;
        int M = 19;

        if (Ena == Sna && Sna == Mna && Mna == Ena) {
            answer = Ena;

        } else {

            int T = 1;
            Boolean allFlag = false;
            Ena = (Ena == 15 ? 0 : Ena);
            Sna = (Sna == 28 ? 0 : Sna);
            Mna = (Mna == 19 ? 0 : Mna);

            while (allFlag == false) {
                int k = (T * E) + Ena;    // 일수
                System.out.printf("\n T = %d , k = %d ", T, k);

                if (k % S == Sna && allFlag == false) {
                    System.out.printf("\n s입성 k = %d", k);

                    if (k % M == Mna && allFlag == false) {
                        allFlag = true;
                    }
                    ;
                }
                ;

                T++;

                if (allFlag == true) {
                    answer = k;
                }
            }


        }

        return answer;

    }


}