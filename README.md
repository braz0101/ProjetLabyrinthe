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

<img width="639" alt="ooo" src="https://github.com/user-attachments/assets/0ecf2b37-e768-494b-93d4-5e7a018a458a" />


---
## 🛠️ Prérequis

- **Java 17 ou supérieur** recommandé (Testé avec 23)
- Un IDE comme **IntelliJ**, **Eclipse** ou **NetBeans**.
- **Maven** (facultatif si tu utilises un IDE).

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
## 🚀 Fonctionnalités

### 1️⃣ Choix de la source du labyrinthe
- **Génération aléatoire** : taille configurable (5x5 à 50x50)
- **Chargement depuis un fichier** (labyrinthe.txt)

### 2️⃣ Choix de la méthode de résolution
- Résolution avec **DFS uniquement**
- Résolution avec **BFS uniquement**
- **Utilisation de DFS et BFS puis Comparaison complète** entre les deux

### 3️⃣ Comparaison détaillée
Après résolution, le programme affiche :
- ✅ Le chemin trouvé (en console)
- ✅ Le **nombre de cases visitées**
- ✅ Le **temps d'exécution**
- ✅ Le chemin en **interface graphique** avec Swing

---
## 📊 Exemple de sortie

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
