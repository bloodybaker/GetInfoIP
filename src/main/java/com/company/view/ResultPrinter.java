package com.company.view;

public class ResultPrinter {
    private StringBuffer resultString;

    public ResultPrinter(StringBuffer resultString) {
        this.resultString = resultString;
    }

    public void print(){
        System.out.println(resultString.toString());
    }
}
