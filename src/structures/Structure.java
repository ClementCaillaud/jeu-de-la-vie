package structures;

import jeu_de_la_vie.Monde;

public interface Structure
{
	/**
	 * Ajouter la structure dans le monde, le coin haut/gauche se situe aux coordonnées passées
	 * @param monde Le monde dans lequel ajouter la structure
	 * @param x La colonne du coin supérieur gauche
	 * @param y La ligne du coin supérieur gauche
	 */
	public void ajouter(Monde monde, int x, int y);
}
