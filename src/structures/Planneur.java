package structures;

import jeu_de_la_vie.Monde;

public class Planneur implements Structure
{
	private int largeur;
	private int hauteur;
	
	public Planneur()
	{
		largeur = 3;
		hauteur = 3;
	}
	
	@Override
	public void ajouter(Monde monde, int x, int y)
	{
		if(x+largeur-1 < monde.get_largeur() && y+hauteur-1 < monde.get_hauteur())
		{
			monde.naissance(x+1,y);
			monde.naissance(x,y+2);
			monde.naissance(x+1,y+2);
			monde.naissance(x+2,y+2);
			monde.naissance(x+2,y+1);
		}
		else
		{
			System.out.println("Lplanneur dépasse de la grille, il n'a donc pas été instancié");
		}
	}
}
