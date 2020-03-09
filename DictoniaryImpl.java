package Dictoniary1;

import Dictoniary1.dictoniary.Dictoniary;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictoniaryImpl implements DictonaryInter {
    String link = "https://dictionary.yandex.net/api/v1/dicservice.json/";
    String api = "dict.1.1.20200307T142050Z.a3db35a32a13bf78.92e8be9e4ff0c043e14f925e75ed7c280f6c6ff7";
    private Gson gson = new Gson();
    private File file = new File("Dictoniary.txt");


    @Override
    public void allLanguage() {
        String allIPA = link + "getLangs?key=" + api;
        String s = DictoniaryReturn.Transilete(allIPA);
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> stringList = gson.fromJson(s, type);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i) + "\n");
        }
    }

    @Override
    public void translite() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Tilni kiriting ");
        String lang = sc.nextLine();
        System.out.println(" So'zni kiriting ");
        String word = sc.next();
        String isHave = IsHaveLang(lang, word);
        if (isHave.length() > 0) {
            System.out.println(isHave);
        } else {
            List<FileWord> fileWordList = DictoniaryReturn.fileWordList(file);
            if(fileWordList == null) {
                fileWordList = new ArrayList<>();
            }
            String allIPA = link + "lookup?key=" + api + "&lang=" + lang + "&text=" + word;
            String s = DictoniaryReturn.Transilete(allIPA);
            Dictoniary dictoniary = gson.fromJson(s, Dictoniary.class);
            String text = dictoniary.getDef().get(0).getTr().get(0).getText();
            System.out.println(text);
            Gson gson = new Gson();
            FileWord fileWord = new FileWord(word, text, lang);
            fileWordList.add(fileWord);
            String s2 = gson.toJson(fileWordList);
            DictoniaryReturn.WriteFile(file, s2);

        }
    }
            public  String IsHaveLang(String lang, String word) {
                List<FileWord> fileWordList = DictoniaryReturn.fileWordList(file);
                if(fileWordList == null) {
                    fileWordList = new ArrayList<>();
                    return "";
                }
                for (int i = 0; i < fileWordList.size(); i++) {
                    if(fileWordList.get(i).getLang().equals(lang) && fileWordList.get(i).getWord().equals(word))
                        return fileWordList.get(i).getTransilte();
                }
                return "";
            }

}