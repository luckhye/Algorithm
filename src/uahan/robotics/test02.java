package uahan.robotics;

import util.IO.SystemIO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 제출 폼
 * <p>
 * public class Main {
 * public static void main(String[] args) {
 * //solution(strArr);
 * }
 * }
 */


public class test02 {



    public static void main(String[] args) {

        // 입력
//        SystemIO io = new SystemIO();
//        ArrayList<String> lineList = io.scanner_auto();


        // solve
        String param1 =
                "my.song.mp3 11b\n"+
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov !e.mkv 10000b\n" ;

        System.out.println("param1 = " + param1);
        System.out.println("답 = " + solution(param1));
    }

    ;


    static HashMap typeMap = new HashMap();

    public static int solution(String param1) {

        int answer = 0;

        ArrayList mList = new ArrayList();
        mList.add("mp3");
        mList.add("aac");
        mList.add("flac");
        typeMap.put("음악", mList);

        String[] test = param1.split("\\s");
        System.out.println("test = "+ Arrays.toString( test )); //["my.song.mp3 11b, greatSong.flac 1000b, not3.txt 5b, video.mp4 200b, game.exe 100b, mov!e.mkv 10000b", end;, ]


        // ket data : my.song.mp3 11b
        // Key : my.song.mp3 11b -> my.song.mp3 -> mp3

        Map<String, List<String>> groupData = Arrays.stream(param1.split("\n"))
                                .collect(Collectors.groupingBy(line -> {
                                                            System.out.printf("line = %s \n", line);
                                                            String typeTxt = line.split(" ")[0];
//                                                            String[] typeArr = typeTxt.split(".");
//                                                            String type = typeArr[typeArr.length-1];

                                                            String groupKey = "";
                                                            if( typeTxt.endsWith("mp3") ){
                                                                System.out.printf("mp3 데이터 = %s \n", typeTxt  );
                                                                groupKey = "음악";
                                                            }else{
                                                                System.out.printf("기타 데이터 = %s \n", typeTxt);
                                                                groupKey = "기타";
                                                            }

                                                            return groupKey;
                                                    })
                                );


        System.out.println("groupData =  "+groupData);


        return answer;

    }


}