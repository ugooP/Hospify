package com.company;

import org.w3c.dom.html.HTMLOptGroupElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Playlist {

    private static String[] chansons = new String[20];
    private static int playlistCount = 0;
    public static ArrayList<String> playlist = new ArrayList<>();

    public static void creerPlaylist() throws FileNotFoundException {



        System.out.println(" ");
        System.out.println("Voici la liste des chansons disponibles:");
        System.out.println(" ");
        Chansons.tabChansons(chansons);
        Chansons.afficherChanson(chansons);
        System.out.println();
        System.out.println("Taper V pour valider la playlist");
        System.out.println("Taper M pour revenir au menu");

        while (true) {
            System.out.print("Entrer le numéro de la chanson à ajouter : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("v")) {
                    try {
                        playlistCount++;
                        FileWriter playlistWriter = new FileWriter("playlist" + playlistCount+ ".txt");
                        playlistWriter.write(String.valueOf(playlist));
                        playlistWriter.close();
                        System.out.println("Playlist créée !");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Hospify.affichageMenu();
            }
            else if (entreeUtilisateur.toLowerCase().equals("m")) {
                Hospify.affichageMenu();
            }
            else {
                int musiqueIndex = Integer.parseInt(entreeUtilisateur);

                if (musiqueIndex < 0 || musiqueIndex >= chansons.length) {
                    System.out.println("Numéro invalide");
                } else {
                    playlist.add(chansons[musiqueIndex]);
                    System.out.println(playlist);
                }

            }

        }
    }

    public static void jouerPlaylist() throws FileNotFoundException {
        afficherListePlaylist();
        System.out.println("Selectionnez la playlist à jouer:");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();

        if(choix.toLowerCase().equals("m")){
            Hospify.affichageMenu();
        }else{
            int playlistIndex = Integer.parseInt(choix);
            playlistIndex++;
            if(playlistIndex > playlistCount+1 || playlistIndex<0){
                System.out.println("Commande invalide");
            }
            else{
                LecteurMusique.lecteurMusique(playlistIndex);
            }
        }
    }

    private static void afficherListePlaylist() {
        System.out.println();
        System.out.println("Liste des playlist : ");

        for (int i = 1; i < chansons.length; i++) {

            Scanner scan = null;
            try {
                scan = new Scanner(new BufferedReader(new FileReader("playlist"+i+".txt")));
            } catch (FileNotFoundException e) {
                break;
            }
            System.out.println("Playlist numéro "+ i +": "+ scan.nextLine());
        }
    }
}
