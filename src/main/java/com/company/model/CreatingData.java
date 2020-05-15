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
    public CreatingData(URLConnection uc, String IP) {
        this.uc = uc;
        this.IP = IP;
    }
    public void createData() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        JsonElement jsonString = new JsonParser().parse(bufferedReader.readLine());
        bufferedReader.close();
        data.add(jsonString.getAsJsonObject().get("isp").getAsString());
        data.add(jsonString.getAsJsonObject().get("country").getAsString());
        data.add(jsonString.getAsJsonObject().get("region").getAsString());
        data.add(jsonString.getAsJsonObject().get("city").getAsString());
        data.add(jsonString.getAsJsonObject().get("zip").getAsString());
        data.add(jsonString.getAsJsonObject().get("lat").getAsString());
        data.add(jsonString.getAsJsonObject().get("lon").getAsString());
        data.add(jsonString.getAsJsonObject().get("timezone").getAsString());
        for (int i = 0; i < data.size(); i++){
            data.set(i,data.get(i) + ln);
        }
        resultString = new StringBuffer("IP: " + IP + ln);
        resultString
                .append("Провайдер: " + data.get(0))
                .append("Страна: " + data.get(1))
                .append("Область: " + data.get(2))
                .append("Город: " + data.get(3))
                .append("Индекс: " + data.get(4))
                .append("Часовой пояс: " + data.get(7))
                .append("Широта: " + data.get(5))
                .append("Долгота: " + data.get(6));
    }

    public StringBuffer getResultString() {
        return resultString;
    }
}
