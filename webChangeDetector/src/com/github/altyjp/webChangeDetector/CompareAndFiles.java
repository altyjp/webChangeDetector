/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.altyjp.webChangeDetector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author satouryou
 */
public class CompareAndFiles {

    private final String dataFilePath = "./Datafiles/data.txt";
    private File dataFile = null;

    /**
     * セーブデータの新規作成を試みる. 
     * 新規作成をした場合はtrueを返す。
     * しなかった場合はfalse 例外発生時はその例外をスローする。
     *
     * @return
     * @throws java.io.IOException
     */
    public boolean createSaveData() throws IOException {
        dataFile = new File(dataFilePath);
        return dataFile.createNewFile();
    }

    /**
     * セーブデータの更新を行う。 
     * 戻り値は特になし。
     * 例外発生時にはその例外をスローする
     *
     * @param str_data
     * @throws IOException
     */
    public void wirteSaveData(String str_data) throws IOException {

        FileWriter filewriter;
        filewriter = null;

        try {

            filewriter = new FileWriter(dataFile, false);
            filewriter.write(str_data);

        } catch (IOException ex) {
            Logger.getLogger(CompareAndFiles.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filewriter != null) {
                filewriter.close();
            }
        }
    }

    /***
     * セーブデータからデータを読み込む
     * 
     * @return
     * @throws IOException 
     */
    public String readSaveData() throws IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String string = reader.readLine();
            while (string != null) {
                builder.append(string);
                string = reader.readLine();
            }
        }

        return builder.toString();
    }

}
