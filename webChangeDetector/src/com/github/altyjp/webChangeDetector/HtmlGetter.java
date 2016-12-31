/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.altyjp.webChangeDetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author satouryou
 */
public class HtmlGetter {

    private static String targetURL;

    /**
     * コンストラクタ
     * 文字列として取得するURLを指定する。
     * @param target_url 
     */
    public HtmlGetter(String target_url) {
        this.targetURL = target_url;
    }

    public static String executeGet() {
        System.out.println("===== HTTP GET Start =====");

        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(targetURL);

            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (InputStreamReader isr = new InputStreamReader(connection.getInputStream(),
                            "SJIS");
                            BufferedReader reader = new BufferedReader(isr)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                                //System.out.println(line);
                                sb.append(line);
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===== HTTP GET :OK =====");
        return new String(sb);
    }
}
