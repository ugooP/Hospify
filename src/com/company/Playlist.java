package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private static int playlistCount = 0;   //Nombre de playlist disponibles
    public static String[] nosPlaylist = new String[200];  //
    public static ArrayList<ArrayList> listePlaylist = new ArrayList<>();

    public static void creerPlaylist() throws Exception { //Créer une playlist
        int chansonCounter = 0;
        ArrayList<Musiques> nouvellePlaylist = new ArrayList<>();
        System.out.println();
        System.out.println("Voici la liste des chansons disponibles:");
        System.out.println();
        afficherListeMusiques();    //Afficher les musiques dispo
        System.out.println();
        System.out.println("Taper V pour valider la playlist");
        System.out.println("Taper M pour revenir au menu");

        while (true) {      //Demande à l'utilisateur de choisir les musiques qu'il veut dans sa playlist
            System.out.print("Entrer le numéro de la chanson à ajouter : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.toLowerCase().equals("v")) { //Validation et stock de la playlist créée
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

    static void afficherListeMusiques() {   //Afficher la liste complète des musiques disponibles
        ArrayList<Musiques> musiques = Hospify.listeMusiques;
        for (int i = 0; i < musiques.size(); i++) {
            System.out.println(i + ". " + musiques.get(i).getTitre() + " - " + musiques.get(i).getArtiste() + " (" + musiques.get(i).getDuree() + ")");
        }
    }

    private static void afficherPlaylist(ArrayList<Musiques> nouvellePlaylist) { //Affiche la playlist actuelle
        System.out.println();
        for (int i = 0; i < nouvellePlaylist.size(); i++) {
            System.out.println(nouvellePlaylist.get(i).getTitre() + " - " + nouvellePlaylist.get(i).getArtiste() + " (" + nouvellePlaylist.get(i).getDuree() + ")");
        }
        System.out.println();
    }

    public static void jouerPlaylist() throws Exception { //Jouer la playlist
        afficherListePlaylist();
        System.out.println();

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

    private static void afficherListePlaylist() throws FileNotFoundException { //Afficher la playlist en train d'être créer
        int index = 0;

        System.out.println();
        System.out.println("Liste des playlist : ");

        for (int i = 1; i < nosPlaylist.length; i++) {
            Scanner scan = null;

            try {
                scan = new Scanner(new BufferedReader(new FileReader("playlist" + i + ".txt")));
                System.out.println("Playlist " + i);
            } catch (FileNotFoundException e) {
                break;
            }
        }
    }

    public static void supprimerPlaylist() throws Exception { //Supprimer une playlist
        afficherListePlaylist();
        System.out.println();

        while (true) {  //Choix de la playlist à la supprimer
            System.out.print("Numéro de la playlist à supprimer : ");
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();

            if (choix.equals("m")) {
                Hospify.affichageMenu();
            } else {
                int indexPlaylist = Integer.parseInt(choix) - 1;

                if (indexPlaylist < 0 || indexPlaylist > listePlaylist.size()) {
                    System.out.println();
                    System.out.println("Numéro invalide");
                    System.out.println();
                } else {
                    listePlaylist.remove(indexPlaylist);
                    indexPlaylist++;
                    System.out.println("La playlist " + indexPlaylist + " a été supprimée");
                    Hospify.affichageMenu();
                    break;
                }
            }
        }
    }
}
