package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Chansons {

    public static void afficherChanson() throws FileNotFoundException {
        int indexChanson = 0;
        Scanner file = new Scanner(new BufferedReader(new FileReader("test.txt")));

        while (file.hasNextLine()) {
            String ligne = file.nextLine();
            System.out.println(indexChanson + ". " + ligne);
            indexChanson++;
        }
        file.close();
    }
    public static void nouvelleChanson(String titre, String auteur, String duree) {

    }

    public static void rechercherChanson() {
    }

    public static void lireChanson() {

    }
}
