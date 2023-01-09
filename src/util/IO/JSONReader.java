package util.IO;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader {

    // 1안 ) json 파일 읽기
    //      - 파일 읽기
    //      - json 읽기
    // 가이드
    //      - object Json 가져오기
    //          - 외부 라이브러리 서칭
    //          - 라이브러리 연동 https://bp666.tistory.com/6
    //      - 파일


    // 2안 ) java로 json -> excel 추출
    // 가이드
    //      - JSON에서 CSV로 변환 API 설치 https://blog.conholdate.com/ko/2022/07/19/convert-json-to-csv-using-java/
    //      - Java를 사용하여 JSON을 CSV로 변환하는 방법

    public static void main(String[] args) throws IOException, ParseException {

        String path = "/Users/jane.kwon/Desktop/blockList.json";
        FileReader fileReader = new FileReader(path);

        JSONParser parser = new JSONParser();
        // Parser returns an object, we need an explicit cast to covert it into a JSONArray
        JSONArray array = (JSONArray) parser.parse(fileReader);

        System.out.println("시나리오, obj = ");
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            System.out.println(obj.get("name") + "," + obj.get("id"));

        }

        System.out.println("블록, items =  ");
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            JSONArray items = (JSONArray) obj.get("items");

            for (int j = 0; j < items.size(); j++) {
                JSONObject obj2 = (JSONObject) items.get(j);
                System.out.println(obj2.get("name") + "," + obj2.get("id"));
            }
        }


    }

    ;


}