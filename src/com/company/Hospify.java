package com.company;

import java.util.Scanner;

public class Hospify {

    private static Scanner scanner = new Scanner(System.in);
    private static String entree;


    public void affichageMenu() {

        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~ Hospify ~~~~~~~~~~~~~ ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1- Lecture aléatoire"); //Lecture des chansons du fichier .txt de façon aléatoire
        System.out.println("2- Mes playlist");      //Gestion de playlist
        System.out.println("3- Retour au menu principal. ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Que désirez vous faire? Veuillez faire votre choix. ");
        System.out.println("Vous pouvez quittez l'application en tapant la lettre Q ");

        entree = entreeUtilisateur();
    }

    static String entreeUtilisateur(){

        entree = scanner.nextLine();

        while (!entree.equals("1") && !entree.equals("2") && !entree.equals("3") && !entree.toLowerCase().equals("q")){
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
