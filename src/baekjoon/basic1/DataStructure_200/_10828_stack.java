package baekjoon.basic1.DataStructure_200;

import util.IO.SystemIO;

import java.util.ArrayList;
import java.util.Stack;

public class _10828_stack {

    // define : https://coding-factory.tistory.com/601
    // LinkedList , ArrayList , Stack , Queue , Iterator : https://nofall.tistory.com/entry/java-10-LinkedList-ArrayList-Stack-Queue-Iterator [외우기 싫으니까 기록하기:티스토리]
    // _10828_stack vs tree search
    // https://velog.io/@j_jhwww/TIL%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0Data-Structure-%EC%8A%A4%ED%83%9D%ED%81%90%EA%B7%B8%EB%9E%98%ED%94%84%ED%8A%B8%EB%A6%AC
    // spec : https://st-lab.tistory.com/174
    public static void main(String[] args) {

        // 입력
        SystemIO io = new SystemIO();
        ArrayList<String> lineList = io.scanner_auto();

        stack(lineList);

    }

    private static void stack(ArrayList<String> lineList) {
        Stack s = new Stack();

        for (String line : lineList) {

            // push X: 정수 X를 스택에 넣는 연산이다.
            if (line.contains("push")) {
                s.push(line.split(" ")[1]);
            }

            // top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            if (line.contains("top")) {
                if (!s.empty()) {
                    System.out.println(s.peek());
                } else {
                    System.out.println("-1");
                }
                ;
            }
            ;

            // size: 스택에 들어있는 정수의 개수를 출력한다.
            if (line.contains("size")) {
                System.out.println(s.size());
            }

            // pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            if (line.contains("pop")) {
                if (!s.empty()) {
                    System.out.println(s.pop());
                } else {
                    System.out.println("-1");
                }
            }

            // empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
            if (line.contains("empty")) {
                int empty = 1;
                if (!s.empty()) {
                    empty = 0;
                }
                System.out.println(empty);
            }

        }
    }


}