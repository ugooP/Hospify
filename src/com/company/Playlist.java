package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Playlist {


    public static void creerPlaylist() throws FileNotFoundException {
        Chansons chansons = new Chansons();
        System.out.println(" ");
        System.out.println("Voici la liste des chansons disponibles:");
        System.out.println(" ");
        Chansons.afficherChanson();

        while (true) {
            System.out.print("Entrer le numéro de la chanson : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();
        }
    }

    public static void afficherPlaylist() {

    }
}
