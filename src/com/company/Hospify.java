package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hospify {

    private static Scanner scanner = new Scanner(System.in);
    private static String entree;


    public void affichageMenu() throws FileNotFoundException {

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
        }
        else if (entree.equals("2")) {
            Playlist playlist = new Playlist();
            Playlist.creerPlaylist();
        }
        else if (entree.equals("3")) {
        }
        else if (entree.equals("4")) {
            Main.mainMenu();
        }
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
