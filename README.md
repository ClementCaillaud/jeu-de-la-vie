# jeu-de-la-vie
Mise en oeuvre du jeu de la vie de Conway, en Java

## Présentation
Ce programme permet d'afficher une grille, d'y ajouter des structures prédéfinies ou personnalisées, puis d'observer leur évolution au fil du temps.
Les différents paramètres comme la taille et la vitesse d'exécution sont personnalisables.
Les cellules vivantes sont grisées, les mortes sont blanches. 
Chaque cellule a 8 voisines (voisins directs et diagonales)

Elles évoluent en suivant les règles ci-dessous.

## Règles
- Si une cellule vivante a 2 ou 3 voisines vivantes, elle reste vivante
- Si une cellule vivante a moins de 2 voisines vivantes, elle meurt d'isolement
- Si une cellule vivante a plus de 3 voisines vivantes, elle meurt d'étouffement
- Si une cellule morte a 3 voisines vivantes, elle naît
