package mazeresolver;

import java.awt.Point;
import java.util.*;

public class Solveur {

    private char[][] labyrinthe;
    private boolean[][] visite;
    private List<Point> chemin;
    private int casesVisitees;  // Nouveau compteur

    public Solveur(char[][] labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.visite = new boolean[labyrinthe.length][labyrinthe[0].length];
        this.chemin = new ArrayList<>();
    }

    public List<Point> getChemin() {
        return chemin;
    }

    public int getCasesVisitees() {
        return casesVisitees;
    }

    private Point trouverPoint(char cible) {
        for (int i = 0; i < labyrinthe.length; i++) {
            for (int j = 0; j < labyrinthe[i].length; j++) {
                if (labyrinthe[i][j] == cible) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private List<Point> voisins(Point p) {
        List<Point> liste = new ArrayList<>();
        liste.add(new Point(p.x - 1, p.y));
        liste.add(new Point(p.x + 1, p.y));
        liste.add(new Point(p.x, p.y - 1));
        liste.add(new Point(p.x, p.y + 1));
        return liste;
    }

    private boolean estValide(Point p) {
        if (p.x < 0 || p.x >= labyrinthe.length || p.y < 0 || p.y >= labyrinthe[0].length) {
            return false;
        }
        if (labyrinthe[p.x][p.y] == '#' || visite[p.x][p.y]) {
            return false;
        }
        return true;
    }

    // ============================
    // DFS avec compteur
    // ============================
    public boolean resoudreDFS() {
        Point depart = trouverPoint('S');
        Point arrivee = trouverPoint('E');

        if (depart == null || arrivee == null) {
            System.out.println("Départ ou arrivée introuvable.");
            return false;
        }

        Stack<Point> pile = new Stack<>();
        pile.push(depart);
        visite[depart.x][depart.y] = true;

        casesVisitees = 1;  // On démarre avec le départ visité

        while (!pile.isEmpty()) {
            Point courant = pile.pop();
            chemin.add(courant);

            if (courant.equals(arrivee)) {
                return true;
            }

            for (Point voisin : voisins(courant)) {
                if (estValide(voisin)) {
                    visite[voisin.x][voisin.y] = true;
                    pile.push(voisin);
                    casesVisitees++;
                }
            }
        }
        return false;
    }

    // ============================
    // BFS avec compteur
    // ============================
    public boolean resoudreBFS() {
        Point depart = trouverPoint('S');
        Point arrivee = trouverPoint('E');

        if (depart == null || arrivee == null) {
            System.out.println("Départ ou arrivée introuvable.");
            return false;
        }

        visite = new boolean[labyrinthe.length][labyrinthe[0].length];
        chemin.clear();
        casesVisitees = 1;  // On démarre avec le départ visité

        Queue<Point> file = new LinkedList<>();
        Map<Point, Point> parents = new HashMap<>();

        file.add(depart);
        visite[depart.x][depart.y] = true;
        parents.put(depart, null);

        while (!file.isEmpty()) {
            Point courant = file.poll();

            if (courant.equals(arrivee)) {
                reconstruireChemin(parents, arrivee);
                return true;
            }

            for (Point voisin : voisins(courant)) {
                if (estValide(voisin)) {
                    visite[voisin.x][voisin.y] = true;
                    file.add(voisin);
                    parents.put(voisin, courant);
                    casesVisitees++;
                }
            }
        }
        return false;
    }

    private void reconstruireChemin(Map<Point, Point> parents, Point arrivee) {
        Point courant = arrivee;
        while (courant != null) {
            chemin.add(courant);
            courant = parents.get(courant);
        }
        Collections.reverse(chemin);
    }
}
