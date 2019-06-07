package jeu_de_la_vie;
import javax.swing.SwingUtilities;

import structures.CanonPlanneur;
import structures.Planneur;

public class JeuDeLaVie
{

	public static void main(String[] args)
	{
		
		Monde monde = new Monde(100, 100);
		
		Planneur planneur = new Planneur();
		CanonPlanneur cp = new CanonPlanneur();
		GrainePulsar gp = new GrainePulsar();
		
		gp.ajouter(monde, 40, 30);
		//cp.ajouter(monde, 4, 10);
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Fenetre fenetre = new Fenetre(monde);
				fenetre.setVisible(true);
			}
		});
		
		Thread t1 = new Thread(monde);
		t1.start();
	}

}
