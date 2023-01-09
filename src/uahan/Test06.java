package uahan;

import java.util.*;

public class Test06 {
    public static void main(String[] args) {

        String input =
                "GreatSong.flac 1000b" +
                        "\n" +
                        "greatSong.flac 1000b" +
                        "\n" +
                        "not3.txt 5b" +
                        "\n" +
                        "video.mp4 200b" +
                        "\n" +
                        "game.exe 100b" +
                        "\n" +
                        "mov!e.mkv 10000b";

        Solution s = new Solution();
        System.out.println("답 = " + s.Solution(input));
    }

    ;


    static class Solution {
        public String Solution(String s) {

            // 자료구조 샛팅.
//            Map<String, ArrayList> fileMap= {
//                    "MS" : ["mp3","aac","flac"] ,
//                    "IM" : ["jpg","bmp","gif"] ,
//                    "MV" : ["jpg", "bmp", "gif"] ,
//            }


            List<String> MSList = converList("mp3,aac,flac");
            List<String> IMList = converList("jpg,bmp,gif");
            List<String> MVList = converList("mp4,avi,mkv");

            Map<String, List> fileMap = new HashMap<>();
            fileMap.put("MS", MSList);
            fileMap.put("IM", IMList);
            fileMap.put("MV", MVList);

            Map<String, Integer> sizeMap = new HashMap<>();
            sizeMap.put("MS", 0);
            sizeMap.put("IM", 0);
            sizeMap.put("MV", 0);
            sizeMap.put("ET", 0);


            // 확장자 찾기
            String[] lineArr = s.split("\n");
            System.out.println("배열 = " + Arrays.toString(lineArr)); // 라인 요소 생성.

            for (String item : lineArr) {
                String ext = "";
                int size = 0;

                System.out.println("item = " + item);

                // 확장자 추출.
//                System.out.println("시작 "+ item.substring(item.lastIndexOf(".")) );
//                System.out.println("끝 "+ item.substring(item.indexOf(" ")) );
                ext = item.substring(item.lastIndexOf(".") + 1, item.indexOf(" "));
                System.out.println("확장자 추출 :" + ext);

                // 바이트 추출.
                size = Integer.parseInt(item.substring(item.lastIndexOf(" ") + 1, item.indexOf("b")));
                System.out.println("바이 추출 :" + size);

                for (String key : fileMap.keySet()) {
                    List exelist = fileMap.get(key);
                    System.out.println(String.format("키 : %s, 값 : %s", key, fileMap.get(key)));
                    if (exelist.contains(ext)) {
                        sizeMap.put(key, sizeMap.get(key) + size);
                    } else {
                        String tempkey = "ET";
                        sizeMap.put(tempkey, sizeMap.get(tempkey) + size);
                    }

                }

            }
            ;


            System.out.println("sizeMap = " + sizeMap.toString());


            String result = "";
            for (String key : sizeMap.keySet()) {
                System.out.println(String.format("키 : %s, 값 : %sb", key, sizeMap.get(key)));
                String cateNm = "";
                if (key.equals("MS")) {
                    cateNm = "music";
                } else if (key.equals("IM")) {
                    cateNm = "images";
                } else if (key.equals("MV")) {
                    cateNm = "movies";
                } else {
                    cateNm = "other";
                }
                result += cateNm + " " + sizeMap.get(key) + "b\n";
            }
            return result;

        }

        ;


        public List converList(String str) {
            // "mp3,aac,flac"
            return Arrays.asList(str.split(","));
        }


    }


}