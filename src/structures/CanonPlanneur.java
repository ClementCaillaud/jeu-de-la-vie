package structures;

import jeu_de_la_vie.Monde;

public class CanonPlanneur implements Structure
{
	private int largeur;
	private int hauteur;
	
	public CanonPlanneur()
	{
		largeur = 36;
		hauteur = 9;
	}
	
	@Override
	public void ajouter(Monde monde, int x, int y)
	{
		if(x+largeur-1 < monde.get_largeur() && y+hauteur-1 < monde.get_hauteur())
		{
			monde.naissance(x, y+5);
			monde.naissance(x+1, y+5);
			monde.naissance(x, y+6);
			monde.naissance(x+1, y+6);
			
			monde.naissance(x+11, y+4);
			monde.naissance(x+11, y+5);
			monde.naissance(x+11, y+6);
			monde.naissance(x+12, y+3);
			monde.naissance(x+12, y+7);
			monde.naissance(x+13, y+2);
			monde.naissance(x+13, y+8);
			monde.naissance(x+14, y+3);
			monde.naissance(x+14, y+7);
			monde.naissance(x+15, y+4);
			monde.naissance(x+15, y+5);
			monde.naissance(x+15, y+6);
			monde.naissance(x+16, y+4);
			monde.naissance(x+16, y+5);
			monde.naissance(x+16, y+6);
			
			monde.naissance(x+21, y+2);
			monde.naissance(x+21, y+3);
			monde.naissance(x+21, y+4);
			monde.naissance(x+22, y+1);
			monde.naissance(x+22, y+2);
			monde.naissance(x+22, y+4);
			monde.naissance(x+22, y+5);
			monde.naissance(x+23, y+1);
			monde.naissance(x+23, y+2);
			monde.naissance(x+23, y+4);
			monde.naissance(x+23, y+5);
			monde.naissance(x+24, y+1);
			monde.naissance(x+24, y+2);
			monde.naissance(x+24, y+3);
			monde.naissance(x+24, y+4);
			monde.naissance(x+24, y+5);
			monde.naissance(x+25, y);
			monde.naissance(x+25, y+1);
			monde.naissance(x+25, y+5);
			monde.naissance(x+25, y+6);
			
			monde.naissance(x+30, y+1);
			monde.naissance(x+30, y+2);
			
			monde.naissance(x+34, y+3);
			monde.naissance(x+34, y+4);
			monde.naissance(x+35, y+3);
			monde.naissance(x+35, y+4);
		}
		else
		{
			System.out.println("Le canon à planneurs dépasse de la grille, il n'a donc pas été instancié");
		}
	}
}
