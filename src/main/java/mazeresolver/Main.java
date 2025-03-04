package mazeresolver;

import mazeresolver.utils.LabyrintheGenerator;
import mazeresolver.utils.LabyrintheLoader;
import mazeresolver.gui.LabyrinthePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le Résolveur de Labyrinthe !");
        Scanner scanner = new Scanner(System.in);

        char[][] grille;
        int taille = 20; // Taille par défaut

        // ================================
        // MENU : Charger ou Générer ?
        // ================================
        System.out.println("\n1. Générer un labyrinthe aléatoire");
        System.out.println("2. Charger le labyrinthe depuis le fichier labyrinthe.txt ");
        System.out.print("Choisissez une option (1 ou 2) : ");
        int choix = scanner.nextInt();

        if (choix == 1) {
            System.out.print("Entrez la taille du labyrinthe (entre 5 et 50) : ");
            taille = scanner.nextInt();
            if (taille < 5 || taille > 50) {
                System.out.println("⚠️ Taille invalide. Utilisation de la taille 20 par défaut : 20x20.");
                taille = 20;
            }
            grille = LabyrintheGenerator.genererLabyrinthe(taille);
        } else {
            try {
                grille = LabyrintheLoader.chargerDepuisFichier("labyrinthe.txt");
                System.out.println("✅ Labyrinthe chargé depuis le fichier labyrinthe.txt .");
            } catch (IOException e) {
                System.err.println("❌ Erreur lors du chargement du fichier : " + e.getMessage());
                return;
            }
        }

        Labyrinthe labyrinthe = new Labyrinthe(grille);
        System.out.println("\n📥 Labyrinthe généré/chargé :");
        labyrinthe.afficher();

        // ================================
        // MENU : Choix de l’algorithme
        // ================================
        System.out.println("\n1. Résolution avec DFS");
        System.out.println("2. Résolution avec BFS");
        System.out.println("3. Utiliser DFS et BFS puis comparer les deux");
        System.out.print("Choisissez une option (1, 2 ou 3) : ");
        int algoChoix = scanner.nextInt();

        boolean faireDFS = (algoChoix == 1 || algoChoix == 3);
        boolean faireBFS = (algoChoix == 2 || algoChoix == 3);

        // ================================
        // DFS
        // ================================
        long tempsDFS = 0;
        int etapesDFS = 0;
        if (faireDFS) {
            System.out.println("\n🔍 Résolution avec DFS...");
            char[][] grilleDFS = clonerGrille(grille);
            Solveur solveurDFS = new Solveur(grilleDFS);

            if (solveurDFS.resoudreDFS()) {
                System.out.println("\n✅ Chemin trouvé avec DFS !");
                marquerChemin(grilleDFS, solveurDFS.getChemin());
                tempsDFS = solveurDFS.getTempsExecution();
                etapesDFS = solveurDFS.getCasesVisitees();
                System.out.printf("Temps d'exécution DFS : %d ms\n", tempsDFS);
                System.out.printf("Nombre de cases visitées (DFS) : %d\n", etapesDFS);

                System.out.println("\nLabyrinthe avec chemin DFS :");
                new Labyrinthe(grilleDFS).afficher();
                afficherLabyrintheGraphique(grilleDFS, "Labyrinthe Résolu - DFS");
            } else {
                System.out.println("\n❌ Aucun chemin trouvé avec DFS.");
            }
        }

        // ================================
        // BFS
        // ================================
        long tempsBFS = 0;
        int etapesBFS = 0;
        if (faireBFS) {
            System.out.println("\n🔍 Résolution avec BFS...");
            char[][] grilleBFS = clonerGrille(grille);
            Solveur solveurBFS = new Solveur(grilleBFS);

            if (solveurBFS.resoudreBFS()) {
                System.out.println("\n✅ Chemin trouvé avec BFS !");
                marquerChemin(grilleBFS, solveurBFS.getChemin());
                tempsBFS = solveurBFS.getTempsExecution();
                etapesBFS = solveurBFS.getCasesVisitees();
                System.out.printf("Temps d'exécution BFS : %d ms\n", tempsBFS);
                System.out.printf("Nombre de cases visitées (BFS) : %d\n", etapesBFS);

                System.out.println("\nLabyrinthe avec chemin BFS :");
                new Labyrinthe(grilleBFS).afficher();
                afficherLabyrintheGraphique(grilleBFS, "Labyrinthe Résolu - BFS");
            } else {
                System.out.println("\n❌ Aucun chemin trouvé avec BFS.");
            }
        }

        // ================================
        // Comparaison finale
        // ================================
        if (faireDFS && faireBFS) {
            afficherComparaison(tempsDFS, etapesDFS, tempsBFS, etapesBFS);
        }

        System.out.println("\nMerci d’avoir utilisé le résolveur de labyrinthe !");
        scanner.close();
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
