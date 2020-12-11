/*package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Chansons {

    public static void afficherChanson(String[] chansons)  {
        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] != null) {
                System.out.println(i + ". " + chansons[i]);
            }
        }
    }

    public static void tabChansons(String[] chansons) throws FileNotFoundException {
        Scanner scanner = null;
        int indexChanson = 0;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("musiques.txt")));

            while (scanner.hasNextLine()) {
                String musique = scanner.nextLine();
                chansons[indexChanson] = musique;
                indexChanson++;
            }
            scanner.close();

        }catch (FileNotFoundException e){
            System.out.println("Fichier introuvable");
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static void contenuChansons() throws FileNotFoundException {
        tabChansons(Playlist.chansons);
        afficherChanson(Playlist.chansons);
    }
    public static void rechercheChanson() throws Exception {
        contenuChansons();
        System.out.println(" ");
        System.out.println("Souhaitez vous jouer l'une d'entre elle?");
        System.out.println("Oui / Non");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();

        if(scan.toLowerCase().equals("non")){
            Hospify.affichageMenu();
        }
        else if(scan.toLowerCase().equals("oui")) {
            System.out.println("Quelle chanson jouer? (son numéro dans la liste)");
            scan = scanner.nextLine();

            while (!scan.matches("^[0-9].*")) {
                System.out.println("Commande invalide, veuillez selectionner un chiffre dans la liste.");
                scan = scanner.nextLine();
            }
                int choix = Integer.parseInt(scan);
                //LecteurMusique.jouerMusique(Playlist.chansons, choix);
                retourChanson();
        }
        else{
            System.out.println("Commande invalide");
            rechercheChanson();
        }
    }

    public static void retourChanson() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("m -> retourner au menu");
        System.out.println("l -> retourner à la liste des chansons");

        while (true) {
            String scan = scanner.nextLine();
            if (scan.toLowerCase().equals("m")) {
                Hospify.affichageMenu();
            } else if (scan.toLowerCase().equals("l")) {
                rechercheChanson();
            } else {
                System.out.println("Commande invalide");
                retourChanson();
            }
        }
    }

    public static void ajouterNouvelleChanson() throws Exception {

        System.out.println();
        System.out.println("Ajout d'une nouvelle chanson");

}


 */