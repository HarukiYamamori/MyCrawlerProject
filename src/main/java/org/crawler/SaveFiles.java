package org.crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {
    public static void saveFiles(String html, String fileName) {
        String folderPath = "/Users/engineer-mac-015/Desktop/JavaAcademy/crawlerProject/src/main/java/org/html";
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
}
