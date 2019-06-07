package jeu_de_la_vie;

import structures.Structure;

public class GrainePulsar implements Structure
{

	@Override
	public void ajouter(Monde monde, int x, int y)
	{
		monde.naissance(x, y);
		monde.naissance(x, y+1);
		monde.naissance(x+1, y);
		monde.naissance(x+2, y);
		monde.naissance(x+3, y);
		monde.naissance(x+4, y);
		monde.naissance(x+4, y+1);
	}

}
