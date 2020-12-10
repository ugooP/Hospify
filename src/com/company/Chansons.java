package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Chansons {

    public static void afficherChanson() throws FileNotFoundException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("test.txt")));

            while (scanner.hasNextLine()) {
                String musique = scanner.nextLine();
                System.out.println(musique);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("Fichier introuvable");
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static void nouvelleChanson(String titre, String auteur, String duree) {

    }

    public static void rechercherChanson() {
    }

    public static void lireChanson() {

    }
}
