package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vallee {
    public static void afficherDescription() {
        System.out.println();
        System.out.println("Vous êtes dans une vallée a coté d’un ruisseau. Un corps flotte là dans l’eau.");
        System.out.println("(N, O)");
    }

    public static void priseEntreeUtilisateur() throws Exception {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("n")) {
                Route.afficherDescription();
                Route.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("o")) {
                Colline.afficherDescription();
                Colline.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("q")) {
                Main.mainMenu();
            }
        }
    }
}
