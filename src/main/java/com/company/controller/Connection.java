package com.company.controller;

import java.net.URL;
import java.net.URLConnection;

public class Connection {
    private URLConnection uc;
    private String IP;
    public void connect() throws Exception{
        URL url =  new URL("http://ip-api.com/json/" + IP);
        uc =  url.openConnection();
    }

    public Connection(String IP) {
        this.IP = IP;
    }

    public URLConnection getUc() {
        return uc;
    }
}
