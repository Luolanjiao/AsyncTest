package com.example.demo.service;

import org.springframework.stereotype.Component;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/***
 * this Class deal with files whitch in resources/testfile
 */
@Component
public class FileManager {
    public static String rootFolderPath;

    public FileManager(){
        rootFolderPath=this.getClass().getResource("/testfile").getPath();
    }

    public String[] getWordfromFile(String filePath, String[] separators) throws IOException {
        filePath = this.getClass().getResource(filePath).getPath();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(filePath);

        char[] buffer = new char[(int) file.length()];
        fileReader.read(buffer);

        String readStr = new String(buffer);
        String[] words = readStr.split(String.join("|", separators));
        fileReader.close();
        return words;
    }

    public void writeFileFromWords(String[] words, String filePath) throws IOException {
        File file = new File(this.getClass().getResource(filePath).getPath());
        String writeStr = String.join(" ", words);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(writeStr);
        fileWriter.close();
    }

    public void writeFileFromWords(String text, String filePath) throws IOException {
        File file = null;
        try {
            String path = this.getClass().getResource(filePath).getPath();
            file = new File(path);
        } catch (NullPointerException nullEx) {
            file = new File(rootFolderPath + filePath.replace("/testfile", ""));
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }

    public void appendFile(String text, String filePath) throws IOException {
        String path = null;
        try {
            path = this.getClass().getResource(filePath).getPath();
        } catch (NullPointerException nullEx) {
            path = rootFolderPath + filePath.replace("/testfile", "");
            File file = new File(path);
            file.createNewFile();
        }
        FileWriter file = new FileWriter(path,true);
        file.write(text);
        file.close();
    }

    /***
     * copy file names file to file names toFile
     * @param file
     * file'name is file's relative path
     * @param toFile
     * @throws IOException
     */
    public void copyFile(String file,String toFile) throws IOException {
        FileInputStream inputStream=new FileInputStream(rootFolderPath+file);
        byte[] buffer=new byte[1024];

        File toFileObj=new File(rootFolderPath+toFile);
       if(!toFileObj.exists()) {
           toFileObj.createNewFile();
       }
        FileOutputStream outputStream=new FileOutputStream(toFileObj);
       int len=0;
       while ((len= inputStream.read(buffer))!=-1){
           outputStream.write(buffer,0,len);
        }
        inputStream.close();
        outputStream.close();
    }

    /***
     * change file's name to newFileName
     * @param file
     * @param newFileName
     */
    public void changeName(String file,String newFileName){
        File fileObj=new File(rootFolderPath+ file);
        File toFileObj=new File(rootFolderPath+newFileName);
        fileObj.renameTo(toFileObj);
    }
}
