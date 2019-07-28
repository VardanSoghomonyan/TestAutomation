package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileDataReader {

    public JSONArray fileDataReaderMethod(String path) {
        JSONParser jsonParse = new JSONParser();
        JSONArray jsonArray = null;
        try {
            Object obj = jsonParse.parse(new FileReader(path));
            jsonArray = (JSONArray) obj;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return jsonArray;
        }
    }

    public String[][] jsonArrayTo2DArray(JSONArray jsonArray){
        String[][] resultArray = new String[jsonArray.size()][2];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            resultArray[i][0] = (String) jsonObject.get("username");
            resultArray[i][1] = (String) jsonObject.get("password");
        }
        return resultArray;
    }

    public String[][] get2DArrayFromJsonFile(String path){
        JSONArray jsonArray = fileDataReaderMethod(path);
        return jsonArrayTo2DArray(jsonArray);
    }

}