package org.crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {

    static String basePath = "path/to/crawler_project/";
    public static void saveFiles(String html, String fileName, String dateTime) {

        String folderPath = basePath + dateTime + "/html";
        fileName = fileName + ".html";

        try {
            // フォルダが存在しない場合は作成
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // ファイルの絶対パスを作成
            String filePath = folderPath + File.separator + fileName;

            // ファイルを作成し、HTMLデータを書き込む
            FileWriter writer = new FileWriter(filePath);
            writer.write(html);
            writer.close();
            System.out.println("successfully save HTML: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ファイルの書き込みに失敗しました.");
        }
    }

    public static void makeDateFolder(String dateTime) {
        String folderPath = basePath + dateTime;
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdir();
        }
    }
}
