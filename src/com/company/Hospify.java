package com.company;

import java.util.Scanner;

public class Hospify {

    public static void accueil() {

        System.out.println("~~~~~~~~~~~~~~ Bienvenue sur Hospify ~~~~~~~~~~~~~~~ ");
        System.out.println();
        System.out.println("Que voulez-vous faire ?");
        System.out.println();
        System.out.println("1. Jouer une playlist");
        System.out.println("2. Créer une playlist");
        System.out.println("3. Supprimer une playlist");
        System.out.println("4. Rechercher une chanson");
        System.out.println("5. Revenir au menu");
        System.out.print("Numéro : ");

        Scanner scan = new Scanner(System.in);
        String entreeUtilisateur = scan.nextLine();

        if (entreeUtilisateur.equals("1")) {
            afficherPlaylist();
        }
        else if (entreeUtilisateur.equals("2")) {
            creerPlaylist();
        }
        else if (entreeUtilisateur.equals("3")) {
            supprimerPlaylist();
        }
        else if (entreeUtilisateur.equals("4")) {
            rechercherChanson();
        }
        else if (entreeUtilisateur.equals("5")) {
            // Retourner au menu
        }

    }

    private static void rechercherChanson() {
    }

    private static void supprimerPlaylist() {
    }

    private static void creerPlaylist() {

    }

    private static void afficherPlaylist() {
    }

}
