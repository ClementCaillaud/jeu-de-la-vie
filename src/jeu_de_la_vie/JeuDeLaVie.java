package jeu_de_la_vie;
import javax.swing.SwingUtilities;

import structures.CanonPlanneur;
import structures.GrainePulsar;
import structures.Planneur;

public class JeuDeLaVie
{

	public static void main(String[] args)
	{
		//Création du monde
		Monde monde = new Monde(100, 100);
		//Création des différentes structures pouvant le composer
		Planneur p = new Planneur();
		CanonPlanneur cp = new CanonPlanneur();
		GrainePulsar gp = new GrainePulsar();
		
		//Ajout de structures dans le monde
		gp.ajouter(monde, 55, 50);
		cp.ajouter(monde, 4, 10);
		p.ajouter(monde, 40, 40);
		
		//Création de la fenêtre
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Fenetre fenetre = new Fenetre(monde);
				fenetre.setVisible(true);
			}
		});
		//Lancement de la simulation 
		Thread t1 = new Thread(monde);
		t1.start();
	}

}
