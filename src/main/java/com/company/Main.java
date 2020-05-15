package com.company;

import com.company.controller.Connection;
import com.company.controller.Input;
import com.company.model.CreatingData;
import com.company.view.ResultPrinter;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Введите свой IP адрес:");
        Input input = new Input();
        Connection connection = new Connection(input.scan());
        connection.connect();
        CreatingData creatingData = new CreatingData(connection.getUc(),input.getIP());
        creatingData.createData();
        ResultPrinter resultPrinter = new ResultPrinter(creatingData.getResultString());
        resultPrinter.print();

    }
}
