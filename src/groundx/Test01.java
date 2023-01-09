package groundx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test01 {
    public static void main(String[] args) {

        String input = "\n" +
                "GreatSong.flac 1000b" +
                "\n" +
                "GreatSong.flac 1000b" +
                "\n" +
                "GreatSong.flac 1000b" +
                "\n" +
                "GreatSong.flac 1000b";

        Solution s = new Solution();
        int[][] diet = new int[10][3];
        System.out.println("diet[0,3] = " + diet[0][0]);
        System.out.println("diet.length  = " + diet.length);
        System.out.println("답 = " + s.solution(diet));
    }

    ;


    static class Solution {
        // 최종합 배열
        ArrayList<Integer> finalCaseSum = new ArrayList();

        public int solution(int[][] diet) {
            int answer = 0;

            sumDfs(0, 0, -1, 0, diet);
            System.out.println("finalCaseSum = " + finalCaseSum);

            return Collections.min(finalCaseSum);
        }


        // 움직인 거리 t , 현재 위치 (n행,m열), 현재까지 sum( diet[0,0]+...+diet[i,j] ), 식단
        public int sumDfs(int t, int n, int m, int caseSum, int[][] diet) {

//            // 반복조건
//            if( n + 1 >= diet.length ){
//                finalCaseSum.add( caseSum );
//            }

            // 이동 값
            int newN = n;
            int newM = m; // 열
            int newCaseSum = caseSum;

            // 열 이동
            if (m + t > 2) {
                newM = m + t - 3;
                newN = newN + 1;
                System.out.println(" t/ newN / newM / caseSum-> " + t + "/" + newN + "/" + newM + " /" + caseSum);
                if (newN + 1 >= diet.length) {
                    finalCaseSum.add(caseSum);
                    return 0;
                }
                newCaseSum += diet[newN][newM];
            } else {
                newM = m + t;
                //newN = newN + 1;
                if (t != 0) {
                    newCaseSum += diet[newN][newM];
                }

            }

            // 리턴 (한칸, 두칸)
            return sumDfs(1, newN, newM, newCaseSum, diet) + sumDfs(2, newN, newM, newCaseSum, diet);
        }

    }

}