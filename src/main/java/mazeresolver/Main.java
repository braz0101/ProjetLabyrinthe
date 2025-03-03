package mazeresolver;

import mazeresolver.utils.LabyrintheGenerator;
import mazeresolver.utils.Chrono;
import mazeresolver.gui.LabyrinthePanel;

import javax.swing.*;
import java.awt.Point;
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

        Chrono chrono = new Chrono();
        chrono.start();
        if (solveurDFS.resoudreDFS()) {
            long tempsDFS = chrono.stop();
            System.out.println("\nChemin trouvé avec DFS !");
            marquerChemin(grilleDFS, solveurDFS.getChemin());
            System.out.println("Temps d'exécution DFS : " + tempsDFS + " ms");
            System.out.println("Nombre de cases visitées (DFS) : " + solveurDFS.getCasesVisitees());
        } else {
            System.out.println("\nAucun chemin trouvé avec DFS.");
        }

        System.out.println("\nLabyrinthe avec chemin DFS :");
        new Labyrinthe(grilleDFS).afficher();

        // Affichage graphique DFS
        afficherLabyrintheGraphique(grilleDFS, "Labyrinthe Résolu - DFS");

        // ============================
        // Résolution BFS
        // ============================
        char[][] grilleBFS = clonerGrille(grille);
        Solveur solveurBFS = new Solveur(grilleBFS);

        chrono.start();
        if (solveurBFS.resoudreBFS()) {
            long tempsBFS = chrono.stop();
            System.out.println("\nChemin trouvé avec BFS !");
            marquerChemin(grilleBFS, solveurBFS.getChemin());
            System.out.println("Temps d'exécution BFS : " + tempsBFS + " ms");
            System.out.println("Nombre de cases visitées (BFS) : " + solveurBFS.getCasesVisitees());
        } else {
            System.out.println("\nAucun chemin trouvé avec BFS.");
        }

        System.out.println("\nLabyrinthe avec chemin BFS :");
        new Labyrinthe(grilleBFS).afficher();

        // Affichage graphique BFS
        afficherLabyrintheGraphique(grilleBFS, "Labyrinthe Résolu - BFS");
    }

    /**
     * Marque les cases du chemin trouvé par + dans la grille.
     */
    private static void marquerChemin(char[][] grille, List<Point> chemin) {
        for (Point p : chemin) {
            if (grille[p.x][p.y] != 'S' && grille[p.x][p.y] != 'E') {
                grille[p.x][p.y] = '+';
            }
        }
    }

    /**
     * Clone une grille pour qu'on puisse faire DFS et BFS sur deux copies indépendantes.
     */
    private static char[][] clonerGrille(char[][] source) {
        char[][] copie = new char[source.length][];
        for (int i = 0; i < source.length; i++) {
            copie[i] = source[i].clone();
        }
        return copie;
    }

    /**
     * Affiche une fenêtre graphique avec le labyrinthe coloré.
     */
    private static void afficherLabyrintheGraphique(char[][] grille, String titre) {
        JFrame frame = new JFrame(titre);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new LabyrinthePanel(grille));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
