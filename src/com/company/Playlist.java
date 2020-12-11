package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Playlist {

    public static String[] chansons = new String[200];
    private static int playlistCount = 0;
    public static ArrayList<ArrayList> listePlaylist = new ArrayList<>();

    public static void creerPlaylist() throws FileNotFoundException {
        int chansonCounter = 0;
        ArrayList<Musiques> nouvellePlaylist = new ArrayList<>();
        System.out.println();
        System.out.println("Voici la liste des chansons disponibles:");
        System.out.println();
        afficherListeMusiques();
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
                        FileWriter playlistWriter = new FileWriter("playlist" + playlistCount + ".txt");
                        playlistWriter.write(String.valueOf(nouvellePlaylist));
                        playlistWriter.close();
                        listePlaylist.add(nouvellePlaylist);
                        System.out.println();
                        System.out.println("Playlist créée !");
                        System.out.println();
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

                if (musiqueIndex < 0 || musiqueIndex >= Hospify.listeMusiques.size()) {
                    System.out.println("Numéro invalide");
                } else {
                    nouvellePlaylist.add(Hospify.listeMusiques.get(musiqueIndex));
                    afficherPlaylist(nouvellePlaylist);
                    chansonCounter++;
                }
            }
        }
    }

    public static void afficherListeMusiques() {
        ArrayList<Musiques> musiques = Hospify.listeMusiques;
        for (int i = 0; i < musiques.size(); i++) {
            System.out.println(i + ". " + musiques.get(i).getTitre() + " - " + musiques.get(i).getArtiste() + " (" + musiques.get(i).getDuree() + ")");
        }
    }

    private static void afficherPlaylist(ArrayList<Musiques> nouvellePlaylist) {
        System.out.println();
        for (int i = 0; i < nouvellePlaylist.size(); i++) {
            System.out.println(nouvellePlaylist.get(i).getTitre() + " - " + nouvellePlaylist.get(i).getArtiste() + " (" + nouvellePlaylist.get(i).getDuree() + ")");
        }
        System.out.println();
    }

    public static void jouerPlaylist() throws FileNotFoundException {
        afficherListePlaylist();
        System.out.println();

        if (listePlaylist.size() == 0) {
            System.out.println("Aucune playlist trouvée...");
            Hospify.affichageMenu();
        } else {
            while (true) {
                System.out.print("Selectionnez la playlist à jouer : ");
                Scanner scanner = new Scanner(System.in);
                String choix = scanner.nextLine();

                if (choix.toLowerCase().equals("m")) {
                    Hospify.affichageMenu();
                } else {
                    int playlistIndex = Integer.parseInt(choix);

                    if (playlistIndex > listePlaylist.size() || playlistIndex <= 0) {
                        System.out.println("Commande invalide");
                    } else {
                        ArrayList playlistChoisie = listePlaylist.get(playlistIndex - 1);
                        LecteurMusique.lecturePlaylist(playlistChoisie);
                    }
                }
            }
        }
    }

    private static void afficherListePlaylist() {
        int index = 0;
        String[] nouvellePlaylist = new String[chansons.length];

        System.out.println();
        System.out.println("Liste des playlist : ");

        for (int i = 1; i < chansons.length; i++) {
            Scanner scan = null;

            try {
                scan = new Scanner(new BufferedReader(new FileReader("playlist" + i + ".txt")));
                System.out.println("Playlist "+ i);
            } catch (FileNotFoundException e) {
                break;
            }
        }
    }

    public static void supprimerPlaylist() throws FileNotFoundException {
        afficherListePlaylist();
        System.out.println();

        System.out.print("Numéro de la playlist à supprimer : ");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();

        while (true) {
            if (choix.equals("m")) {
                Hospify.affichageMenu();
            } else {
                int indexPlaylist = Integer.parseInt(choix);

                if (indexPlaylist - 1 < 0 || indexPlaylist > listePlaylist.size()) {
                    System.out.println();
                    System.out.println("Numéro invalide");
                    System.out.println();
                } else {
                    listePlaylist.remove(indexPlaylist);
                    System.out.println("La playlist " + indexPlaylist + " a été supprimée");
                    Hospify.affichageMenu();
                    break;
                }
            }
        }
    }
}
