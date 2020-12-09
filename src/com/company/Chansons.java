package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Chansons {

    public static void afficherChanson() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.txt")));


        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            System.out.println(data);
        }
        scanner.close();
    }
    public static void nouvelleChanson(String titre, String auteur, String duree) {

    }

    public static void rechercherChanson() {
    }

    public static void lireChanson() {

    }
}
