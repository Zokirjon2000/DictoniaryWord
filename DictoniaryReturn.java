package Dictoniary1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DictoniaryReturn {



    public  static String Transilete (String string){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(string);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) != null){
                stringBuilder.append(row);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

return stringBuilder.toString();
    }
    public static void WriteFile(File file , String lang){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(lang.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  List<FileWord> fileWordList(File file){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader  inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) != null){
                stringBuilder.append(row);
            }
            bufferedReader.close();
            fileInputStream.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<FileWord>>() {
        }.getType();
        return gson.fromJson(stringBuilder.toString(),type);

    }


}
