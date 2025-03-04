package mazeresolver;

import mazeresolver.utils.LabyrintheGenerator;
import mazeresolver.gui.LabyrinthePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le Projet Labyrinthe !");

        // Taille configurable
        int taille = 20;

        // Générer un labyrinthe aléatoire 20x20
        char[][] grille = LabyrintheGenerator.genererLabyrinthe(taille);
        Labyrinthe labyrinthe = new Labyrinthe(grille);

        System.out.println("\nLabyrinthe généré :");
        labyrinthe.afficher();

        // ============================
        // Résolution DFS
        // ============================
        char[][] grilleDFS = clonerGrille(grille);
        Solveur solveurDFS = new Solveur(grilleDFS);

        if (solveurDFS.resoudreDFS()) {
            System.out.println("\nChemin trouvé avec DFS !");
            marquerChemin(grilleDFS, solveurDFS.getChemin());
            System.out.println("Temps d'exécution DFS : " + solveurDFS.getTempsExecution() + " ms");
            System.out.println("Nombre de cases visitées (DFS) : " + solveurDFS.getCasesVisitees());
        } else {
            System.out.println("\nAucun chemin trouvé avec DFS.");
        }

        System.out.println("\nLabyrinthe avec chemin DFS :");
        new Labyrinthe(grilleDFS).afficher();
        afficherLabyrintheGraphique(grilleDFS, "Labyrinthe Résolu - DFS");

        // ============================
        // Résolution BFS
        // ============================
        char[][] grilleBFS = clonerGrille(grille);
        Solveur solveurBFS = new Solveur(grilleBFS);

        if (solveurBFS.resoudreBFS()) {
            System.out.println("\nChemin trouvé avec BFS !");
            marquerChemin(grilleBFS, solveurBFS.getChemin());
            System.out.println("Temps d'exécution BFS : " + solveurBFS.getTempsExecution() + " ms");
            System.out.println("Nombre de cases visitées (BFS) : " + solveurBFS.getCasesVisitees());
        } else {
            System.out.println("\nAucun chemin trouvé avec BFS.");
        }

        System.out.println("\nLabyrinthe avec chemin BFS :");
        new Labyrinthe(grilleBFS).afficher();
        afficherLabyrintheGraphique(grilleBFS, "Labyrinthe Résolu - BFS");

        // ============================
        // Comparaison finale
        // ============================
        afficherComparaison(
                solveurDFS.getTempsExecution(), solveurDFS.getCasesVisitees(),
                solveurBFS.getTempsExecution(), solveurBFS.getCasesVisitees()
        );
    }

    private static void marquerChemin(char[][] grille, List<Point> chemin) {
        for (Point p : chemin) {
            if (grille[p.x][p.y] != 'S' && grille[p.x][p.y] != 'E') {
                grille[p.x][p.y] = '+';
            }
        }
    }

    private static char[][] clonerGrille(char[][] source) {
        char[][] copie = new char[source.length][];
        for (int i = 0; i < source.length; i++) {
            copie[i] = source[i].clone();
        }
        return copie;
    }

    private static void afficherLabyrintheGraphique(char[][] grille, String titre) {
        JFrame frame = new JFrame(titre);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new LabyrinthePanel(grille));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void afficherComparaison(long tempsDFS, int etapesDFS, long tempsBFS, int etapesBFS) {
        System.out.println("\n==========================");
        System.out.println(" Comparaison DFS vs BFS");
        System.out.println("==========================");
        System.out.printf("DFS  : %d étapes, %d ms\n", etapesDFS, tempsDFS);
        System.out.printf("BFS  : %d étapes, %d ms\n", etapesBFS, tempsBFS);
        System.out.println("==========================\n");
    }
}
