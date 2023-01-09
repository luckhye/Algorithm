package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _2558_IO {

    public static void main(String[] args) throws IOException {

        scanner();

        bufferReader();

    }

    ;

    /**
     * Scanner: Space Enter를 모두 경계로 인식하기에 입력 받은 데이터 가공이 편리.
     * <p>
     * BufferedReader:  Enter만 경계로 인식, 받은 데이터 String으로 고정.
     * 입력 받은 데이터 가공 작업이 필요할 경우가 많음.
     * Scanner에 비해 다소 사용하기 불편하지만 많은 양의 데이터는 BufferedReader를 통해 입력받는 것이 효율 ↑
     */

    // 메모리: 14340KB, 시간: 108ms
    public static void scanner() {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("Scanner 종료");
    }

    // 메모리: 14340KB, 시간: 108ms
    public static void bufferReader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("BufferReader 종료");
    }


}