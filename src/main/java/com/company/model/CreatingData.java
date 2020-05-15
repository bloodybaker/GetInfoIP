package com.company.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;

public class CreatingData {
    private URLConnection uc;
    private String ln = "\n";
    private String IP;
    private ArrayList<String> data = new ArrayList<String>();
    private StringBuffer resultString;
    private static String []OBJECTS = {"isp", "country","region","city","zip","lat","lon","timezone"};
    private static String []PARAMETERS = {"Провайдер: ", "Страна: ", "Область: ", "Город: ", "Индекс: ", "Часовой пояс: ", "Широта: ", "Долгота: "};
    public CreatingData(URLConnection uc, String IP) {
        this.uc = uc;
        this.IP = IP;
    }
    public void createData() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        JsonElement jsonString = new JsonParser().parse(bufferedReader.readLine());
        bufferedReader.close();
        for (int i = 0; i < OBJECTS.length; i++) {
            data.add(jsonString.getAsJsonObject().get(OBJECTS[i]).getAsString());
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + ln);
        }
        resultString = new StringBuffer("IP: " + IP + ln);
        for (int i = 0; i < PARAMETERS.length; i++) {
            resultString.append(PARAMETERS[i] + data.get(i));
        }
    }

    public StringBuffer getResultString() {
        return resultString;
    }
}
