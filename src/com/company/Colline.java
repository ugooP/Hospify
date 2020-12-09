package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Colline {
    public static void afficherDescription() {
        System.out.println();
        System.out.println("Vous êtes tout en haut d’une colline qui surplombe la ville, au loin vous voyez une ombre\nse déplacer a grande vitesse avec un grand couteau. ");
        System.out.println("(N)");
    }

    public static void priseEntreeUtilisateur() throws FileNotFoundException {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("n")) {
                Foret.afficherDescription();
                Foret.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("q")) {
                Main.mainMenu();
            }
        }
    }
}
