package baekjoon.basic1.DataStructure_200;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Stack;

public class _9012_pair {


    /**
     * 한 쌍의 문제
     * add 로 추가
     */
    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        ArrayList<String> lineList = io.scanner_auto();

        // stack으로 구현
        System.out.println("" + pair(lineList));
    }

    private static ArrayList<String> pair(ArrayList<String> lineList) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < lineList.size(); i++) {
            String line = lineList.get(i);
            String[] split = line.split("");
            Stack st = new Stack();

            for (String s : split) {
                st.add(s);

                if (st.size() > 1) {
                    int size = st.size();
                    System.out.printf("size = %d, st.get(size(())())-2) = %s, st.get(size-1) = %s \n", size, st.get(size - 2), st.get(size - 1));
                    if (st.get(size - 2) == "(" && st.get(size - 1) == ")") {
                        st.pop();
                        st.pop();
                    };
                };
                // 라인

            };

            String result = "NO";
            if (st.size() > 0) {
                result = "YES";
            };
            resultList.add(result);
        }
        return resultList;
    }

}