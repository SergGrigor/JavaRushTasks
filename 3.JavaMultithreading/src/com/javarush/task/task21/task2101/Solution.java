package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte [] netAddress = new byte[4];
        for (int i = 0; i < netAddress.length; i++) {
            netAddress[i] = (byte) (mask[i] & ip[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        String[] binNumbers = new String[4];
        for (int i = 0; i < bytes.length; i++) {
            StringBuilder builder = new StringBuilder("00000000");
            int numb = bytes[i];
            if (numb < 0) {
                numb += 256;
            }
            String number = new BigInteger(String.valueOf(numb)).toString(2);
            for (int j = 0; j < number.length(); j++) {
                int index = (builder.length() - number.length()) + j;
                builder.setCharAt(index, number.charAt(j));
            }
            binNumbers[i] = builder.toString();
        }
        System.out.printf("%S %S %S %S", binNumbers[0], binNumbers[1], binNumbers[2], binNumbers[3]);
        System.out.println("");
    }
}
