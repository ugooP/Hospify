package com.company;

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
        switch (entree){
            case "1":
                System.out.println("Aléatoire"); //Fonction lecture aléatoire
                afficherPlaylist();
                break;

            case "2":
                System.out.println("Playlists"); //Fonction Gestion playlists
                creerPlaylist();
                break;

            case "3":
                Main.mainMenu();
                rechercherChanson();
                break;

            case "4":
                Main.mainMenu();
                break;
            default:
                break;
        }
    }

    private void afficherPlaylist() {
    }

    private void rechercherChanson() {
    }

    private static void creerPlaylist() {
        ArrayList<ArrayList<String>> musiques = new ArrayList<>();
        ArrayList<String> musique1 = new ArrayList<String>();
        ArrayList<String> musique2 = new ArrayList<String>();
        ArrayList<String> musique3 = new ArrayList<String>();
        ArrayList<String> musique4 = new ArrayList<String>();

        musique1.add("Musqiue 1 titre");
        musique1.add("Musqiue 1 auteur");
        musique1.add("1:45");

        musique2.add("Musqiue 2 titre");
        musique2.add("Musqiue 2 auteur");
        musique2.add("2:45");

        musique3.add("Musqiue 3 titre");
        musique3.add("Musqiue 3 auteur");
        musique3.add("3:45");

        musique4.add("Musqiue 4 titre");
        musique4.add("Musqiue 4 auteur");
        musique4.add("4:45");

        musiques.add(musique1);
        musiques.add(musique2);
        musiques.add(musique3);
        musiques.add(musique4);
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
