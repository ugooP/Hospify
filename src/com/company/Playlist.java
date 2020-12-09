package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Playlist {

    public static void creerPlaylist() throws FileNotFoundException {
        Chansons.afficherChanson();
        System.out.println();
        System.out.println("Taper V pour valider la playlist");
        System.out.println("Taper M pour revenir au menu");

        while (true) {
            System.out.print("Entrer le numéro de la chanson à ajouter : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("v")) {
                System.out.println("Playlist créée !");
                Hospify.affichageMenu();
            }
            else if (entreeUtilisateur.toLowerCase().equals("m")) {
                Hospify.affichageMenu();
            }
            else {
                int musiqueIndex = Integer.parseInt(entreeUtilisateur);

                // if ...

            }

        }
    }

    public static void afficherPlaylist() {

    }
}
