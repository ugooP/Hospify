package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private static int playlistCount = 0;

    public static void creerPlaylist() throws FileNotFoundException {

        ArrayList<String> playlist = new ArrayList<>();

        System.out.println(" ");
        System.out.println("Voici la liste des chansons disponibles:");
        System.out.println(" ");
        String[] chansons = new String[20];
        Chansons.tabChansons(chansons);
        Chansons.afficherChanson(chansons);
        System.out.println();
        System.out.println("Taper V pour valider la playlist");
        System.out.println("Taper M pour revenir au menu");

        while (true) {
            System.out.print("Entrer le numéro de la chanson à ajouter : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("v")) {
                System.out.println("Playlist créée !");
                //playlistCount++;
                //FileWriter("playlist"+playlistCount)
                Hospify.affichageMenu();
            }
            else if (entreeUtilisateur.toLowerCase().equals("m")) {
                Hospify.affichageMenu();
            }
            else {
                int musiqueIndex = Integer.parseInt(entreeUtilisateur);

                playlist.add(chansons[musiqueIndex]);
                System.out.println(playlist);

            }

        }
    }

    public static void afficherPlaylist() {

    }
}
