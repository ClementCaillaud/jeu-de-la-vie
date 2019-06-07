package structures;

import jeu_de_la_vie.Monde;

public class GrainePulsar implements Structure
{
	private int largeur;
	private int hauteur;
	
	public GrainePulsar()
	{
		largeur = 5;
		hauteur = 2;
	}
	
	@Override
	public void ajouter(Monde monde, int x, int y)
	{
		if(x+largeur-1 < monde.get_largeur() && y+hauteur-1 < monde.get_hauteur())
		{
			monde.naissance(x, y);
			monde.naissance(x, y+1);
			monde.naissance(x+1, y);
			monde.naissance(x+2, y);
			monde.naissance(x+3, y);
			monde.naissance(x+4, y);
			monde.naissance(x+4, y+1);
		}
		else
		{
			System.out.println("La graine de pulsar dépasse de la grille, elle n'a donc pas été instanciée");
		}
	}

}
