package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> musiques = new ArrayList<>();
        ArrayList<String> musique1 = new ArrayList<String>();
        ArrayList<String> musique2 = new ArrayList<String>();
        ArrayList<String> musique3 = new ArrayList<String>();
        ArrayList<String> musique4 = new ArrayList<String>();

        musique1.add("Musqiue 1 titre");
        musique1.add("Musqiue 1 auteur");
        musique1.add("1:45");

        musique2.add("Musqiue 2 titre");
        musique2.add("Musqiue 2 auteur");
        musique2.add("2:45");

        musique3.add("Musqiue 3 titre");
        musique3.add("Musqiue 3 auteur");
        musique3.add("3:45");

        musique4.add("Musqiue 4 titre");
        musique4.add("Musqiue 4 auteur");
        musique4.add("4:45");

        musiques.add(musique1);
        musiques.add(musique2);
        musiques.add(musique3);
        musiques.add(musique4);

        LecteurMusique.lecteurMusique(musiques);
    }
}
