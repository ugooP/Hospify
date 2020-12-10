package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ColossalCase {

    public static void afficherMenu() throws FileNotFoundException {
        System.out.println("~~~~~~~~~~~~ Bienvenue dans Colossal Case ~~~~~~~~~~~ ");
        System.out.println();
        System.out.println("Le but de ce jeu est simple : ");
        System.out.println("Un petit paragraphe va décrire le lieu dans lequel vous vous trouvez.");
        System.out.println("Vous devrez alors renseigner la direction vers laquelle vous souhaitez vous diriger ");
        System.out.println("Vers le Nord -> N");
        System.out.println("Vers le Sud  -> S");
        System.out.println("Vers l'Est   -> E");
        System.out.println("Vers l'Ouest -> O");
        System.out.println();
        System.out.println("À tout moment, taper Q pour quitter le jeu");

        while (true) {
            System.out.print("Taper C pour commencer : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("c")) {
                Route.afficherDescription();
                Route.priseEntreeUtilisateur();
            }
            else if (entreeUtilisateur.toLowerCase().equals("q")) {
                Main.mainMenu();
            }
        }


    }

    private static void boucleDeJeu() {
    }
}

