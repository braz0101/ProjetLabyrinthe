# 🧪 Maze Resolver - Solveur de Labyrinthe

Ce projet est une application Java permettant de générer, charger et résoudre des labyrinthes. Deux algorithmes classiques sont implémentés pour la résolution :

- DFS (Depth First Search - Parcours en profondeur)
- BFS (Breadth First Search - Parcours en largeur)
  
L'application offre une interface console interactive permettant de :

- Générer un labyrinthe aléatoire.
- Charger un labyrinthe depuis un fichier.
- Choisissez entre DFS, BFS ou une comparaison des deux algorithmes.

---
## 📂 Structure du projet

Le projet est organisé comme suit :

src/
├── main/
│   ├── java/
│   │   ├── mazeresolver/                 # Package principal
│   │   │   ├── gui/                       # Interface graphique
│   │   │   │   ├── LabyrinthePanel.java
│   │   │   ├── utils/                     # Classes utilitaires
│   │   │   │   ├── Chrono.java            # Chrono pour mesurer le temps d'exécution de chaque algorithme
│   │   │   │   ├── LabyrintheGenerator.java #Générateur aléatoire de labyrinthe
│   │   │   │   ├── LabyrintheLoader.java  # Un loader (charger le labyrinthe)
│   │   │   ├── Labyrinthe.java            # Logique du labyrinthe
│   │   │   ├── Main.java                   # Point d’entrée
│   │   │   ├── Solveur.java                # Algorithmes de résolution
│   ├── resources/
│   │   ├── labyrinthe.txt                  # Exemple de labyrinthe stocké
├── test/
│   ├── java/                               # Dossier pour tests unitaires (peut être vide)
├── target/                                # Dossier de compilation (généré)
├── pom.xml                                # Fichier Maven


---
## 🛠️ Prérequis

- **Java 11 ou supérieur** recommandé (Testé avec OpenJDK 23)
- Un IDE Java (IntelliJ, Eclipse, NetBeans) ou un terminal avec le JDK installé.

---

## 🚀 Compilation et Exécution

### Option 1 : Exécution via un IDE
1. Importer le projet dans votre IDE.
2. Exécuter la classe **Main.java**.

### Option 2 : Exécution via Terminal

1. Ouvrir un terminal à la racine du dossier `src`.
2. Compiler toutes les classes :
    ```bash
    javac mazeresolver/*.java
    ```
3. Lancer l’application :
    ```bash
    java mazeresolver.Main
    ```

---

## 🖼️ Aperçu après exécution

1. Exemple en utilisant le fichier labyrinthe.txt :
<img width="597" alt="1" src="https://github.com/user-attachments/assets/8ebd110a-b0ab-4af9-8961-391dead8a03b" />

<img width="709" alt="2" src="https://github.com/user-attachments/assets/bc323342-7a63-49ab-a3f2-40c3d701453b" />

<img width="629" alt="3" src="https://github.com/user-attachments/assets/03e36c63-afda-40a0-ac78-653a23b9744d" />


2. Exemple en générant d'un fichier aléatoire :
<img width="640" alt="5" src="https://github.com/user-attachments/assets/3cb111d7-10ef-460d-b2c7-c0819a0a88e2" />

<img width="395" alt="6" src="https://github.com/user-attachments/assets/b78dfe27-f619-43eb-bfd7-9fd826afb123" />

<img width="824" alt="7" src="https://github.com/user-attachments/assets/56efb1d2-0901-4e57-bf67-ccb94b34b6d8" />

### Labyrinthe généré aléatoirement

S====#====
#========#
=#========
==========
#=======#=
#==#=#====
======#===
==#=#=====
=#===####=
#==#==#==E
---

## 🔍 Résultats des Algorithmes

🔍 Résolution avec DFS...

✅ Chemin trouvé avec DFS !
Temps d'exécution DFS : 1 ms
Nombre de cases visitées (DFS) : 63

Labyrinthe avec chemin DFS :
S++++#====
#===+++++#
=#======++
=========+
#++++++=#+
#+=#=#++++
=+++++#===
==#=#+++++
=#===####+
#==#==#==E

🔍 Résolution avec BFS...

✅ Chemin trouvé avec BFS !
Temps d'exécution BFS : 0 ms
Nombre de cases visitées (BFS) : 78

Labyrinthe avec chemin BFS :
S+===#====
#++======#
=#+=======
==+=======
#=+=====#=
#=+#=#====
==++++#===
==#=#+++++
=#===####+
#==#==#==E


## 📊 Comparatif DFS vs BFS

| Critère                | DFS        | BFS        |
|----------------|-----------|-----------|
| **Temps**             | 1 ms       | 0 ms       |
| **Cases visitées** | 63         | 78         |

---

## 📄 Licence

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

Ce projet est distribué sous la licence **MIT**. Consultez le fichier [LICENSE](LICENSE) pour plus de détails.

---

## 👨‍💻 Auteur

- [braz0101](https://github.com/braz0101)

---

### 📬 Contact

Si vous avez des questions ou souhaitez proposer des améliorations, n’hésitez pas à ouvrir une issue ou à me contacter directement sur GitHub.
