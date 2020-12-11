package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String entree;


    public static void main(String[] args) throws Exception {

        mainMenu();

    }

    public static void mainMenu() throws Exception {
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~ Bienvenue sur Laspit'app ~~~~~~~~~~~~~ ");
        System.out.println(" ");
        System.out.println("Bonjour, Laspit'app vous propose actuellement 2 fonctionnalités:");     //A changer quand on aura les classes
        System.out.println(" ");
        System.out.println("1- Hospify : Un lecteur de musiques.");                                 //pour afficher une liste de fonctionnalités
        System.out.println("2- Colossal Save : Un super jeu d'aventure!");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Que désirez vous faire? Veuillez faire votre choix. ");
        System.out.println("Vous pouvez quittez l'application en tapant la lettre Q ");

        entree = entreeUtilisateur();

        //Lance le sous-menu de l'application de Musiques
        if(entree.equals("1")) {
            Hospify hospify = new Hospify();
            Hospify.creerTableauChansons();
            hospify.affichageMenu();
        }
        //Lance le sous-menu du jeu
        else if (entree.equals("2")) {
            System.out.println();
            ColossalCase.afficherMenu();
        }
    }


    //Scanner classique
    static String entreeUtilisateur(){

        entree = scanner.nextLine();

        while (!entree.equals("1") && !entree.equals("2") && !entree.toLowerCase().equals("q")){
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
