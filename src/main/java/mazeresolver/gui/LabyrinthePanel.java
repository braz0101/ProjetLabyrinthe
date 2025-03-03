package mazeresolver.gui;

import javax.swing.*;
import java.awt.*;

public class LabyrinthePanel extends JPanel {

    private final char[][] labyrinthe;

    public LabyrinthePanel(char[][] labyrinthe) {
        this.labyrinthe = labyrinthe;
        setPreferredSize(new Dimension(labyrinthe[0].length * 30, labyrinthe.length * 30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < labyrinthe.length; i++) {
            for (int j = 0; j < labyrinthe[i].length; j++) {
                switch (labyrinthe[i][j]) {
                    case '#':
                        g.setColor(Color.BLACK);  // Mur
                        break;
                    case 'S':
                        g.setColor(Color.BLUE);   // Départ
                        break;
                    case 'E':
                        g.setColor(Color.RED);    // Arrivée
                        break;
                    case '+':
                        g.setColor(Color.GREEN);  // Chemin trouvé
                        break;
                    default:
                        g.setColor(Color.WHITE);  // Passage libre
                        break;
                }
                g.fillRect(j * 30, i * 30, 30, 30);
                g.setColor(Color.GRAY);
                g.drawRect(j * 30, i * 30, 30, 30);  // Grille
            }
        }
    }
}
