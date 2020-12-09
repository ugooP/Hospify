package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Route {
    public static void afficherDescription() {
        System.out.println();
        System.out.println("Vous êtes au bout de la route devant un petit immeuble en brique.\nUn petit ruisseau coule à côté du building en bas d’une rigole");
        System.out.println("(N, S, E, O)");
    }

    static void priseEntreeUtilisateur() throws FileNotFoundException {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("n")) {
                Foret.afficherDescription();
                Foret.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("s")) {
                Vallee.afficherDescription();
                Vallee.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("e")) {
                BuildingEnBrique.afficherDescription();
                BuildingEnBrique.priseEntreeUtilisateur();
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
