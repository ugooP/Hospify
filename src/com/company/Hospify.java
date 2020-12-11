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
            System.out.println(" ");
            System.out.println("Voici la liste des musiques disponible sur notre plateforme :");
            System.out.println(" ");
            Chansons.rechercheChanson();
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
