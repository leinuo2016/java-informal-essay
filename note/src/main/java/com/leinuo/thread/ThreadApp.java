package com.leinuo.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Create by leinuo on 2020/8/5
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ThreadApp {

    public static void main(String[] args) {
        new Thread(()-> writeToFile("11111\n")).start();
        new Thread(()-> writeToFile("22222\n")).start();
    }

    private static void writeToFile(String s) {
        File file = new File("/home/leinuo/gitHub/java-informal-essay/note/src/main/resources/text.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            for(int i=0;i<10;i++){
                writeByFileOutputStream(file.getAbsolutePath(),s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 用FileOutputStream向文件写入内容
     *
     * @throws IOException
     */
    public static void writeByFileOutputStream(String _sDestFile,
                                               String _sContent) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(_sDestFile,true);
            fos.write(_sContent.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
                fos = null;
            }
        }
    }
}
