package Dictoniary1;

public class FileWord {
    private  String word;
    private String transilte;
    private String lang ;

    public FileWord(String word, String transilte, String lang) {
        this.word = word;
        this.transilte = transilte;
        this.lang = lang;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTransilte() {
        return transilte;
    }

    public void setTransilte(String transilte) {
        this.transilte = transilte;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "FileWord{" +
                "word='" + word + '\'' +
                ", transilte='" + transilte + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
