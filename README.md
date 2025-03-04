# 🧪 Maze Resolver - Solveur de Labyrinthe

Ce projet est une application Java permettant de générer et de résoudre des labyrinthes aléatoires à l'aide de deux algorithmes classiques :

- **DFS (Depth First Search)** : Parcours en profondeur
- **BFS (Breadth First Search)** : Parcours en largeur

---
## 📂 Structure du projet

Le projet est organisé comme suit :

<img width="515" alt="ooo" src="https://github.com/user-attachments/assets/7b6bffe0-9a78-444c-a025-f2be7092a2c0" />

<img width="305" alt="plan" src="https://github.com/user-attachments/assets/0c86209f-a947-41ed-8f95-c33f5404b3be" />

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

<img width="928" alt="resultats images" src="https://github.com/user-attachments/assets/d4fadc80-8d71-4241-8474-33e9ec2ab635" />

<img width="938" alt="resultats images 2" src="https://github.com/user-attachments/assets/b311867c-1ae5-4cbf-a786-cd854fd37a5b" />

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
