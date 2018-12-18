package com.example.demo;

import com.example.demo.service.FileManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//@SpringBootApplication
public class FileIOTestApplication {
    public static void main(String[] args) throws IOException {
        FileManager fileManager=new FileManager();
        String[] a= fileManager.getWordfromFile("/testfile/a.txt",new String[]{"\\s+"});
        String[] b=fileManager.getWordfromFile("/testfile/b.txt",new String[]{"\\s+"});
        StringBuffer total=new StringBuffer();
        int i=0;
        for (String word:a
        ) {
            total.append(word);
            total.append("");
            if(i<b.length) {
                total.append(b[i]);
            }
            i++;
        }
      //  fileManager.writeFileFromWords(new String(total) ,"/testfile/c.txt");
      //  fileManager.appendFile(total.toString() ,"/testfile/c.txt");
      //  fileManager.copyFile("/a.txt","/d.txt");
        fileManager.changeName("/d.txt","/drename.txt");
    }
}
