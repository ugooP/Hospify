package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LecteurMusique {

    public static void lecteurMusique(ArrayList<ArrayList<String>> musiques) {

        int numMusique = 1;

        jouerMusique(musiques, numMusique);

        System.out.println("s -> musique suivante");
        System.out.println("p -> musique précédente");

        while (true) {
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            // Skip avant
            if (entreeUtilisateur.equals("s") && numMusique + 1 <= musiques.size()) {
                numMusique++;
                jouerMusique(musiques, numMusique);
            }
            // Cas où l'utilisateur écoute la première chanson de la playlist
            else if (entreeUtilisateur.equals("s") && numMusique + 1 > musiques.size()) {
                System.out.println("Tu écoutes la dernière chanson de la playlist");
            }
            // Skip arrière
            else if (entreeUtilisateur.equals("p") && numMusique - 1 > 0) {
                numMusique--;
                jouerMusique(musiques, numMusique);
            }
            // Cas où l'utilisateur écoute la dernière chanson de la playlist
            else if (entreeUtilisateur.equals("p") && numMusique - 1 == 0 ) {
                System.out.println("Tu écoutes la première chanson de la playlist");
            }
            else {
                System.out.println("Commande invalide");
            }
        }

    }

    private static void jouerMusique(ArrayList<ArrayList<String>> musiques, int numMusique) {

        System.out.println();
        System.out.println("Actuellement en train de jouer :");
        System.out.println(musiques.get(numMusique - 1).get(0) + " - " + musiques.get(numMusique - 1).get(1) + " (" + musiques.get(numMusique - 1).get(2) + ")");
        System.out.println();

    }


}
