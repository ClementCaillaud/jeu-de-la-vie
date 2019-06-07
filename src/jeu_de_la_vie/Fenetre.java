package jeu_de_la_vie;
import javax.swing.JFrame;

public class Fenetre extends JFrame
{
	public Fenetre(Monde monde)
	{
		super();
		setTitle("Jeu de la vie"); //On donne un titre à l'application
		setSize(800,1000); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		//JPanel panel = new JPanel();
		//monde.setLayout(new GridLayout(largeurGrille, hauteurGrille, 10, 10));
		setContentPane(monde);
	}
}
