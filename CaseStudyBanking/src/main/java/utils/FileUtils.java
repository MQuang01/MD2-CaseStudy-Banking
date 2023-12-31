package utils;


import model.IParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> void writeFile(List<T> datas, String fileName) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (T e : datas) {
                bufferedWriter.write(e + "\n");
            }
        } catch (Exception e) {

        }finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean checkFileExits(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static <T> List<T> readFile(String fileName, Class<T> clazz){
        List<T> datas = new ArrayList<>();
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // PRODUCT line: 1,Iphone 11, Iphone 11 64GB RED,1000000,1,APPLE,2023-10-09
//                T obj = new T();                      // không thể tạo đối tượng từ gerneric T
                Object obj = clazz.newInstance();           // User u = new User(), Product p = new Product();
                IParser iParser = (IParser) obj;
                iParser.parse(line);

                datas.add((T) obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
