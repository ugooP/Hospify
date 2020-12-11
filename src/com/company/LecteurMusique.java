package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LecteurMusique {

    public static void lecturePlaylist(ArrayList<Musiques> playlist) throws FileNotFoundException {

        int numMusique = (int) (Math.random() * ((playlist.size()) + 1));
        jouerMusique(playlist, numMusique);


        while (true) {
            System.out.println("s -> musique suivante");
            System.out.println("p -> musique précédente");

            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            // Skip avant
            if (entreeUtilisateur.equals("s") && playlist.size() > numMusique + 1) {
                numMusique++;
                jouerMusique(playlist, numMusique);
            }
            // Cas où l'utilisateur écoute la dernière chanson de la playlist
            else if (entreeUtilisateur.equals("s") && playlist.size() == numMusique + 1) {
                System.out.println();
                System.out.println("Tu écoutes la dernière chanson de la playlist");
                System.out.println();
            }
            // Skip arrière
            else if (entreeUtilisateur.equals("p") && numMusique - 1 >= 0) {
                numMusique--;
                jouerMusique(playlist, numMusique);
            }
            // Cas où l'utilisateur écoute la première chanson de la playlist
            else if (entreeUtilisateur.equals("p") && numMusique - 1 < 0 ) {
                System.out.println();
                System.out.println("Tu écoutes la première chanson de la playlist");
                System.out.println();
            }
            else if (entreeUtilisateur.equals("m")) {
                Hospify.affichageMenu();
            }
            else {
                System.out.println("Commande invalide");
            }
        }

    }

    public static void jouerMusique(ArrayList<Musiques> playlist, int numMusique) {

        if (playlist.get(numMusique) != null) {
            System.out.println();
            System.out.println("Actuellement en train de jouer :");
            System.out.println(playlist.get(numMusique).getTitre() + " - " + playlist.get(numMusique).getArtiste() + " (" + playlist.get(numMusique).getDuree() + ")");
            System.out.println();
        }else {
            System.out.println("La musique demandée n'existe pas");
        }
    }

}
