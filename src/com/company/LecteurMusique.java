package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LecteurMusique {

    public static void lecteurMusique(int indexPlaylist) {

        ArrayList list = Playlist.playlist;
        int numMusique = 0;

        jouerMusique(list, numMusique);


        while (true) {
            System.out.println("s -> musique suivante");
            System.out.println("p -> musique précédente");

            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            System.out.println(list.size());
            // Skip avant
            if (entreeUtilisateur.equals("s") && numMusique + 1 < list.size()) {
                numMusique++;
                jouerMusique(list, numMusique);
            }
            // Cas où l'utilisateur écoute la dernière chanson de la playlist
            else if (entreeUtilisateur.equals("s") && numMusique + 1 > list.size()) {
                System.out.println("Tu écoutes la dernière chanson de la playlist");
            }
            // Skip arrière
            else if (entreeUtilisateur.equals("p") && numMusique - 1 > 0) {
                numMusique--;
                jouerMusique(list, numMusique);
            }
            // Cas où l'utilisateur écoute la première chanson de la playlist
            else if (entreeUtilisateur.equals("p") && numMusique - 1 == 0 ) {
                System.out.println("Tu écoutes la première chanson de la playlist");
            }
            else {
                System.out.println("Commande invalide");
            }
        }

    }

    private static void jouerMusique(ArrayList playlist, int numMusique) {

        System.out.println();
        System.out.println("Actuellement en train de jouer :");
        System.out.println(playlist.get(numMusique));
        System.out.println();

    }


}
