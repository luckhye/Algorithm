package baekjoon.basic1.DataStructure_200;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Stack;

public class _9093_wordReverse {

    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        ArrayList<String> lineList = io.scanner_auto();

        // stack으로 구현
        reverse(lineList);

        // bufferReader의 reverse로 구현
        bufferReader(lineList);

    }

    private static void bufferReader(ArrayList<String> lineList) {
        for (int i = 0; i < lineList.size(); i++) {
            String input = lineList.get(i);
            String[] split = input.split(" ");
            StringBuilder sb = new StringBuilder();

            for (String s : split) {
                StringBuilder reverse = new StringBuilder(s);
                sb.append(reverse.reverse());
                sb.append(' ');
            }

            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }

    ;

    // stack의 pop을 이용한다.
    public static void reverse(ArrayList<String> lineList) {
        //System.out.println("reverse" );

        for (int i = 0; i < lineList.size(); i++) {

            Stack s = new Stack();
            // 초기값.
            for (String str : lineList.get(i).split("")) {
                s.add(str);
            };

            // 출력
            String out = "";
            for (int j = 0; j < lineList.get(i).length(); j++) {
                // 끝에서 하나씩 출력
                out += s.pop();
            };

            System.out.println(out);
        }

    }


    // stream ver : https://codechacha.com/ko/java8-stream-collect/

}