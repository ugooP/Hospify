package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hospify {

    private static Scanner scanner = new Scanner(System.in);
    private static String entree;


    public void affichageMenu() {

        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Hospify ~~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println(" ");
        System.out.println("1- Jouer une playlist");
        System.out.println("2- Créer une playlist");
        System.out.println("3- Rechercher une chanson");
        System.out.println("4- Retour au menu principal");
        System.out.println(" ");
        System.out.println("Que désirez vous faire ? Veuillez faire votre choix");
        System.out.println("Vous pouvez quittez l'application en tapant la lettre Q ");

        entree = entreeUtilisateur();

        if (entree.equals("1")) {
            afficherPlaylist();
        }
        else if (entree.equals("2")) {
            creerPlaylist();
        }
        else if (entree.equals("3")) {
            rechercherChanson();
        }
        else if (entree.equals("4")) {
            Main.mainMenu();
        }
    }

    private void afficherPlaylist() {
    }

    private void rechercherChanson() {
    }

    private static void creerPlaylist() {
        System.out.print("Entrer le nom de la playlist : ");
        Scanner scan = new Scanner(System.in);
        String nomPlaylist = scan.nextLine();

        ArrayList<ArrayList<HashMap<String, String>>> listePlaylist = new ArrayList<>();
        ArrayList<HashMap<String, String>> playlist1 = new ArrayList<>();
        HashMap<String, String> musique1 = new HashMap<String, String>();


        musique1.put("titre", "titre chanson 1");
        musique1.put("auteur", "auteur chanson 1");
        musique1.put("duree", "1:45");

        // musique2.put(...)
        // ...

        playlist1.add(musique1);
        listePlaylist.add(playlist1);

    }


    static String entreeUtilisateur(){

        entree = scanner.nextLine();

        while (!entree.equals("1") && !entree.equals("2") && !entree.equals("3") && !entree.equals("4") && !entree.toLowerCase().equals("q")){
            System.out.println(" ");
            System.out.println("Veuillez faire un choix parmi les fonctionnalités proposées.");
            entreeUtilisateur();
        }
        if (entree.toLowerCase().equals("q")){
            System.out.println(" ");
            System.out.println("Au revoir, à bientôt");
            System.exit(0);
        }
        return entree;
    }

}
