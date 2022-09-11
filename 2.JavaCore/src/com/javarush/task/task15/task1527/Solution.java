package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String [] parameters = url.substring(url.indexOf("?") + 1).split("&");
        List<String> nameParameters = new ArrayList<String>();
        List<String> valueParameters = new ArrayList<String>();
        for (String parameter : parameters) {
            if (parameter.contains("=")) {
                if (parameter.substring(0, parameter.indexOf("=")).equals("obj")) {
                    nameParameters.add(parameter.substring(0, parameter.indexOf("=")));
                    valueParameters.add(parameter.substring(parameter.indexOf("=") + 1 ));
                } else {
                    nameParameters.add(parameter.substring(0, parameter.indexOf("=")));
                }
            } else {
                nameParameters.add(parameter);
            }
        }
        for (String nameParameter : nameParameters) {
            System.out.print(nameParameter + " ");
        }
        System.out.println("");
        for (String valueParameter : valueParameters) {
            try {
                alert(Double.parseDouble(valueParameter));
            } catch (Exception e) {
                alert(valueParameter);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
