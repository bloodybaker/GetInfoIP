package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        String country, region, city, zip, lat, lon, timezone, isp;
        String ln = "\n";
        ArrayList<String> data = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        System.out.println("Введите свой IP адрес:");
        String IP = scanner.nextLine();
        URL url =  new URL("http://ip-api.com/json/" + IP);
        URLConnection uc =  url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        JsonElement root = new JsonParser().parse(bufferedReader.readLine());
        bufferedReader.close();
        data.add(root.getAsJsonObject().get("isp").getAsString());
        data.add(root.getAsJsonObject().get("country").getAsString());
        data.add(root.getAsJsonObject().get("region").getAsString());
        data.add(root.getAsJsonObject().get("city").getAsString());
        data.add(root.getAsJsonObject().get("zip").getAsString());
        data.add(root.getAsJsonObject().get("lat").getAsString());
        data.add(root.getAsJsonObject().get("lon").getAsString());
        data.add(root.getAsJsonObject().get("timezone").getAsString());
        for (int i = 0; i < data.size(); i++){
            data.set(i,data.get(i) + ln);
        }
        StringBuffer resultString = new StringBuffer("IP: " + IP + ln);
        resultString
                .append("Провайдер: " + data.get(0))
                .append("Страна: " + data.get(1))
                .append("Область: " + data.get(2))
                .append("Город: " + data.get(3))
                .append("Индекс: " + data.get(4))
                .append("Часовой пояс: " + data.get(7))
                .append("Широта: " + data.get(5))
                .append("Долгота: " + data.get(6));
        System.out.println(resultString.toString());
    }
}
