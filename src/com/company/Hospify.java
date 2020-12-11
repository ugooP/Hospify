package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospify {

    private static Scanner scanner = new Scanner(System.in);
    private static String entree;

    public static ArrayList<Musiques> listeMusiques = new ArrayList<>();

    public static void affichageMenu() throws FileNotFoundException {

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Hospify ~~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println();
        System.out.println("1- Jouer une playlist");
        System.out.println("2- Créer une playlist");
        System.out.println("3- Supprimer une playlist");
        System.out.println("4- Rechercher une chanson");
        System.out.println("5- Ajouter une chanson");
        System.out.println("6- Supprimer une chanson");
        System.out.println("7- Retour au menu principal");
        System.out.println();
        System.out.println("Que désirez vous faire ? Veuillez faire votre choix");
        System.out.println("Vous pouvez quittez l'application en tapant la lettre Q ");

        entree = entreeUtilisateur();

        if (entree.equals("1")) {
            Playlist.jouerPlaylist();
        }
        else if (entree.equals("2")) {
            Playlist newPlaylist = new Playlist();
            newPlaylist.creerPlaylist();
        }
        else if (entree.equals("3")) {
            Playlist.supprimerPlaylist();
        }
        else if (entree.equals("4")) {
            rechercheChanson();
        }
        else if (entree.equals("5")) {
            Chansons.ajouterNouvelleChanson();
        }
        else if (entree.equals("6")) {

        }
        else if (entree.equals("7")) {
            Main.mainMenu();
        }
    }

    static String entreeUtilisateur(){

        entree = scanner.nextLine();

        while (!entree.equals("1") && !entree.equals("2") && !entree.equals("3") && !entree.equals("4") && !entree.equals("5") && !entree.equals("6") && !entree.equals("7") && !entree.toLowerCase().equals("q")){
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

    public static void rechercheChanson() throws FileNotFoundException {
        System.out.println();
        System.out.println("Voici la liste des musiques disponible sur notre plateforme:");
        System.out.println();
        Playlist.afficherListeMusiques();
        System.out.println();
        System.out.println("Souhaitez vous jouer l'une d'entre elle?");
        System.out.println("Oui / Non");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();

        if(scan.toLowerCase().equals("non")){
            affichageMenu();
        }
        else if(scan.toLowerCase().equals("oui")) {
            System.out.println("Quelle chanson jouer? (son numéro dans la liste)");
            int choix = checkEntree();
            LecteurMusique.jouerMusique(listeMusiques,choix);
            retourChanson();
        }
        else{
            System.out.println("Commande invalide");
            rechercheChanson();
        }
    }

    private static int checkEntree(){

        String scan = scanner.nextLine();
        int choix = 0;
        if (!scan.matches("^[0-9].*")) {
            System.out.println("Commande invalide, veuillez selectionner un chiffre.");
            checkEntree();
        }else {
            choix = Integer.parseInt(scan);
            if (choix >= listeMusiques.size()) {
                System.out.println("Musique introuvable, veuillez reéssayer.");
                checkEntree();
            }
        }
        return choix;
    }

    public static void retourChanson() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("m -> retourner au menu");
        System.out.println("l -> retourner à la liste des chansons");

        while (true) {
            String scan = scanner.nextLine();
            if (scan.toLowerCase().equals("m")) {
                affichageMenu();
            } else if (scan.toLowerCase().equals("l")) {
                rechercheChanson();
            } else {
                System.out.println("Commande invalide");
                retourChanson();
            }
        }
    }

    public static void creerTableauChansons() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("musiques2.txt")));
            scanner.useDelimiter("/");
            while (scanner.hasNext()){
                String titre = scanner.next();

                scanner.skip(scanner.delimiter());

                String artiste = scanner.next();

                scanner.skip(scanner.delimiter());

                String duree = scanner.next();
                scanner.skip(scanner.delimiter());

                Musiques nouvelleMusique = new Musiques(titre, artiste, duree);
                listeMusiques.add(nouvelleMusique);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
