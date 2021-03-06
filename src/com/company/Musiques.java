package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Musiques {

    private String artiste;
    private String titre;
    private String duree;

    public Musiques(String titre, String artiste, String duree) { //Constructeur musique
        this.titre = titre;
        this.artiste = artiste;
        this.duree = duree;
    }

    public static void ajouterNouvelleMusique(Musiques musique) throws FileNotFoundException { //Writer pour écrire une nouvelle musique au fichier txt.
        try {
            File file = new File("musiques2.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(musique.getTitre() + "/" + musique.getArtiste() + "/" + musique.getDuree() + "/");
            fr.close();
        } catch (IOException e) {
            System.out.println("Un problème est survenu");
        }
    }

    public static void supprimerMusique() throws Exception {    //Supprimer une musique du fichier

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

    public static String fileToString() throws Exception { //Conversion en String pour le fichier
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
                                                                    //liste de getter/setter
    public String getArtiste() {
        return artiste;
    }

    public String getTitre() {
        return titre;
    }

    public String getDuree() {
        return duree;
    }


    public static void ajouterNouvelleChanson() throws Exception { //Ajouter une nouvelle musique manuellement au fichier

        System.out.println();
        System.out.println("Ajout d'une nouvelle chanson");

        System.out.println();
        System.out.print("Titre : ");
        Scanner titreScan = new Scanner(System.in);
        String titre = titreScan.nextLine();


        System.out.print("Artiste : ");
        Scanner artisteScan = new Scanner(System.in);
        String artiste = artisteScan.nextLine();

        System.out.print("Durée : ");
        Scanner dureeScan = new Scanner(System.in);
        String duree = dureeScan.nextLine();

        Musiques musique = new Musiques(titre, artiste, duree);
        Musiques.ajouterNouvelleMusique(musique);
        Hospify.listeMusiques.add(musique);


        System.out.println("nouvelle musique ajoutée !");
        Hospify.affichageMenu();

    }

        public static void lecturePlaylist(ArrayList<Musiques> playlist){ //Lecture du fichier .txt
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
