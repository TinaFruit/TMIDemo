package org.tmi.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtils {
    public static JSONObject getJsonObject(HttpServletRequest req){
        String line;
        StringBuffer jb = new StringBuffer();
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
            JSONObject jsonObject =  new JSONObject(jb.toString());
            return   jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
