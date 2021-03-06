package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Foret {
    public static void afficherDescription() { //Consigne sur les choix de l'utilisateur
        System.out.println();
        System.out.println("Vous êtes dans la foret noire. Vous entendez des hurlements stridents.");
        System.out.println("(S)");
    }

    public static void priseEntreeUtilisateur() throws Exception {  //Choix de parcours de l'utilisateur

        while (true) {
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("s")) {
                Route.afficherDescription();
                Route.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("q")) {
                Main.mainMenu();
            }
        }
    }
}
