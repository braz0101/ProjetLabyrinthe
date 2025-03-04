# 🧪 Maze Resolver - Solveur de Labyrinthe

Ce projet est une application Java permettant de générer et de résoudre des labyrinthes aléatoires à l'aide de deux algorithmes classiques :

- **DFS (Depth First Search)** : Parcours en profondeur
- **BFS (Breadth First Search)** : Parcours en largeur

---

## 📂 Structure du projet

Le projet est organisé comme suit :

src/
├── main/
│   ├── java/
│   │   ├── mazeresolver/                   # Ton package principal
│   │   │   ├── gui/                        # Interface graphique
│   │   │   │   ├── LabyrinthePanel.java
│   │   │   ├── utils/                      # Classes utilitaires
│   │   │   │   ├── Chrono.java
│   │   │   │   ├── LabyrintheGenerator.java
│   │   │   │   ├── LabyrintheLoader.java   # Un loader que tu n’avais pas mentionné avant, bien joué !
│   │   │   ├── Labyrinthe.java              # Logique du labyrinthe
│   │   │   ├── Main.java                     # Point d’entrée
│   │   │   ├── Solveur.java                  # Algorithmes de résolution
│   ├── resources/
│   │   ├── labyrinthe.txt                    # Exemple de labyrinthe stocké
├── test/
│   ├── java/                                # Dossier pour tests unitaires (peut être vide)
├── target/                                  # Dossier de compilation (généré)
├── pom.xml                                  # Fichier Maven


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

## 🖼️ Aperçu

### Labyrinthe généré

S==#=====#==#=#=#=== #===#==#=##===#===== ======#=#==##====#== ==#=====#=======#==# ==============#==##= =====#============#= ====#======#=======# =====#===========#== ========#=====#===== ==========#===#===#= ==#========#====#==# =#==========#======#
======#============= ==#=##====##=##===== =#===#========#===#= ========#=#=##====== ===##==#===#=====#== #==##========#====## =====#=#===========E


---

## 🔍 Résultats des Algorithmes

### Chemin trouvé avec DFS
- **Temps d'exécution DFS** : 2 ms
- **Nombre de cases visitées (DFS)** : 186

#### Labyrinthe avec chemin DFS

S++#=====#==#=#=#=== #=++#==#=##===#===== ===+++#=#==##====#== ==#==+++#=======#==# =======+++++++#==##= =====#=======+++++#= ====#======#=====++# =====#===========#++ ========#+++==#+++++ ++++++++++#++=#+==#+ +=#========#++++#==# +#==========#======# ++++++++++++++++++++ ======#============+ ==#=##====##=##+++++ =#===#========#+==#= ========#=#=##=+++++ ===##==#===#====+#++ #==##========#==++## =====#=#=========++E


---

### Chemin trouvé avec BFS
- **Temps d'exécution BFS** : 1 ms
- **Nombre de cases visitées (BFS)** : 327

#### Labyrinthe avec chemin BFS

S+=#=====#==#=#=#=== #+==#==#=##===#===== =+====#=#==##====#== =+#=====#=======#==# =+============#==##= =+===#============#= =+==#======#=======# =+===#===========#== =+======#=====#===== =+++======#===#===#= ==#+=======#====#==# =#=+========#======# ===+================ ===+==#============= ==#+##====##=##===== =#=+=#========#===#= ===+++==#=#=##====== ===##+=#===#=====#== #==##++++====#====## =====#=#+++++++++++E


---

## 📊 Comparatif DFS vs BFS

| Critère                | DFS        | BFS        |
|----------------|-----------|-----------|
| **Temps**             | 2 ms       | 1 ms       |
| **Cases visitées** | 186         | 327         |

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
