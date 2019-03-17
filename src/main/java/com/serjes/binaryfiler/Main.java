package com.serjes.binaryfiler;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static final String fileName = "files/pgadmin.log";

    public static void main(String[] args) {
        Main main = new Main();
        main.printFileInHex();
    }

    public void printFileInHex() {
        byte[] content = null;
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (resourceAsStream != null) {
                content = new byte[resourceAsStream.available()];
                int read = resourceAsStream.read(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (content != null) {
            System.out.println(format(content));
        } else {
            System.out.println("there are NULL");
        }

    }

    private String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

}
