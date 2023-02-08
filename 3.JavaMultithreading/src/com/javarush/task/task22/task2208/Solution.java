package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> strings = new LinkedHashMap<>();
        strings.put("name", "Ivanov");
        strings.put("country", "Russia");
        strings.put("city", "Kiev");
        strings.put("age", null);
        System.out.println(strings);
        System.out.println(getQuery(strings));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder("");
        for (String s: params.keySet()) {
            String values = params.get(s);
            if (values != null) {
                if (!builder.toString().equals("")) {
                    builder.append(" and ");
                }
                builder.append(s + " = " + "'" + values + "'" );
            }
        }
        return builder.toString();
    }
}
