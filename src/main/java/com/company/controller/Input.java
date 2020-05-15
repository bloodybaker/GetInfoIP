package com.company.controller;

import java.util.Scanner;

public class Input {
    private String IP;
    private Scanner scanner = new Scanner(System.in);
    public String scan(){
        Scanner scanner = new Scanner(System.in);
        IP = scanner.nextLine();
        return IP;
    }

    public String getIP() {
        return IP;
    }
}
