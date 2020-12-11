package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuildingEnBrique {
    public static void afficherDescription() {
        System.out.println();
        System.out.println("Vous êtes a l’intérieur d’un building en brique, un petit refuge pour les bêtes.\nUn homme git là au milieu d’une marre de sang");
        System.out.println("(O)");
    }

    public static void priseEntreeUtilisateur() throws Exception {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("o")) {
                Route.afficherDescription();
                Route.priseEntreeUtilisateur();
            } else if (entreeUtilisateur.toLowerCase().equals("q")) {
                Main.mainMenu();
            }
        }
    }
}
