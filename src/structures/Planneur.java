package structures;

import jeu_de_la_vie.Monde;

public class Planneur implements Structure
{
	@Override
	public void ajouter(Monde monde, int x, int y)
	{
		monde.naissance(x+1,y);
		monde.naissance(x,y+2);
		monde.naissance(x+1,y+2);
		monde.naissance(x+2,y+2);
		monde.naissance(x+2,y+1);
	}
}
