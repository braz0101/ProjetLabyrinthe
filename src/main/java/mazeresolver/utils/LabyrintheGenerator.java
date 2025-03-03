package mazeresolver.utils;

import java.util.Random;

public class LabyrintheGenerator {

    private static final Random random = new Random();

    public static char[][] genererLabyrinthe(int taille) {
        char[][] labyrinthe = new char[taille][taille];

        // Générer un labyrinthe vide avec juste des passages
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                labyrinthe[i][j] = '=';
            }
        }

        // Placer des murs aléatoires mais sans bloquer complètement
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (!(i == 0 && j == 0) && !(i == taille - 1 && j == taille - 1)) {
                    if (random.nextDouble() < 0.2) {  // 20% de murs
                        labyrinthe[i][j] = '#';
                    }
                }
            }
        }

        // Créer un chemin direct entre S et E (option sécurité)
        int x = 0, y = 0;
        while (x < taille - 1 || y < taille - 1) {
            if (x < taille - 1 && random.nextBoolean()) {
                x++;
            } else if (y < taille - 1) {
                y++;
            }
            labyrinthe[x][y] = '=';
        }

        labyrinthe[0][0] = 'S';
        labyrinthe[taille - 1][taille - 1] = 'E';

        return labyrinthe;
    }
}
