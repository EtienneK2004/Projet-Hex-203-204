# <p align="center"> _Dossier de développement_ <br/> <ins> Projet Hex </ins> </p>
### <p align="center"> Qualité de développement </p>

<hr>

### <center> Groupe 203 / 204</center>

Par <br/>
Etienne Kita <br/>
Tony Zheng <br/>
Patrick Wu <br/>
Steven Tea <br/>

MZ: Note 15/20 au groupe. La note de l'exo du DST ne sera prise en compte que si elle est supérieure donc cette note ne peut pas baisser.

<div dir="rtl"> Décembre 2022 </div>

<hr>

## Table des matières

1. [Introduction](#intro)
2. [Diagramme d'architechture](#archi)
3. [Ce qui a été testé par les tests unitaires](#testsU)
4. [Tâches à accomplir pour modifier certaines règles](#modif)
5. [Bilan du projet](#bilan)
    1. Difficultés rencontrées
    2. Ce qui est réussi
    3. Ce qui peut être amélioré

<a id="intro"></a>

## <ins> <p class="titre">I - Introduction</p> </ins>
&ensp;&ensp;&ensp;&ensp; Globalement, nous avons pu réussir à intégrer et faire fonctionner pratiquement tout ce qui a été demandé. Cependant, notre plateau est limité à une taille maximale de 9, car au delà, nous avons eu des problèmes de saisies qui prenait en compte uniquement 2 caractères (une lettre et un chiffre), de même pour les IA qui étaient conçu pour avoir un getCoup() à 2 caractères. Nous n'avons également pas pu d'intégrer une interface Homme-Machine avec une interface graphique. Nous comptions à la base voulut le faire avec la bibliothèque graphique JFrame, mais par faute de temps à cause d'autres projets et l'apprentissage de la bibliothèque, nous n'avions malheureusement pas eu le temps de l'intégrer.

<a id="archi"></a>

## <ins> <p class="titre">II - Diagramme d'architechture</p> </ins>
![Diagramme architechture du Hex](Hex.png)

<a id="testsU"></a>

## <ins> <p class="titre">III - Ce qui a été testé par les tests unitaires</p> </ins>
&ensp;&ensp;&ensp;&ensp; Plusieurs classes ont été testées avec les tests unitaires de JUnit.
Les classes testées sont :
* L'énumération Pion
    * Les méthodes toString() et get() ont été testées et validées
* La classe Hex
    * Les méthodes estValide(), jouerCoup(), getPlateau() et toString() ont été testées et validées
* La classe Plateau
    * Les méthodes taille(), jouer(), getCase(), toString(), decouper() et getTaille() ont été testées et validées
* Les classes d'IA et l'interface IAHex
    * La méthode getCoup() pour les deux types d'IA et la méthode checkWin() ont été testées et validées

<a id="modif"></a>

## <ins> <p class="titre">IV - Tâches à accomplir pour modifier certaines règles</p> </ins>
&ensp;&ensp;&ensp;&ensp; Certaines options peuvent être ajouté en faisait certaines interactions à des moments très spécifiques.

Nous pouvons faire jouer des ordinateurs plus ou moins forts. Pour faire jouer une IA au lieu d'un joueur humain, lorsque nous devons entrer le nom d'un des joueurs, nous saisissons un chiffre au lieu d'une chaine de caractères. Nous avons pour l'instant développé deux niveaux de difficulté d'IA :
1. En saisissant "0" comme nom de joueur : une IA qui tire des coups aléatoires.
1. En saisissant "1" comme nom de joueur : une IA développée avec ChatGPT.

Ainsi, nous pouvons faire jouer un humain contre un humain, un humain contre un ordinateur et un ordinateur contre un ordinateur.
Nous pouvons également modifier la taille du Plateau. Lors de la deuxième saisie, la taille du plateau est demandée à l'utilisateur. La taille doit être comprise entre 1 et 9 pour que le plateau soit légal.

<a id="bilan"></a>

## <ins> <p class="titre">V - Bilan du projet</p> </ins>

### 1) Difficultés rencontrées
&ensp;&ensp;&ensp;&ensp; Lors du développement du jeu Hex, nous avons rencontré de nombreuses difficultés, par exemple, pour la méthode gagnant() de la classe Hex, permettant de vérifier qu'il y a une rangée est bien valide a été difficiles à concevoir. En effet, contrairement au démineur, uniquement six cases du plateau sont adjacentes à une case et l'affichage en "losange" du plateau rend l'interface moins clairement à débugger (nous avons eu du mal à savoir quelles cases étaient adjacentes ou non).

### 2) Ce qui est réussi
&ensp;&ensp;&ensp;&ensp; Afin de gérer les cases hexagonales, nous avons été assez fiers d'avoir pu utiliser le design pattern Composite, que nous avons vu en cours, pour faire la gestion en lots de cases. De plus, grâce à cela, nous avons pu réussir à faire fonctionner la méthode gagnant() de la classe Hex. Nous avons également essayé du mieux que nous pouvons pour que notre programme respecte les principes SOLID.

### 3) Ce qui peut être amélioré
&ensp;&ensp;&ensp;&ensp; Pour ce projet, nous aurions pu ajouter développer une interface graphique pour le jeu et ainsi pouvoir choisir si l'utilisateur joue en mode console ou en mode graphique. Nous aurions également pu faire adapter notre code pour qu'il puisse permettre de taille de plateau plus grande, jusque 26 lignes et colonnes.
