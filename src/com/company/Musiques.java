package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Musiques {

    private String artiste;
    private String titre;
    private String duree;

    public Musiques(String titre, String artiste, String duree) {
        this.titre = titre;
        this.artiste = artiste;
        this.duree = duree;
    }

    public Musiques() {

    }

    public static void ajouterNouvelleMusique(Musiques musique) throws FileNotFoundException {
        try {
            File file = new File("musiques2.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(musique.getTitre() + "/" + musique.getArtiste() + "/" + musique.getDuree() + "/");
            fr.close();
        } catch (IOException e) {
            System.out.println("Un problème est survenu");
        }
    }

    public static void supprimerMusique() throws Exception {

        System.out.println();
        System.out.println("Voici la liste des chansons disponibles :");
        System.out.println();
        Playlist.afficherListeMusiques();

        while (true) {
            System.out.println();
            System.out.print("Entrer le numéro de la chanson à supprimer : ");
            Scanner scan = new Scanner(System.in);
            String entreeUtilisateur = scan.nextLine();

            if (entreeUtilisateur.equals("m")) {
                Hospify.affichageMenu();
            } else {
                int indexMusique = Integer.parseInt(entreeUtilisateur);

                if (indexMusique < 0 || indexMusique > Hospify.listeMusiques.size()) {
                    System.out.println();
                    System.out.println("Numéro invalide");
                } else {
                    System.out.println();
                    String msgValidation = Hospify.listeMusiques.get(indexMusique).getTitre() + " de " + Hospify.listeMusiques.get(indexMusique). getArtiste() + " vient d'être supprimée";

                    Hospify.listeMusiques.remove(indexMusique);

                    String musiqueDescription = Hospify.listeMusiques.get(indexMusique).getTitre() + "/" + Hospify.listeMusiques.get(indexMusique).getArtiste() + "/" + Hospify.listeMusiques.get(indexMusique).getDuree() + "/";
                    fileToString().replaceAll(musiqueDescription, "");

                    System.out.println(msgValidation);
                    Hospify.affichageMenu();
                }

            }

        }
    }

    public static String fileToString() throws Exception {
        String input = null;
        Scanner sc = new Scanner(new File("musiques2.txt"));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getTitre() {
        return titre;
    }

    public String getDuree() {
        return duree;
    }

        public static void lecturePlaylist(ArrayList<Musiques> playlist){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("musiques2.txt")));
            scanner.useDelimiter("/");
            while (scanner.hasNextLine()){
                String titre = scanner.next();

                scanner.skip(scanner.delimiter());

                String artiste = scanner.next();

                scanner.skip(scanner.delimiter());

                String duree = scanner.next();
                scanner.skip(scanner.delimiter());

                Musiques musiques = new Musiques(titre,artiste,duree);
                System.out.println(musiques.getTitre() + " - " + musiques.getArtiste() + " - " + musiques.getDuree());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
