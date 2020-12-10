package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Chansons {

    public static void afficherChanson(String[] chansons)  {


        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] != null) {
                System.out.println(i + ". " + chansons[i]);
            }
        }
    }

    public static void tabChansons(String[] chansons) throws FileNotFoundException {
        Scanner scanner = null;
        int indexChanson = 0;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("musiques.txt")));

            while (scanner.hasNextLine()) {
                String musique = scanner.nextLine();
                chansons[indexChanson] = musique;
                indexChanson++;
            }
            scanner.close();

        }catch (FileNotFoundException e){
            System.out.println("Fichier introuvable");
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static void lireChanson() {

    }
}
