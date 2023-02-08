package lt.code.academy;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NullPointerException, NumberFormatException, IOException {

        AllInOne all = new AllInOne();
        Scanner sc = new Scanner(System.in);

        String line;

        do {
            menu();
            line = sc.nextLine();
            all.userSelection(sc, line);
        } while (!line.equals("3"));
    }
    public static void menu() {
        System.out.println("""
                [1]. Ivesti vartotoja
                [2]. Patikrinti ar yra toks vartotojas
                [3]. Atspausdinti visus vartotojus
                [3]. Iseiti
                """);
    }
}