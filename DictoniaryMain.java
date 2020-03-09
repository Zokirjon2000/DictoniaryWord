package Dictoniary1;

import java.util.Scanner;

public class DictoniaryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DictonaryInter dictonaryInter = new DictoniaryImpl();
        while (true){
            System.out.println(" 1 -> All language " +
                    " 2-> Transilite ");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    dictonaryInter.allLanguage();
                    break;
                case 2:
                    dictonaryInter.translite();
                    break;
                case 3:

                    break;
            }
        }
    }
}
