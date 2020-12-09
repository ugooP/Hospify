package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Playlist {

    public static void creerPlaylist() throws FileNotFoundException {
        Chansons.afficherChanson();
        System.out.println();

        while (true) {
            System.out.print("Entrer le numéro de la chanson à ajouter : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();
        }
    }

    public static void afficherPlaylist() {

    }
}
